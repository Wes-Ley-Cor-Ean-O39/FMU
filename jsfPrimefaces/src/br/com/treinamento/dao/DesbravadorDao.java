package br.com.treinamento.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.treinamento.entity.Desbravador;

public class DesbravadorDao {

	static EntityManagerFactory factory = null;

	public static void insertDesbravador(Desbravador desbravador) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		if (desbravador.getId() > 0) {
			em.merge(desbravador);
		} else {
			em.persist(desbravador);
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public static void alterarDesbravador(Desbravador desbravador){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge();
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public static void excluirDesbravador(Desbravador desbravador) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.getReference(Desbravador.class, desbravador.getId()));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static void excluirDesbravadorList(List<Desbravador> selecionadosDesbravador) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			for (Desbravador desbravador : selecionadosDesbravador) {
				em.remove(em.getReference(Desbravador.class, desbravador.getId()));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro no methodo excluirDesbravadorList:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static List<Desbravador> consultaAllDesbravador() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Desbravador> listDesbravador = null;
		try {
			Query query = em.createQuery("select j from Desbravador j order by id desc   ");
			listDesbravador = query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllDesbravador:" + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return listDesbravador;
	}

	public static List<String> complete(String nome) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Desbravador> listDesbravador = null;
		List<String> listReturn = new ArrayList<String>();
		try {
			Query query = em.createQuery("select j from Desbravador j where nome like '%" + nome
					+ "%' order by nome    ");
			listDesbravador = query.getResultList();
			for (Desbravador desbravador : listDesbravador) {
				listReturn.add(desbravador.getNome() + " #" + desbravador.getId());
			}
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllDesbravador:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}
		return listReturn;
	}

	public static Desbravador buscaDesbravadorById(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Desbravador> listDesbravador = null;
		Desbravador desbravadorReturn = null;
		try {
			Query query = em.createQuery("select j from Desbravador j where id =" + id + "    ");
			listDesbravador = query.getResultList();
			desbravadorReturn = listDesbravador.get(0);
		} catch (Exception e) {
			System.out.println("Erro no methodo buscaDesbravadorById:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

		return desbravadorReturn;
	}

	private static EntityManager getEntityManager() {

		EntityManager entityManager = null;
		try {
			// Obtém o factory a partir da unidade de persistência.
			factory = Persistence.createEntityManagerFactory("Treinamento");
			// Cria um entity manager.
			entityManager = factory.createEntityManager();
			// Fecha o factory para liberar os recursos utilizado.
		} finally {
			// factory.close();
		}
		return entityManager;
	}

}