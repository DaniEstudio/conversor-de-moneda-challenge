import javax.swing.JOptionPane;

public class ConversorDeMonedas {
	//TODO conversor de temperaturas
	
	//Un peso es equivalente a 0.0052 dolares
	private static final double PESO_A_DOLAR = 0.0052;
	//Un dolar es equivalente a 195.30 pesos
	private static final double DOLAR_A_PESO = 195.30;
	private static final double PESO_A_LIBRA_ESTERLINA = 0.0043;
	private static final double LIBRA_ESTERLINA_A_PESO = 234.74;
	private static final double PESO_A_EURO = 0.0048;
	private static final double EURO_A_PESO = 207.04;
	private static final double PESO_A_YEN = 0.69;
	private static final double YEN_A_PESO = 1.45;
	private static final double PESO_A_WON = 6.65;
	private static final double WON_A_PESO = 0.15;
	
	// Método que ejecuta la logica del programa
	public static void main(String[] args) {
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		String[] opcionesMenu = { "Conversor de Moneda", "Conversor de Temperatura" };
		//Dialogo
		String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de conversión:",
				"Conversor", JOptionPane.QUESTION_MESSAGE, null, opcionesMenu, opcionesMenu[0]);

		if (opcionSeleccionada.equals("Conversor de Moneda")) {
			conversorDeMoneda();
		} 
		if (opcionSeleccionada.equals("Conversor de Temperatura")) {
			conversorDeTemperatura();
		}
	}

	public static void conversorDeMoneda() {
		String opcionElegida = menuOpcionesMoneda();
		if (opcionElegida == null) {
			return;
		}
		double cantidad = getCantidad();
		double resultado = conversion(opcionElegida, cantidad);
		mostrarTotal(opcionElegida, cantidad, resultado);
		dialogoContinuar();//acá pregunto si quiere continuar convirtiendo monedas
		
	}
	
	public static String menuOpcionesMoneda() {
		String[] listaPesoA = { 
				"---",
				"De Peso a Dólar",
				"De Dólar a Peso",
				"De Peso a Euro",
				"De Euro a Peso",
				"De Peso a Libra Esterlina",
				"De Libra Esterlina a Peso",
				"De Peso a Yen Japonés",
				"De Yen Japonés a Peso",
				"De Peso a Won Sul-Coreano",
				"De Won Sul-Coreano a Peso"
		};

		// Dialogo
		String getOpcionPesoA = (String) JOptionPane.showInputDialog(null, "¿Qué conversión necesita hacer?",
				"Conversor", JOptionPane.QUESTION_MESSAGE, null, listaPesoA, listaPesoA[0]);

		while (!opcionSeleccionadaValida(getOpcionPesoA)) {
			getOpcionPesoA = (String) JOptionPane.showInputDialog(null, "Porfavor seleccione una opcion", "Conversor",
					JOptionPane.WARNING_MESSAGE, null, listaPesoA, listaPesoA[0]);
		}

		return getOpcionPesoA;

	}
	
	public static double getCantidad() {
	    double cantidad = 0;
	    try {//si todo va bien esto es lo que debería hacer
	        String input = JOptionPane.showInputDialog("Ingrese la cantidad a convertir"); //le pido al usuario que ingrese la cantidad que desea convertir
	        cantidad = Double.parseDouble(input);//a la cantidad obtenida y guardada en la variable "input" dal tipo String la paso al tipo double
	        while (!numIngresadoValido(cantidad)) {
	            input = JOptionPane.showInputDialog(null, "Por favor ingrese una cantidad válida.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	            cantidad = Double.parseDouble(input);
	        }
	    } catch (NullPointerException e) {//si el usuario cierra la ventana o la cancela
	        dialogoContinuar();
	    }
	    return cantidad;
	}
	
	
	public static double conversion(String opcion, double cantidad) {
		double total = 0;
	

		if (opcion.equals("De Peso a Dólar")) {
			total = pesoADolar(cantidad);
		}
		if(opcion.equals("De Dólar a Peso")){
			total = dolarAPeso(cantidad);
		}
		if(opcion.equals("De Peso a Euro")) {
			total = pesoAEuro(cantidad);
		}
		if(opcion.equals("De Euro a Peso")) {
			total = euroAPeso(cantidad);
		}
		if(opcion.equals("De Peso a Libra Esterlina")) {
			total = pesoALibraE(cantidad);
		}
		if(opcion.equals("De Libra Esterlina a Peso")) {
			total = libraEAPeso(cantidad);
		}
		if(opcion.equals("De Peso a Yen Japonés")) {
			total = pesoAYen(cantidad);
		}
		if(opcion.equals("De Yen Japonés a Peso")) {
			total = yenAPeso(cantidad);
		}
		if(opcion.equals("De Peso a Won Sul-Coreano")) {
			total = pesoAWon(cantidad);
		}
		if(opcion.equals("De Won Sul-Coreano a Peso")) {
			total = wonAPeso(cantidad);
		}
		return total;
	}

	public static void mostrarTotal(String opcion, double cantidad, double resultado) {
		String mensaje = "";
		String frase = "Tienes $";

		
		if(opcion == "De Peso a Dólar") {			
			mensaje = frase + resultado + " Dólares";
		}
		if(opcion == "De Dólar a Peso") {
			mensaje = frase + resultado + " Pesos";
		}
		if(opcion == "De Peso a Euro") {
			mensaje = frase + resultado + " Euros";
		}
		if(opcion == "De Euro a Peso") {
			mensaje = frase + resultado + " Pesos";
		}
		if(opcion == "De Peso a Libra Esterlina") {
			mensaje= frase + resultado + " Libras Esterlinas";
		}
		if(opcion == "De Libra Esterlina a Peso") {
			mensaje = frase + resultado+ " Pesos";
		}
		if(opcion == "De Peso a Yen Japonés") {
			mensaje = frase + resultado + " Yenes";
		}
		if(opcion == "De Yen Japonés a Peso") {
			mensaje = frase + resultado + " Pesos";
		}
		if(opcion == "De Peso a Won Sul-Coreano") {
			mensaje = frase + resultado + " Wones";
		}
		if(opcion == "De Won Sul-Coreano a Peso") {
			mensaje = frase + resultado + " Pesos";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void dialogoContinuar() {
		int input = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
		
		if(input == 0) {
			conversorDeMoneda();
		}else {
			JOptionPane.showMessageDialog(null, "Programa Finalizado");
			System.exit(0);//Indico al sistema que se debe cerrar la aplicación con un código de salida de 0 (el programa terminó correctamente)
		}
	}

	// Validadores
	public static boolean opcionSeleccionadaValida(String opcion) {
		return opcion != "---";
	}
	
	public static boolean numIngresadoValido(Double valor) {
	    return valor != null && !Double.isNaN(valor) && valor > 0;
	}
	
	//Calculos segun opción de conversion elegida
	public static double pesoADolar(double cantidad) {
		return cantidad * PESO_A_DOLAR;
	}
	
	public static double dolarAPeso(double cantidad) {
		return  cantidad * DOLAR_A_PESO;
	}
	
	public static double pesoAEuro(double cantidad) {
		return cantidad * PESO_A_EURO;
	}
	
	public static double euroAPeso(double cantidad) {
		return cantidad * EURO_A_PESO;
	}
	
	public static double pesoALibraE(double cantidad) {
		return cantidad * PESO_A_LIBRA_ESTERLINA;
	}
	
	public static double libraEAPeso(double cantidad) {
		return cantidad * LIBRA_ESTERLINA_A_PESO;
	}
	
	public static double pesoAYen(double cantidad) {
		return cantidad * PESO_A_YEN;
	}
	
	public static double yenAPeso(double cantidad) {
		return cantidad * YEN_A_PESO;
	}
	
	public static double pesoAWon(double cantidad) {
		return cantidad * PESO_A_WON;
	}
	
	public static double wonAPeso(double cantidad) {
		return cantidad * WON_A_PESO;
	}

	/* ==== CONVERSOR DE TEMPERATURAS ==== */
	public static void conversorDeTemperatura() {

	}

}
