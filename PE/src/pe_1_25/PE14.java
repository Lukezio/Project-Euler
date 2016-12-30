package pe_1_25;

public class PE14 {

	/**
	 * Jedes mal wenn eine neue Zahl generiert wird, seine Länge in einer
	 * Arrayliste o.ä. reinschreiben um zu 1 zu gelangen: muss n/2 berechnen =>
	 * bis bestimmte höhe mit 2 multiplizieren
	 * 
	 * Überlegung: andersrum? In einem Set speichern, wo bereits gewesen - alle
	 * pfade irgendwann ausprobieren
	 * 
	 */

	long temp = 0;
	long max = 0;

	public PE14() {
		// for (int i = 0; i < a.length; i++) {
		// a[i] = 0;
		// }
		for (int i = 1; i < 1000; i++) {
			// System.out.println(i);
			temp = 0;
			calc(i);
		}
		System.out.println(max);
	}

	/**
	 * TODO: rekursiv: von 1 rückwärts. wenn zahl - 1 durch 3 teilbar ->
	 * rekursiver aufruf mit zahl und länge als parameter, sonst verdoppeln.
	 * checken ob vielfaches von 6 -> endlos
	 * 
	 * @param i
	 */
	private void calc(int i) {

	}

}
