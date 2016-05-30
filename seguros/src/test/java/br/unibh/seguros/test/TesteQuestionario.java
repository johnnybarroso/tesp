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
public class TesteQuestionario {
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
		Questionario q = new Questionario(false, false, new Date(), new Date(), true, false, false, false, false, false);
		em.persist(q);
		Questionario aux = (Questionario) em.createQuery("select o from Questionario o where o.portadorNescessidadesEspeciais = :portadorNescessidadesEspeciais")
				.setParameter("portadorNescessidadesEspeciais", new Character('N')).getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste03_atualizar() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Questionario q = (Questionario) em.createQuery("select o from Questionario o where o.portadorNescessidadesEspeciais = :portadorNescessidadesEspeciais")
				.setParameter("portadorNescessidadesEspeciais", new Character('N')).getSingleResult();
		q.setPortadorNescessidadesEspeciais(new Character('S'));
		em.flush();
		Questionario aux = (Questionario) em.createQuery("select o from Questionario o where o.portadorNescessidadesEspeciais = :portadorNescessidadesEspeciais")
				.setParameter("portadorNescessidadesEspeciais", new Character('S')).getSingleResult();
		assertNotNull(aux);
	}
	
	@Test
	public void teste04_excluir() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Questionario q = (Questionario) em.createQuery("select o from Questionario o where o.portadorNescessidadesEspeciais = :portadorNescessidadesEspeciais")
				.setParameter("portadorNescessidadesEspeciais", new Character('S')).getSingleResult();
		em.remove(q);
		em.flush();
		assertEquals(em.createQuery("select o from Questionario o where o.portadorNescessidadesEspeciais = :portadorNescessidadesEspeciais")
				.setParameter("portadorNescessidadesEspeciais", new Character('S')).getResultList().size(), 0);
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