package clases;

import java.util.HashMap;
import entidades.Estudiante;

public class ModeloDatos {
	
	HashMap<String, Estudiante> mapa;

    public ModeloDatos() {
        mapa = new HashMap<>();
    }

    // Registrar
    public String registrar(Estudiante e) {

        if (!mapa.containsKey(e.getDocumento())) {
            mapa.put(e.getDocumento(), e);
            return "Registrado correctamente";
        } else {
            return "Ya existe el estudiante";
        }
    }

    // Consultar
    public Estudiante consultar(String documento) {

        if (mapa.containsKey(documento)) {
            return mapa.get(documento);
        } else {
            return null;
        }
    }

    // Eliminar
    public String eliminar(String documento) {

        if (mapa.containsKey(documento)) {
            mapa.remove(documento);
            return "Estudiante eliminado";
        } else {
            return "No existe";
        }
    }

    // Actualizar
    public String actualizar(Estudiante e) {

        if (mapa.containsKey(e.getDocumento())) {
            mapa.put(e.getDocumento(), e);
            return "Actualizado correctamente";
        } else {
            return "No existe";
        }
    }

    // Listar
    public String listar() {

        String lista = "LISTA DE ESTUDIANTES\n\n";

        for (Estudiante e : mapa.values()) {

            lista += "Documento: " + e.getDocumento() + "\n";
            lista += "Nombre: " + e.getNombre() + "\n";
            lista += "Materia: " + e.getMateria() + "\n";
            lista += "Promedio: " + e.getPromedio() + "\n";
            lista += "Resultado: " + e.getResultado() + "\n";
            lista += "----------------------\n";
        }

        return lista;
    }
}
