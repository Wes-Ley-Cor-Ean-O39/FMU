package br.com.alura.threads;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Isso � uma Thread!");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
