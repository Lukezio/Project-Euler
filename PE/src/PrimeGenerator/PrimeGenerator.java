package PrimeGenerator;

import java.util.ArrayList;


public class PrimeGenerator {
	
	private boolean numbers[];
	ArrayList<Long> primes = new ArrayList<Long>();
	
	public void generatePrimesTo(int index) {
		numbers = new boolean[index + 1];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = false;
			
		}
		System.out.println("Initialisierung");
		long t = System.currentTimeMillis();
		for (int i = 2; i < numbers.length; i++) {
			if (!numbers[i]) {
				primes.add((long) i);
				markMultiples(i);
			}
		}
		System.out.println("Generiert!");
	}
	
	private void markMultiples(int i) {
		for (int j = i; j < numbers.length; j+= i) {
			numbers[j] = true;
		}
	}

	public ArrayList<Long> getPrimes() {
		return primes;
	}

}
