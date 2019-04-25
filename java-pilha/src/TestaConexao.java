
public class TestaConexao {

	public static void main(String[] args) throws Exception {

		/*
		 * try (Conexao conexao = new Conexao()) { conexao.leDados(); } catch
		 * (IllegalStateException ex) { System.out.println("Deu erro na conexão"); }
		 */

		Conexao con = null;
		try {
			con = new Conexao();
			con.leDados();
		} catch (IllegalStateException ex) {
			System.out.println("Deu erro na conexão");
		} finally {
			con.close();
		}

	}

}
