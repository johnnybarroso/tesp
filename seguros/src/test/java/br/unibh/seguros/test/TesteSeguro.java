package br.unibh.seguros.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import br.unibh.seguros.entidades.Cidade;
import br.unibh.seguros.entidades.Dependente;
import br.unibh.seguros.entidades.Endereco;
import br.unibh.seguros.entidades.PessoaFisica;
import br.unibh.seguros.entidades.Proponente;
import br.unibh.seguros.entidades.Proposta;
import br.unibh.seguros.entidades.Questionario;
import br.unibh.seguros.entidades.Seguro;
import br.unibh.seguros.entidades.Setor;
import br.unibh.seguros.entidades.Tramitacao;
import br.unibh.seguros.entidades.Usuario;
import br.unibh.seguros.entidades.Vinculo;
import br.unibh.seguros.util.Resources;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteSeguro {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test2.war")
				.addClasses(Resources.class, Dependente.class, Endereco.class, PessoaFisica.class, Proponente.class,
						Proposta.class, Questionario.class, Seguro.class, Usuario.class, Tramitacao.class, Usuario.class,
						Vinculo.class, Usuario.class, Setor.class)
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	private Logger log;
	@Inject
	private EntityManager em;
	@Inject
	protected UserTransaction utx;

	@Before
	public void preparePersistenceTest() throws Exception {
		utx.begin();
		em.joinTransaction();
	}

	@After
	public void commitTransaction() throws Exception {
		try {
			utx.commit();
		} catch (Exception e) {
		}
	}

	@Test
	public void teste01_inserirSemErro() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Seguro s = new Seguro("123123", "Empresarial", "33333.0", "A", new Date(), new Date(), "12", "EM VIGOR", "9999.00", "5", "Santander", "2048", "012233669", null);
		em.persist(s);
		Seguro aux = (Seguro) em.createQuery("select o from Seguro o where o.codigoSusep = :codigoSusep")
				.setParameter("codigoSusep", "123123").getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste02_inserirComErroValidation1() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Seguro s = new Seguro("123123", "321312", "33333.0", "A", new Date(), new Date(), "12", "EM VIGOR", "9999.00", "5", "Santander", "2048", "012233669", null);
			em.persist(s);
		} catch (Exception e) {
			assertTrue(checkString(e, "Somente letras e espaços"));
		}
	}
	
	@Test
	public void teste03_atualizar() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Seguro s = (Seguro) em.createQuery("select o from Seguro o where o.codigoSusep = :codigoSusep")
				.setParameter("codigoSusep", "123123").getSingleResult();
		s.setCodigoSusep("321122");
		em.flush();
		Seguro aux = (Seguro) em.createQuery("select o from Seguro o where o.codigoSusep = :codigoSusep")
				.setParameter("codigoSusep", "321122").getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste04_excluir() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Seguro s = (Seguro) em.createQuery("select o from Seguro o where o.codigoSusep = :codigoSusep")
				.setParameter("codigoSusep", "321122").getSingleResult();
		em.remove(s);
		em.flush();
		assertEquals(em.createQuery("select o from Seguro o where o.codigoSusep = :codigoSusep")
				.setParameter("codigoSusep", "321122").getResultList().size(), 0);
	}
	
	@Test
	public void teste05_incluirUsuario() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Proponente p = new Proponente("Johnny Eugenio", "10969036140", "(31)3651-4563", "(31)3456-3245", "(31)9967-4269", "johnny@johnny.com", "21", new Date(), "1234567", new Date(), "ATIVO", "ONLINE", null, null, null, null, null);
		p.setMatricula("1234567");	
		em.persist(p);
		Proponente aux = (Proponente) em.createQuery("select o from Proponente o where o.matricula = :matricula")
				.setParameter("matricula", "1234567").getSingleResult();
		Seguro s = new Seguro("123123", "Empresarial", "33333.0", "A", new Date(), new Date(), "12", "EM VIGOR", "9999.00", "5", "Santander", "2048", "012233669", aux);
		em.persist(s);
		Seguro aux2 = (Seguro) em.createQuery("select o from Seguro o where o.codigoSusep = :codigoSusep")
				.setParameter("codigoSusep", "123123").getSingleResult();
		assertEquals(aux2.getProponente().getMatricula(), "1234567");
	}

	private boolean checkString(Throwable e, String str) {
		if (e.getMessage().contains(str)) {
			return true;
		} else if (e.getCause() != null) {
			return checkString(e.getCause(), str);
		}
		return false;
	}
}