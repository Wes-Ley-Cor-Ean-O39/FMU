package br.com.alura.threads.banheiro;

public class TarefaNumero1 implements Runnable {

	private Banheiro banheiro;

    public TarefaNumero1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        this.banheiro.fazNumero1();
    }
	
}
