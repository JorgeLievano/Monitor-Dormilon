package logica;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Institucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*if (args.length != 1) {
			System.out.println("Sintaxis: MonitorDormilon semilla_aleatoria");
			System.exit(1);
		}*/
		
		//long Semilla=Long.parseLong(args[0]);
		
		Semaphore monitor, salaEspera;
		
		ArrayList<Estudiante>  estudiantes=new ArrayList<Estudiante>();
		
		//Estudiante est1,est2,est3,est4,est5,est6;
		
		
		monitor= new Semaphore(1,true);
		salaEspera= new Semaphore(3,true);
		
		for (int i=1; i<7;i++) {
			Estudiante est=new Estudiante(i, monitor, salaEspera);
			estudiantes.add(est);
		}
		
		
		for(Estudiante e: estudiantes) {
			e.start();
		}
		
		
	}

}
