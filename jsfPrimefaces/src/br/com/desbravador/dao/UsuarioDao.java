package br.com.desbravador.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.desbravador.entity.Usuario;

public class UsuarioDao {

	static EntityManagerFactory factory = null;

	public boolean existe(Usuario usuario) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Usuario> query = em
				.createQuery(
						"select u from Usuario u where u.email = :pEmail and u.senha = :pSenha",
						Usuario.class);

		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());

		try {
			Usuario resultado = query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}

		em.close();

		return true;
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
