
public class TestaBanco {

	public static void main(String[] args) {

		Cliente kin = new Cliente();

		kin.nome = "Wesley";
		kin.cpf = "489764218/33";
		kin.profissao = "Analista de Sistemas";

		Conta contaDoKin = new Conta();

		contaDoKin.deposita(100);

		contaDoKin.titular = kin;
		System.out.println(contaDoKin.titular.nome);
		System.out.println(contaDoKin.titular);

	}
}
