//Jorge Lievano
//Leonardo Franco

package logica;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Institucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// se declaran lo semaforos que coordinan las interacciones
		Semaphore monitor, salaEspera;
		
		// se inicializa una lista para un numero n de estudiantes
		ArrayList<Estudiante>  estudiantes=new ArrayList<Estudiante>();
		
		// se instancia el semaforo del monitor como binario para representar su estado ocupado/libre
		monitor= new Semaphore(1,true);
		// se instancia el semaforo de la sala de espera con n permisos segun el numero de sillas
		salaEspera= new Semaphore(3,true);
		
		//se instancian y agregan a la lista los estudiantes
		for (int i=1; i<7;i++) {
			Estudiante est=new Estudiante(i, monitor, salaEspera);
			estudiantes.add(est);
		}
		
		
		//se inician los hilos de cada estudiante
		for(Estudiante e: estudiantes) {
			e.start();
		}
		
		
	}

}
