package br.com.trabalho.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.trabalho.Cadastro;

public class CadastroDao {
	static EntityManagerFactory factory = null;

	public static void insertCadastro(Cadastro Cadastro) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		if (Cadastro.getId() > 0) {
			em.merge(Cadastro);
		} else {
			em.persist(Cadastro);
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public static void excluirCadastro(Cadastro Cadastro) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.getReference(Cadastro.class, Cadastro.getId()));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static void excluirCadastroList(List<Cadastro> selecionadosCadastro) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			for (Cadastro cadastro : selecionadosCadastro) {
				em.remove(em.getReference(Cadastro.class, cadastro.getId()));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro no methodo excluirCadastroList:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static List<Cadastro> consultaAllCadastro() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Cadastro> listCadastro = null;
		try {
			Query query = em.createQuery("select j from Cadastro j order by id desc   ");
			listCadastro = query.getResultList();

		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllCadastro:" + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return listCadastro;
	}

	public static List<String> complete(String empresa) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Cadastro> listCadastro = null;
		List<String> listReturn = new ArrayList<String>();
		try {
			Query query = em.createQuery("select j from Cadastro j where empresa like '%" + empresa + "%' order by empresa    ");
			listCadastro = query.getResultList();
			for (Cadastro Cadastro : listCadastro) {
				listReturn.add(Cadastro.getEmpresa() + " #" + Cadastro.getId());
			}
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllCadastro:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}
		return listReturn;
	}

	
	public static Cadastro buscaCadastroById(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Cadastro> listCadastro = null;
		Cadastro CadastroReturn = null;
		try {
			Query query = em.createQuery("select j from Cadastro j where id =" + id + "    ");
			listCadastro = query.getResultList();
			CadastroReturn = listCadastro.get(0);
		} catch (Exception e) {
			System.out.println("Erro no methodo buscaCadastroById:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

		return CadastroReturn;
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