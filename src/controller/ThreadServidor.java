package controller;

import java.util.concurrent.Semaphore;

public class ThreadServidor extends Thread{

	private int idServidor;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadServidor(int idServidor, Semaphore semaforo) {
		this.idServidor = idServidor;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		ServidorAndando();
		try {
			semaforo.acquire();
			ServidorParado();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
			ServidorDesligado();
		}
	}
	
	private void ServidorAndando() {
		
		double calculo = 1.0;
		double transacao = 1.0;

		try {
			if(idServidor % 3 == 1 ) {
				double tempoInicial = 2000;
				double tempoFinal = 1000;
				while(tempoInicial < tempoFinal) {
					sleep((long) tempoInicial);
					calculo++;
					transacao++;
					System.out.println("#" + idServidor + " Calculou: " + calculo);
					System.out.println("#" + idServidor + " Transação: " + calculo);
			    }
				posChegada++;
				System.out.println("#" + idServidor + " foi o " + posChegada + " o. a terminar");
				
			} else if(idServidor % 3 == 2) {
				double tempoInicial = 5000;
				double tempoFinal = 15000;
				while(tempoInicial < tempoFinal) {
					sleep((long) tempoInicial);
					calculo++;
					transacao++;
					System.out.println("#" + idServidor + " Calculou: " + calculo);
					System.out.println("#" + idServidor + " Transação: " + calculo);
				}
				posChegada++;
				System.out.println("#" + idServidor + " foi o " + posChegada + " o. a terminar");
				
			} else if(idServidor % 3 == 0) {
				double tempoInicial = 1000;
				double tempoFinal = 2000;
				while(tempoInicial < tempoFinal) {
					sleep((long) tempoInicial);
					calculo++;
					transacao++;
					System.out.println("#" + idServidor + " Calculou: " + calculo);
					System.out.println("#" + idServidor + " Transação: " + calculo);
				}
				posChegada++;
				System.out.println("#" + idServidor + " foi o " + posChegada + " o. a terminar");
			}
	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
					
	}
	
	private void ServidorParado() {
		System.out.println("#" + idServidor + " parou");
		int tempo = (int) ((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void ServidorDesligado() {
		posSaida++;
		System.out.println("#" + idServidor + "foi o " + posSaida + "o. a desligar");
	}
}
