package br.unibh.seguros.negocio;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.unibh.seguros.entidades.Proponente;

@Stateless
@LocalBean
public class ServicoProponente implements DAO<Proponente, Long> {
	@Inject
	EntityManager em;
	@Inject
	private Logger log;

	@Override
	public Proponente insert(Proponente t) throws Exception {
		log.info("Persistindo " + t);
		em.persist(t);
		return t;
	}

	@Override
	public Proponente update(Proponente t) throws Exception {
		log.info("Atualizando " + t);
		return em.merge(t);
	}

	@Override
	public void delete(Proponente t) throws Exception {
		log.info("Removendo " + t);
		Object c = em.merge(t);
		em.remove(c);
	}

	@Override
	public Proponente find(Long k) throws Exception {
		log.info("Encontrando " + k);
		return em.find(Proponente.class, k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proponente> findAll() throws Exception {
		log.info("Encontrando todos os proponentes");
		return em.createQuery("from Proponente").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proponente> findByName(String matricula) throws Exception {
		log.info("Encontrando o " + matricula);
		return em.createNamedQuery("Proponente.findByName").setParameter("matricula", matricula + "%").getResultList();
	}
}