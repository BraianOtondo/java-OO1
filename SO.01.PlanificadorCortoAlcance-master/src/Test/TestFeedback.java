/*----------------------- Algoritmo Feedback ----------------------*/
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

public class TestFeedback {

	public static void main(String[] args) {

		admProcesamiento admP1 = new admProcesamiento(20, 38);

		admP1.agregarProceso("P1", 1, 3, 1, 2, Prioridad.Media);
		admP1.agregarProceso("P2", 2, 3, 3, 2, Prioridad.Baja);
		admP1.agregarProceso("P3", 3, 4, 2, 5, Prioridad.Alta);
		admP1.agregarProceso("P4", 6, 1, 1, 1, Prioridad.Media);
		admP1.agregarProceso("P5", 7, 4, 5, 5, Prioridad.Alta);
		admP1.agregarProceso("P6", 8, 1, 3, 1, Prioridad.Media);


		System.out.println("----------- Planificador Feedback -----------");
		System.out.println(admP1.mostrarPlanificador(admP1.planificarFeedback()));
		System.out.println(admP1.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados Feedback -----------");
		admTablaProcesos admTP = new admTablaProcesos(admP1);
		System.out.println(admTP.mostrarResultados(admP1.planificarFeedback()));

	}

}
