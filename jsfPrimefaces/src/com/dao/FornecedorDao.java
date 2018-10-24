/**
 * 
 */
/*
 * package com.dao;
 * 
 * import java.sql.DriverManager; import java.sql.PreparedStatement;
 * 
 * import com.mysql.jdbc.Connection;
 * 
 *//**
	 * @author jviei_000
	 *
	 */
/*
 * public class FornecedorDao {
 * 
 *//**
	 * @param args
	 *//*
		 * public static void main(String[] args) {
		 * 
		 * 
		 * System.out.println("entrei no methodo main"); //getConnection();
		 * insertFornecedorJpa(); }
		 * 
		 * public static void insertFornecedorJpa(){
		 * 
		 * }
		 * 
		 * public static Aluno buscaAlunoById(Integer id) { EntityManager em =
		 * getEntityManager(); em.getTransaction().begin(); List<Aluno> listAluno =
		 * null; Aluno alunoReturn = null; try { Query query =
		 * em.createQuery("select j from Aluno j where id =" + id + "    "); listAluno =
		 * query.getResultList(); alunoReturn = listAluno.get(0); } catch (Exception e)
		 * { System.out.println("Erro no methodo buscaAlunoById:" + e.getMessage()); }
		 * finally { em.close(); factory.close(); }
		 * 
		 * return alunoReturn; }
		 * 
		 * 
		 * public static void insertFornecedor(){ try { String query =
		 * " insert into users (first_name, last_name, date_created, is_admin, num_points)"
		 * + " values (?, ?, ?, ?, ?)";
		 * 
		 * // create the mysql insert
		 * preparedstatement............................................................
		 * .............................................................................
		 * .................. PreparedStatement preparedStmt =
		 * getConnection().prepareStatement(query); preparedStmt.setString (1,
		 * "Barney"); preparedStmt.setString (2, "Rubble"); // preparedStmt.setDate (3,
		 * startDate); preparedStmt.setBoolean(4, false); preparedStmt.setInt (5, 5000);
		 * 
		 * // execute the preparedstatement preparedStmt.execute();
		 * 
		 * // conn.close(); } catch (Exception e) {
		 * System.err.println("Got an exception!"); System.err.println(e.getMessage());
		 * }
		 * 
		 * }
		 * 
		 * public static Connection getConnection(){ Connection conn = null; try {
		 * Class.forName("com.mysql.jdbc.Driver"); System.out.println("Driver Loaded");
		 * conn = (Connection)
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/treinamento5","root"
		 * ,"admin"); System.out.println("Connected..."); } catch(Exception e) {
		 * e.printStackTrace(); } return conn; }
		 * 
		 * }
		 */