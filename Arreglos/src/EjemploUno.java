
class EjemploUno {

	public static void main(String[] args) {
		// CALCULAR EL PROMEDIO DE NOTAS
		
		int []notas =  {50,35,20,10};
		int suma =0;
		
		for (int i=0; i<notas.length;i++) {
			suma+= notas[i];
		}
		
		int promedio =suma / notas.length;
		
		System.out.println("El promedio de sus notas es: "+ promedio);

	}

}
