package view;

import java.util.concurrent.Semaphore;

import controller.ThreadServidor;

public class ServidorEmFuncionamento {

	public static void main(String[] args) {

		int permissoes = 21;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idServidor = 1; idServidor < 21; idServidor++) {
			Thread servidor = new ThreadServidor(idServidor, semaforo);
			servidor.start();
			
		}

	}

}
