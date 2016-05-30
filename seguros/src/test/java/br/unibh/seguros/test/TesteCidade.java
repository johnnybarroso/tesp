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
import br.unibh.seguros.entidades.Usuario;
import br.unibh.seguros.entidades.Tramitacao;
import br.unibh.seguros.entidades.Usuario;
import br.unibh.seguros.entidades.Vinculo;
import br.unibh.seguros.util.Resources;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteCidade {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test2.war")
				.addClasses(Resources.class, Dependente.class, Endereco.class, PessoaFisica.class, Proponente.class,
						Proposta.class, Questionario.class, Seguro.class, Usuario.class, Tramitacao.class, Usuario.class,
						Vinculo.class, Usuario.class, Setor.class, Cidade.class)
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
	public void teste01_incluirSemErro() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade c = new Cidade("MG", "Belo Horizonte");
		em.persist(c);
		Cidade aux = (Cidade) em.createQuery("select o from Cidade o where o.estado = :estado")
				.setParameter("estado", "MG").getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste02_inserirComErroValidation1() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Cidade c = new Cidade("MG", "3212312");
			em.persist(c);
		} catch (Exception e) {
			assertTrue(checkString(e, "Somente letras e espaços"));
		}
	}
	
	@Test
	public void teste04_atualizar() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade c = (Cidade) em.createQuery("select o from Cidade o where o.estado = :estado")
				.setParameter("estado", "MG").getSingleResult();
		c.setEstado("SP");
		em.flush();
		Cidade aux = (Cidade) em.createQuery("select o from Cidade o where o.estado = :estado")
				.setParameter("estado", "SP").getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste05_excluir() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade c = (Cidade) em.createQuery("select o from Cidade o where o.estado = :estado")
				.setParameter("estado", "SP").getSingleResult();
		em.remove(c);
		em.flush();
		assertEquals(em.createQuery("select o from Cidade o where o.estado = :estado")
				.setParameter("estado", "SP").getResultList().size(), 0);
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