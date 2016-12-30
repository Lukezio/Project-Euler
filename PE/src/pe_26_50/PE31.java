package pe_26_50;


public class PE31 {
	// Indices 0 1 2 3 4 5 6 7
	static int betrag[] = { 1, 2, 5, 10, 20, 50, 100, 200 };
	static int n = betrag.length; // Anzahl Muenzen
	// # Wechselarten fuer Betrag g und Muenzen mit Indices <= i
	static long w[][]; // Tabelle

	static long w(int g, int i) { // Methode
		return g < 0 ? 0 : i == 0 ? (g % betrag[0] == 0 ? 1 : 0) : w[g][i] != 0 ? w[g][i] : (w[g][i] = w(g, i - 1) + w(g - betrag[i], i));
	}

	public PE31() {
		int g = 200;
		w = new long[g + 1][n]; // w dimensionieren
		System.out.println("Den Betrag " + g + " kann man auf " + w(g, n - 1) + " verschiedene Arten wecheln.");
	}

}
