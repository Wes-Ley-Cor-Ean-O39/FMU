package br.com.desbravador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.desbravador.entity.Cidade;
import br.com.desbravador.entity.Estado;

public class CidadeDao {
	static EntityManagerFactory factory = null;

	public static List<Cidade> consultaCidadesByEstado(String siglaEstado) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Cidade> listCidade = null;
		try {
			Query query = em
					.createQuery("select j from Cidade j where siglaEstado = :siglaEstado order by descricaoCidade ");
			query.setParameter("siglaEstado", siglaEstado);
			listCidade = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaCidadesByEstado:" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			factory.close();
		}

		return listCidade;
	}
	
	public static List<Estado> consultaEstados() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Estado> listEstado = null;
		try {
			Query query = em.createQuery("select j from Estado j   ");
			listEstado = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaEstado:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}

		return listEstado;
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