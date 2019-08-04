package br.com.alura.thread.buscatext;

public class Principal {

	public static void main(String[] args) {

		String nome = "da";
		
		Thread threadAssinatura1 = new Thread(new TarefaBusca("assinaturas1.txt", nome));
		Thread threadAssinatura2 = new Thread(new TarefaBusca("assinaturas2.txt", nome));
		Thread threadAutores = new Thread(new TarefaBusca("autores.txt", nome));
		
		threadAssinatura1.start();
		threadAssinatura2.start();
		threadAutores.start();
		
	}
	
}
