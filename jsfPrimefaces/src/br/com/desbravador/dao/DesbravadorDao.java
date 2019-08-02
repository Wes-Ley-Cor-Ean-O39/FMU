package br.com.desbravador.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.desbravador.entity.Desbravador;
import br.com.desbravador.exception.DesbravadorException;
import br.com.desbravador.jpa.JPAUtil;

public class DesbravadorDao {

	private static final Logger LOGGER = LogManager.getLogger(DesbravadorDao.class.getName());
	//static EntityManagerFactory factory = null;

	public static void insertDesbravador(Desbravador desbravador) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		if (desbravador.getId() > 0) {
			em.merge(desbravador);
		} else {
			em.persist(desbravador);
		}
		em.getTransaction().commit();
		em.close();
		//factory.close();
	}

	public static void alterarDesbravador(Desbravador desbravador) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(desbravador);
		} catch (DesbravadorException e) {
			LOGGER.info("Erro ao alterar desbravador! " + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close(); 
			//factory.close();
		}
	}

	public static void excluirDesbravador(Desbravador desbravador) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.getReference(Desbravador.class, desbravador.getId()));
			em.getTransaction().commit();
		} catch (DesbravadorException e) {
			LOGGER.info("Erro ao excluir o Desbravador: " + e.getMessage());
		} finally {
			em.close();
			//factory.close();
		}
	}

	public static void excluirDesbravadorList(List<Desbravador> selecionadosDesbravador) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();
			for (Desbravador desbravador : selecionadosDesbravador) {
				em.remove(em.getReference(Desbravador.class,
						desbravador.getId()));
			}
			em.getTransaction().commit();
		} catch (DesbravadorException e) {
			LOGGER.info("Erro ao excluir Desbravador na Lista: " + e.getMessage());
		} finally {
			em.close();
			//factory.close();
		}
	}

	public static List<Desbravador> consultaAllDesbravador() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Desbravador> listDesbravador = null;
		try {
			Query query = em
					.createQuery("select j from Desbravador j order by id desc   ");
			listDesbravador = query.getResultList();

		} catch (DesbravadorException e) {
			LOGGER.info("Erro ao Consultar Desbravador: " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return listDesbravador;
	}

	public static List<String> complete(String nome) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		List<Desbravador> listDesbravador = null;
		List<String> listReturn = new ArrayList<String>();
		try {
			Query query = em
					.createQuery("select j from Desbravador j where nome like '%"
							+ nome + "%' order by nome    ");
			listDesbravador = query.getResultList();
			for (Desbravador desbravador : listDesbravador) {
				listReturn.add(desbravador.getNome() + " #"
						+ desbravador.getId());
			}
		} catch (DesbravadorException e) {
			LOGGER.info("Erro no methodo consultaAllDesbravador: " + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			//factory.close();
		}
		return listReturn;
	}

	public static Desbravador buscaDesbravadorById(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		List<Desbravador> listDesbravador = null;
		Desbravador desbravadorReturn = null;
		try {
			Query query = em
					.createQuery("select j from Desbravador j where id =" + id
							+ "    ");
			listDesbravador = query.getResultList();
			desbravadorReturn = listDesbravador.get(0);
		} catch (DesbravadorException e) {
			LOGGER.info("Erro no methodo buscaDesbravadorById: " + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			//factory.close();
		}

		return desbravadorReturn;
	}

	/*
	 * private static EntityManager getEntityManager() {
	 * 
	 * EntityManager entityManager = null; try { // Obtém o factory a partir da
	 * unidade de persistência. factory =
	 * Persistence.createEntityManagerFactory("Treinamento"); // Cria um entity
	 * manager. entityManager = factory.createEntityManager(); // Fecha o
	 * factory para liberar os recursos utilizado. } finally { //
	 * factory.close(); } return entityManager; }
	 */

}