//Jorge Lievano
//Leonardo Franco

package logica;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estudiante extends Thread{

	// se declara la la relacion de cada estudiante con los semaforos 
	private Semaphore sMonitor,sSalaEspera;
	// se declara un generador de numeros aleatorios
	private Random aleat;
	// identificador del estudiante
	private int id;
	
	// constructor con todos los argumentos para uns estudiante
	public Estudiante(int id,Semaphore sMonitor,Semaphore sSalaEspera) {
		super();
		this.sMonitor=sMonitor;
		this.sSalaEspera=sSalaEspera;
		this.aleat=new Random();
		this.id=id;
	}
	
	
	// metodo principal del hilo de cada estudiante
	public void run() {
		System.out.println("estudiante "+id+" Se creó");
		//los estudiantes recien creados esperan 1s para tomar acción
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// repetitivo infinito
		while(true) {
			try {
				// el estudiante revisa la sala de espera y pide un cupo
				sSalaEspera.acquire();
				System.out.println("estudiante "+id+" Esta en espera");
				// si hay cupos en la sala de espera el estudiante asegura su turno con el monitor
				sMonitor.acquire();
				// una vez obtiene turno con el monitor se libera un cupo de la sala de espera 
				sSalaEspera.release();
				// el estudiante y el monitor se ocupan durante un tiempo
				System.out.println("estudiante "+id+" Esta con el monitor");
				sleep(10000);
				// una vez el estudiante resuelve sus dudas deja libre al monitor
				System.out.println("estudiante "+id+" Resolvió las dudas");
				sMonitor.release();
				//el monitor se va y tendra dudas en un tiempo
				sleep(Math.abs(aleat.nextInt()* 1000) );
			}catch(InterruptedException e){
				
			}
		}
		
		
	}
	
	
	
}
