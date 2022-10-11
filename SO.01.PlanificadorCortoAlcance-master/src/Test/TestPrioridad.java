/*---------------------- Algoritmo Prioridad ----------------------*/
//  Planificador de corto alcance (PCA)
//
// Es el principal planificador del Sistema Operativo, está continuamente 
// funcionando, es quien decide que proceso pasa a ejecutado, usa distintas 
// políticas o algoritmos, brinda cierta equidad.
// v1.2
// Autor: José Victor Ibáñez
/*------------------------- ------------- -------------------------*/

package Test;

import Model.admProcesamiento;
import Model.admTablaProcesos;
import Model.Prioridad;

public class TestPrioridad {

	public static void main(String[] args) {

		admProcesamiento admP1 = new admProcesamiento(20, 38);

		admP1.agregarProceso("P1", 1, 3, 2, 4, Prioridad.Media);
		admP1.agregarProceso("P2", 2, 2, 3, 2, Prioridad.Baja);
		admP1.agregarProceso("P3", 4, 4, 2, 1, Prioridad.Alta);
		admP1.agregarProceso("P4", 6, 1, 1, 1, Prioridad.Media);

		System.out.println("----------- Planificador Prioridad -----------");
		System.out.println(admP1.mostrarPlanificador(admP1.planificarPrioridad()));
		System.out.println(admP1.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados Prioridad -----------");
		admTablaProcesos admTP1 = new admTablaProcesos(admP1);
		System.out.println(admTP1.mostrarResultados(admP1.planificarPrioridad()));

	}

}
