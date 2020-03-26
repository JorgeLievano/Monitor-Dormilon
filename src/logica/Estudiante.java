package logica;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estudiante extends Thread{

	private Semaphore sMonitor,sSalaEspera;
	private Random aleat;
	private int id;
	
	public Estudiante(int id,Semaphore sMonitor,Semaphore sSalaEspera) {
		super();
		this.sMonitor=sMonitor;
		this.sSalaEspera=sSalaEspera;
		this.aleat=new Random();
		this.id=id;
	}
	
	public void run() {
		System.out.println("estudiante "+id+" Se creó");
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true) {
			try {
				//System.out.println("estudiante "+id+" necesita monitoria");
				sSalaEspera.acquire();
				System.out.println("estudiante "+id+" Esta en espera");
				sMonitor.acquire();
				sSalaEspera.release();
				System.out.println("estudiante "+id+" Esta con el monitor");
				sleep(10000);
				System.out.println("estudiante "+id+" Resolvió las dudas");
				sMonitor.release();
				//System.out.println("estudiante "+id+" va a Sala de computo");
				sleep(Math.abs(aleat.nextInt()* 1000) );
			}catch(InterruptedException e){
				
			}
		}
		
		
	}
	
	
	
}
