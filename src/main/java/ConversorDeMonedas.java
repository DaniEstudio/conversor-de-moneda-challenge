import javax.swing.JOptionPane;

public class ConversorDeMonedas {
	private static final double PESO_A_DOLAR = 0.0052;

	public static void main(String[] args) {
		String opcionElegida = menu();
		double cantidad = getCantidad();
		double resultado = conversion(opcionElegida, cantidad);
		mostrarTotal(opcionElegida, cantidad, resultado);
	}
	public static void mostrarTotal(String opcion, double cantidad, double resultado) {
		String mensaje = cantidad + " pesos equivale a " + resultado + " dólares";
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public static String menu() {
		String[] listaPesoA = { "---", "De Peso a Dólar"};

		// Dialogo
		String getOpcionPesoA = (String) JOptionPane.showInputDialog(null, "¿Qué conversión necesita hacer?",
				"Conversor", JOptionPane.QUESTION_MESSAGE, null, listaPesoA, listaPesoA[0]);
		
		while(!opcionSeleccionadaValida(getOpcionPesoA)) {
			getOpcionPesoA = (String) JOptionPane.showInputDialog(null, "Porfavor seleccione una opcion",
					"Conversor", JOptionPane.WARNING_MESSAGE, null, listaPesoA, listaPesoA[0]);
		}
		
		return getOpcionPesoA;

	}
	//Validador
	public static boolean opcionSeleccionadaValida(String opcion) {
		return opcion != "---";
	}
	
	public static double getCantidad() {
		String input = JOptionPane.showInputDialog("Ingrese la cantidad a convertir");
		double cantidad = Double.parseDouble(input);
		while(!numIngresadoValido(cantidad)) {
			input = JOptionPane.showInputDialog(null, "Por favor ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
			cantidad = Double.parseDouble(input);
		}
		return cantidad;
	}
	
	//Validador
	public static boolean numIngresadoValido(double valor) {
		return valor > 0;
	}
	
	public static double conversion(String opcion, double cantidad) {
		double total = 0;
		
		if(opcion.equals("De Peso a Dólar")) {
			total = pesoADolar(cantidad);
		}
		return total;
	}
	
	public static double pesoADolar(double cantidad) {
		return cantidad * PESO_A_DOLAR;
	}

}
