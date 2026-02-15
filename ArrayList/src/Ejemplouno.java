import java.util.ArrayList;

public class Ejemplouno {

	public static void main(String[] args) {
		ArrayList<String> tareas = new ArrayList<>();

        //LISTA DE TAREAS PENDIENTES
        tareas.add("Estudiar Java");
        tareas.add("Hacer ejercicio");
        tareas.add("Leer libro");
        tareas.add("Llamar a mama");
        System.out.println(tareas);

        System.out.println("Hay " + tareas.size() + " tareas pendientes");
        System.out.println();

        
        System.out.println("Complete la primer tarea");
        tareas.remove("Estudiar Java");
        System.out.println("Tareas que quedan por hacer: " + tareas);


	}

}
