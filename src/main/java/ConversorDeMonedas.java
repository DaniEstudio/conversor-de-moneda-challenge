import javax.swing.JOptionPane;

public class ConversorDeMonedas {

	public static void main(String[] args) {
		String opcionElegida = mensaje();
		conversion(opcionElegida);
	}

	public static String mensaje() {
	    String[] elegirPesosA = { "Elegir una Opcion", "De Peso a Dólar", "De Peso a Euro", "De Peso a Libras",
	            "De Peso a Yen", "De Peso a Won Coreano", "De Dólar a Peso", "De Euro a Peso", "De Libra a Peso", "De Yen a Peso", "De Won Coreano a Peso"};

	    String getOpcionesPesosA = (String) JOptionPane.showInputDialog(null, "¿Qué conversion necesita hacer?",
	            "Conversor", JOptionPane.QUESTION_MESSAGE, null, elegirPesosA, elegirPesosA[0]);

	    return getOpcionesPesosA;
	}
	
	public static void conversion(String opcion) {
	    double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a convertir: "));
	    double resultado = 0;

	    if (opcion.equals("De Peso a Dólar")) {
	        resultado = Math.round(cantidad * 192.307692) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " pesos equivale a " + resultado + " dólares");
	    } else if (opcion.equals("De Peso a Euro")) {
	        resultado = Math.round(cantidad * 3.90625) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " pesos equivale a " + resultado + " euros");
	    } else if (opcion.equals("De Peso a Libras")) {
	        resultado = Math.round(cantidad * 3.378378378) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " pesos equivale a " + resultado + " libras");
	    } else if (opcion.equals("De Peso a Yen")) {
	        resultado = Math.round(cantidad * 4761.90476) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " pesos equivale a " + resultado + " yenes");
	    } else if (opcion.equals("De Peso a Won Coreano")) {
	        resultado = Math.round(cantidad * 526.315789) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " pesos equivale a " + resultado + " wones coreanos");
	    } else if (opcion.equals("De Dólar a Peso")) {
	        resultado = Math.round(cantidad * 192.307692) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " dólares equivale a " + resultado + " pesos");
	    } else if (opcion.equals("De Euro a Peso")) {
	        resultado = Math.round(cantidad * 25.6) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " euros equivale a " + resultado + " pesos");
	    } else if (opcion.equals("De Libra a Peso")) {
	        resultado = Math.round(cantidad * 29.6) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " libras equivale a " + resultado + " pesos");
	    } else if (opcion.equals("De Yen a Peso")) {
	        resultado = Math.round(cantidad * 0.21) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " yenes equivale a " + resultado + " pesos");
	    } else if (opcion.equals("De Won Coreano a Peso")) {
	        resultado = Math.round(cantidad * 0.019) / 100.0;
	        JOptionPane.showMessageDialog(null, cantidad + " wones coreanos equivale a " + resultado + " pesos");
	    }
	}


}
