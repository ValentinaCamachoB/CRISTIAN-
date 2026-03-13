package data;

import java.util.HashMap;

import logica.Operador;

public class ModeloDatos {
	
	HashMap <String, Operador> mapaOperador;
	
	public ModeloDatos () {
		mapaOperador =new HashMap<String, Operador>();
	}
	
	public String registrarOperador(Operador ope) {
		
		if(mapaOperador.containsKey(ope.getDocumento())== false) {
			mapaOperador.put(ope.getDocumento(),ope);
			return "si";
		}else {
			System.out.println("Ya existe la persona");
			return "no";
		}
	}
		
		public  Operador consultarOperadorPorDocumento(String documento) {
			
			Operador operaTemporal=null;
			if (mapaOperador.containsKey(documento)){
				operaTemporal=mapaOperador.get(documento);
			} 
			return operaTemporal;
		}
		
			public void ConsultarOperadorLista() {
				System.out.println("LISTA OPERADORES");
				System.out.println();
				System.out.println(mapaOperador);
							}
		
	
		}


