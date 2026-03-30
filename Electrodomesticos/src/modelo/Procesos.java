package modelo;

import controlador.Coordinador;

public class Procesos {
	
	private Coordinador coordinador;
	 
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
 
    /*
     * Valida que el texto no sea vacío ni un número
     */
    public boolean validarTexto(String valor) {
        try {
            // Si se puede convertir a número, NO es texto válido
            Double.parseDouble(valor.trim());
            return false;
        } catch (Exception e) {
            // Si entra acá es porque es texto (no número)
            if (valor.trim().equals("")) {
                return false;
            } else {
                return true;
            }
        }
    }
 
    /*
     * Valida que el valor sea un número entero positivo mayor que 0
     */
    public boolean validarEnteroPositivo(String valor) {
        try {
            int n = Integer.parseInt(valor.trim());
            if (n > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
 
    /*
     * Valida que el valor sea un número decimal mayor o igual a 0
     */
    public boolean validarDecimal(String valor) {
        try {
            double n = Double.parseDouble(valor.trim());
            if (n >= 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
 
    /*
     * Valida que el tipo sea A, B, C o vacío (sin tipo)
     */
    public boolean validarTipo(String valor) {
        String t = valor.trim().toUpperCase();
        if (t.equals("A") || t.equals("B") || t.equals("C") || t.equals("")) {
            return true;
        } else {
            return false;
        }
    }
 
    /*
     * Calcula el descuento según el tipo del cliente:
     * A = 40%, B = 20%, C = 10%, sin tipo = 0%
     * Retorna un arreglo: [totalSinDescuento, montoDescuento, totalConDescuento]
     */
    public double[] calcularCompra(String tipo, double valorUnitario, int cantidad) {
        double totalSin = valorUnitario * cantidad;
        double porcentaje = 0;
 
        if (tipo.equalsIgnoreCase("A")) {
            porcentaje = 0.40;
        } else if (tipo.equalsIgnoreCase("B")) {
            porcentaje = 0.20;
        } else if (tipo.equalsIgnoreCase("C")) {
            porcentaje = 0.10;
        }
 
        double montoDescuento = totalSin * porcentaje;
        double totalCon = totalSin - montoDescuento;
 
        return new double[]{totalSin, montoDescuento, totalCon};
    }
 
    /*
     * Retorna el texto del descuento para mostrar en pantalla
     */
    public String textoDescuento(String tipo) {
        if (tipo.equalsIgnoreCase("A")) {
            return "Descuento del 40%";
        } else if (tipo.equalsIgnoreCase("B")) {
            return "Descuento del 20%";
        } else if (tipo.equalsIgnoreCase("C")) {
            return "Descuento del 10%";
        } else {
            return "No se le realiza descuento";
        }
    }

}
