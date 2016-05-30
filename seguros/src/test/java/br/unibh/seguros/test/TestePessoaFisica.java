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
public class TestePessoaFisica {
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
		PessoaFisica pf = new PessoaFisica("Johnny", "11111111111", "(31)3422-2222", "(31)3333-3333", "(31)9999-9999", "johnny@johnny.com", "23", new Date());
		em.persist(pf);
		PessoaFisica aux = (PessoaFisica) em.createQuery("select o from PessoaFisica o where o.nome = :nome")
				.setParameter("nome", "Johnny").getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste02_inserirComErroValidation1() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			PessoaFisica pf = new PessoaFisica("31213123", "11111111111", "(31)3422-2222", "(31)3333-3333", "(31)9999-9999", "johnny@johnny.com", "23", new Date());
			em.persist(pf);
		} catch (Exception e) {
			assertTrue(checkString(e, "Deve conter apenas letras e espaços"));
		}
	}
	
	@Test
	public void teste03_atualizar() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		PessoaFisica pf = (PessoaFisica) em.createQuery("select o from PessoaFisica o where o.nome = :nome")
				.setParameter("nome", "Johnny").getSingleResult();
		pf.setNome("Gilmar");
		em.flush();
		PessoaFisica aux = (PessoaFisica) em.createQuery("select o from PessoaFisica o where o.nome = :nome")
				.setParameter("nome", "Gilmar").getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste04_excluir() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		PessoaFisica pf = (PessoaFisica) em.createQuery("select o from PessoaFisica o where o.nome = :nome")
				.setParameter("nome", "Gilmar").getSingleResult();
		em.remove(pf);
		em.flush();
		assertEquals(em.createQuery("select o from PessoaFisica o where o.nome = :nome")
				.setParameter("nome", "Gilmar").getResultList().size(), 0);
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