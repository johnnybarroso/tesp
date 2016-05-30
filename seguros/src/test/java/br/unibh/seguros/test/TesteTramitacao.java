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
import br.unibh.seguros.entidades.Usuario;
import br.unibh.seguros.entidades.Tramitacao;
import br.unibh.seguros.entidades.Usuario;
import br.unibh.seguros.entidades.Vinculo;
import br.unibh.seguros.util.Resources;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteTramitacao {
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
	public void teste01_incluirSemErro() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Tramitacao t = new Tramitacao("Final", new Date(), "Iniciante", "Habilitado", "Sempre Alerta", "Nao tem", null, null, null, null, null);
		em.persist(t);
		Tramitacao aux = (Tramitacao) em.createQuery("select o from Tramitacao o where o.etapaProcesso = :etapaProcesso")
				.setParameter("etapaProcesso", "Final").getSingleResult();
		assertNotNull(aux);
	}
	
	
	@Test
	public void teste02_inserirComErroValidation1() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Tramitacao t = new Tramitacao("321321321", new Date(), "Iniciante", "Habilitado", "Sempre Alerta", "Nao tem", null, null, null, null, null);
			em.persist(t);
		} catch (Exception e) {
			assertTrue(checkString(e, "Somente letras e espaços"));
		}
	}
	
	
	@Test
	public void teste03_atualizar() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Tramitacao t = (Tramitacao) em.createQuery("select o from Tramitacao o where o.etapaProcesso = :etapaProcesso")
				.setParameter("etapaProcesso", "Final").getSingleResult();
		t.setEtapaProcesso("Inicial");
		em.flush();
		Tramitacao aux = (Tramitacao) em.createQuery("select o from Tramitacao o where o.etapaProcesso = :etapaProcesso")
				.setParameter("etapaProcesso", "Inicial").getSingleResult();
		assertNotNull(aux);
	}
	
	
	@Test
	public void teste04_excluir() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Tramitacao t = (Tramitacao) em.createQuery("select o from Tramitacao o where o.etapaProcesso = :etapaProcesso")
				.setParameter("etapaProcesso", "Inicial").getSingleResult();
		em.remove(t);
		em.flush();
		assertEquals(em.createQuery("select o from Tramitacao o where o.etapaProcesso = :etapaProcesso")
				.setParameter("etapaProcesso", "Inicial").getResultList().size(), 0);
	}
	@Test
	public void teste05_incluirUsuario() throws Exception {
		log.info("============> Executando " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Setor s = new Setor();
		s.setNome("Tecnologia da Informação");
		em.persist(s);
		Setor aux1 = (Setor) em.createQuery("select o from Setor o where o.nome = :nome")
				.setParameter("nome", "Tecnologia da Informação").getSingleResult();
		
		Usuario u = new Usuario("Johnny Eugenio", "12345678", "12345678", "Administrador", "Estagiario", "johnnybarroso711@hotmail.com", new Date(), null);
		em.persist(u);
		Usuario aux2 = (Usuario) em.createQuery("select o from Usuario o where o.nome = :nome")
				.setParameter("nome", "Johnny Eugenio").getSingleResult();
		
		Questionario q = new Questionario(false, false, new Date(), new Date(), true, false, false, false, false, false);
		em.persist(q);
		Proposta p = new Proposta(java.sql.Date.valueOf("2014-09-11"), "Carro", "1200.0", "B", java.sql.Date.valueOf("2014-09-11"), java.sql.Date.valueOf("2015-09-11"), "22", "Ativo", "1999.0", "5", "Santander", "3126", "010233996", q, null, null, null, null);
		em.persist(p);
		Proposta aux3 = (Proposta) em.createQuery("select o from Proposta o where o.tipoSegurado = :tipoSegurado")
				.setParameter("tipoSegurado", "Carro").getSingleResult();
		
		Tramitacao t1 = new Tramitacao("Final", new Date(), "Iniciante", "Habilitado", "Sempre Alerta", "Nao tem", null, aux3, aux1, aux2, null);
		em.persist(t1);
		
		Tramitacao aux5 = (Tramitacao) em.createQuery("select o from Tramitacao o where o.etapaProcesso = :etapaProcesso")
			.setParameter("etapaProcesso", "Final").getSingleResult();
		assertEquals(aux5.getPropostas().getTipoSegurado(), "Carro");
		assertEquals(aux5.getSetorResponsavel().getNome(), "Tecnologia da Informação");
		assertEquals(aux5.getUsuarioDecisao().getNome(), "Johnny Eugenio");
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