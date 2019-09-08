package br.com.alura.threads.banheiro;

public class TarefaLimpeza implements Runnable {

	Banheiro banheiro = new Banheiro();

	public TarefaLimpeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		while (true) {
			this.banheiro.limpa();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
