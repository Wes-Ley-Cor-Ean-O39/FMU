package br.com.trabalho.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.trabalho.Escola;

public class EscolaDao {
	static EntityManagerFactory factory = null;

	public static void insertEscola(Escola escola) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		if (escola.getId() > 0) {
			em.merge(escola);
		} else {
			em.persist(escola);
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public static void excluirEscola(Escola escola) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.getReference(Escola.class, escola.getId()));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static void excluirEscolaList(List<Escola> selecionadosEscola) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			for (Escola escola : selecionadosEscola) {
				em.remove(em.getReference(Escola.class, escola.getId()));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro no methodo excluirEscolaList:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static List<Escola> consultaAllEscola() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FMU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Escola> listEscola = null;
		try {
			Query query = em.createQuery("select j from Escola j order by id desc   ");
			listEscola = query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllEscola:" + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return listEscola;
	}

	public static List<String> complete(String nome) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Escola> listEscola = null;
		List<String> listReturn = new ArrayList<String>();
		try {
			Query query = em.createQuery("select j from Escola j where nome like '%" + nome + "%' order by nome    ");
			listEscola = query.getResultList();
			for (Escola escola : listEscola) {
				listReturn.add(escola.getNome() + " #" + escola.getId());
			}
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllEscola:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}
		return listReturn;
	}

	public static Escola buscaEscolaById(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Escola> listEscola = null;
		Escola escolaReturn = null;
		try {
			Query query = em.createQuery("select j from Escola j where id =" + id + "    ");
			listEscola = query.getResultList();
			escolaReturn = listEscola.get(0);
		} catch (Exception e) {
			System.out.println("Erro no methodo buscaEscolaById:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

		return escolaReturn;
	}

	private static EntityManager getEntityManager() {

		EntityManager entityManager = null;
		try {
			// Obtém o factory a partir da unidade de persistência.
			factory = Persistence.createEntityManagerFactory("FMU");
			// Cria um entity manager.
			entityManager = factory.createEntityManager();
			// Fecha o factory para liberar os recursos utilizado.
		} finally {
			// factory.close();
		}
		return entityManager;
	}

}