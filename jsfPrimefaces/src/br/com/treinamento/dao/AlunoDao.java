package br.com.treinamento.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.treinamento.entity.Aluno;
import br.com.treinamento.entity.Escola;
import br.com.treinamento.entity.Nota;
import br.com.treinamento.entity.Salaaula;

public class AlunoDao {

	static EntityManagerFactory factory = null;

	public static void insertAluno(Aluno aluno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if (aluno.getId() > 0) {
			em.merge(aluno);
		} else {
			em.persist(aluno);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void insertNota(Nota nota) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if (nota.getId() > 0) {
			em.merge(nota);
		} else {
			em.persist(nota);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public static void excluirAluno(Aluno aluno) {
		
		List<Nota> listNotas =  buscaNotasByIdAluno(aluno.getId());
		
		
		EntityManager em = getEntityManager();
		try {
			
			em.getTransaction().begin();
			if(listNotas.size() > 0) {
				for (Nota nota : listNotas) {
					em.remove(em.getReference(Nota.class, nota.getId()));
				}
			}
			
			em.remove(em.getReference(Aluno.class, aluno.getId()));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static void excluirAlunoList(List<Aluno> selecionadosAluno) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			for (Aluno aluno : selecionadosAluno) {
				em.remove(em.getReference(Aluno.class, aluno.getId()));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro no methodo excluirAlunoList:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static void excluirNotas(List<Nota> list) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			for (Nota nota : list) {
				em.remove(em.getReference(Nota.class, nota.getId()));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}
	}

	public static List<Aluno> consultarAllAluno() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Aluno> listAluno = null;
		try {
			Query query = em.createQuery("select j from Aluno j order by id desc   ");
			listAluno = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaAllAluno:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}

		return listAluno;
	}

	public static List<Nota> buscaNotasByIdAluno(int idAluno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Nota> listNota = null;
		try {
			Query query = em.createQuery("select j from Nota j where aluno.id = :idAluno  order by  id desc");
			query.setParameter("idAluno", idAluno);
			listNota = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro no methodo buscaNotasByIdAluno:" + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return listNota;
	}

	public static List<Escola> consultaEscola() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Escola> listEscola = null;
		try {
			Query query = em.createQuery("select j from Escola j   ");
			listEscola = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaNotasByIdAluno:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}

		return listEscola;
	}

	public static List<Escola> consultaAllEscola() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
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

	public static List<Salaaula> consultaSalaAulaByIdEscola(int idEscola) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Salaaula> listSalaaula = null;
		try {
			Query query = em.createQuery("select j from Salaaula j where idEscola = :idEscola ");
			query.setParameter("idEscola", idEscola);
			listSalaaula = query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro no methodo consultaSalaAulaByIdEscola:" + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return listSalaaula;
	}

	public List<String> complete(String nome, int idEscola) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Treinamento");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Aluno> listAluno = null;
		List<String> listReturn = new ArrayList<String>();
		try {
			Query query = em.createQuery("select j from Aluno j where nome like '%" + nome
					+ "%'  and salaaula.escola.id  =  :idEscola  order by nome    ");
			query.setParameter("idEscola", idEscola);
			listAluno = query.getResultList();
			for (Aluno aluno : listAluno) {
				listReturn.add(aluno.getNome() + " #" + aluno.getId());
			}
		} catch (Exception e) {
			System.out.println("Erro no methodo complete:" + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return listReturn;
	}

	public static Aluno buscaAlunoById(Integer id) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Aluno> listAluno = null;
		Aluno alunoReturn = null;
		try {
			Query query = em.createQuery("select j from Aluno j where id =" + id + "    ");
			listAluno = query.getResultList();
			alunoReturn = listAluno.get(0);
		} catch (Exception e) {
			System.out.println("Erro no methodo buscaAlunoById:" + e.getMessage());
		} finally {
			em.close();
			factory.close();
		}

		return alunoReturn;
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
