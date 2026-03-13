package logica;

public class Procesos {
	
	public void calcularSueldoNuevo (Operador operador) {
		
		double porcentaje=0;
		
		if (operador.getSueldo()<500 && operador.getAntiguedad()>=10) {
			porcentaje=0.2;
		}else if (operador.getSueldo()<500 && operador.getAntiguedad()<10) {
			porcentaje=0.05;
		}else if (operador.getSueldo()>=500) {
			porcentaje=0;
		}
		
		double aumento=operador.getSueldo()*porcentaje;
		double sueldoNuevo=operador.getSueldo()+aumento;
		
		operador.setSueldoNuevo(sueldoNuevo);
		operador.setAumento(porcentaje*100);
	}

}
