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
public class TesteDependente {
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
		Dependente dp = new Dependente("Julia Eugenio", "11233354444", "(31)3333-3333", "(31)2222-2222", "(31)9999-9999", "juliaeugenio@julia.com", "20", java.sql.Date.valueOf("2014-09-11"), "Filha", "13.0", null, null);
		em.persist(dp);
		Dependente aux = (Dependente) em.createQuery("select o from Dependente o where o.grauParentesco = :grauParentesco")
				.setParameter("grauParentesco", "Filha").getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste02_inserirComErroValidation1() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Dependente dp = new Dependente("Julia Eugenio", "11233354444", "(31)3333-3333", "(31)2222-2222", "(31)9999-9999", "juliaeugenio@julia.com", "20", java.sql.Date.valueOf("2014-09-11"), "32131231", "13.0", null, null);
			em.persist(dp);
		} catch (Exception e) {
			assertTrue(checkString(e, "Somente letras e espaços"));
		}
	}
	
	
	@Test
	public void teste03_atualizar() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Dependente dp = (Dependente) em.createQuery("select o from Dependente o where o.grauParentesco = :grauParentesco")
				.setParameter("grauParentesco", "Filha").getSingleResult();
		dp.setGrauParentesco("Neta");
		em.flush();
		Dependente aux = (Dependente) em.createQuery("select o from Dependente o where o.grauParentesco = :grauParentesco")
				.setParameter("grauParentesco", "Neta").getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste04_excluir() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Dependente dp = (Dependente) em.createQuery("select o from Dependente o where o.grauParentesco = :grauParentesco")
				.setParameter("grauParentesco", "Neta").getSingleResult();
		em.remove(dp);
		em.flush();
		assertEquals(em.createQuery("select o from Dependente o where o.grauParentesco = :grauParentesco")
				.setParameter("grauParentesco", "Neta").getResultList().size(), 0);
	}
	
	
	@Test
	public void teste05_incluirUsuario() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Proponente p = new Proponente("Johnny Eugenio", "10969036140", "(31)3651-4563", "(31)3456-3245", "(31)9967-4269", "johnny@johnny.com", "21", java.sql.Date.valueOf("2014-09-11"), "1234567", java.sql.Date.valueOf("2014-09-11"), "ATIVO", "ONLINE", null, null, null, null, null);
		p.setMatricula("1234567");	
		em.persist(p);
		Proponente aux = (Proponente) em.createQuery("select o from Proponente o where o.matricula = :matricula")
				.setParameter("matricula", "1234567").getSingleResult();
		Dependente dp = new Dependente("Julia Eugenio", "11233354444", "(31)3333-3333", "(31)2222-2222", "(31)9999-9999", "juliaeugenio@julia.com", "20", java.sql.Date.valueOf("2014-09-11"), "Filha", "13.0", null, aux);
		em.persist(dp);
		Dependente aux2 = (Dependente) em.createQuery("select o from Dependente o where o.grauParentesco = :grauParentesco")
				.setParameter("grauParentesco", "Filha").getSingleResult();
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