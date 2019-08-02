package br.com.desbravador.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.desbravador.entity.Fornecedor;

public class FornecedorDao {
	static EntityManagerFactory factory = null;

	public static void insertFornecedor(Fornecedor fornecedor) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		if (fornecedor.getId() > 0) {
			em.merge(fornecedor);
		} else {
			em.persist(fornecedor);
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public static void excluirFornecedor(Fornecedor fornecedor) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.getReference(Fornecedor.class, fornecedor.getId()));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static void excluirFornecedorList(List<Fornecedor> selecionadosFornecedor) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			for (Fornecedor fornecedor : selecionadosFornecedor) {
				em.remove(em.getReference(Fornecedor.class, fornecedor.getId()));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro no methodo excluirFornecedorList:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static List<Fornecedor> consultaAllFornecedor() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Fornecedor> listFornecedor = null;
		try {
			Query query = em.createQuery("select j from Fornecedor j order by id desc   ");
			listFornecedor = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllFornecedor:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

		return listFornecedor;
	}

	public static List<String> complete(String razaoSocial) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Fornecedor> listFornecedor = null;
		List<String> listReturn = new ArrayList<String>();
		try {
			Query query = em.createQuery("select j from Fornecedor j where razaoSocial like '%" + razaoSocial + "%' order by razaoSocial    ");
			listFornecedor = query.getResultList();
			for (Fornecedor fornecedor : listFornecedor) {
				listReturn.add(fornecedor.getRazaoSocial() + " #" + fornecedor.getId());
			}
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllFornecedor:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}
		return listReturn;
	}

	public static Fornecedor buscaFornecedorById(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Fornecedor> listFornecedor = null;
		Fornecedor fornecedorReturn = null;
		try {
			Query query = em.createQuery("select j from Fornecedor j where id =" + id + "    ");
			listFornecedor = query.getResultList();
			fornecedorReturn = listFornecedor.get(0);
		} catch (Exception e) {
			System.out.println("Erro no methodo buscaFornecedorById:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

		return fornecedorReturn;
	}

	private static EntityManager getEntityManager() {

		EntityManager entityManager = null;
		try {
			// Obt�m o factory a partir da unidade de persist�ncia.
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