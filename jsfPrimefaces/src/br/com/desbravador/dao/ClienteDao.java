package br.com.desbravador.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.desbravador.entity.Cliente;

public class ClienteDao {
	static EntityManagerFactory factory = null;

	public static void insertCliente(Cliente cliente) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		if (cliente.getId() > 0) {
			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public static void excluirCliente(Cliente cliente) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.getReference(Cliente.class, cliente.getId()));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static void excluirClienteList(List<Cliente> selecionadosCliente) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			for (Cliente cliente : selecionadosCliente) {
				em.remove(em.getReference(Cliente.class, cliente.getId()));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro no methodo excluirClienteList:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static List<Cliente> consultaAllCliente() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Cliente> listCliente = null;
		try {
			Query query = em.createQuery("select j from Cliente j order by id desc   ");
			listCliente = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllCliente:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

		return listCliente;
	}

	public static List<String> complete(String nome) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Cliente> listCliente = null;
		List<String> listReturn = new ArrayList<String>();
		try {
			Query query = em.createQuery("select j from Cliente j where nome like '%" + nome + "%' order by nome    ");
			listCliente = query.getResultList();
			for (Cliente cliente : listCliente) {
				listReturn.add(cliente.getNome() + " #" + cliente.getId());
			}
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllCliente:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}
		return listReturn;
	}

	public static Cliente buscaClienteById(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Cliente> listCliente = null;
		Cliente clienteReturn = null;
		try {
			Query query = em.createQuery("select j from Cliente j where id =" + id + "    ");
			listCliente = query.getResultList();
			clienteReturn = listCliente.get(0);
		} catch (Exception e) {
			System.out.println("Erro no methodo buscaClienteById:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

		return clienteReturn;
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