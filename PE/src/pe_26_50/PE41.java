package pe_26_50;

import java.util.HashSet;

import PrimeGenerator.PrimeGenerator;

public class PE41 {
	
	public PE41() {
		PrimeGenerator pg = new PrimeGenerator();
		pg.generatePrimesTo(1000000000);
		for (int i = pg.getPrimes().size() - 1; i > 0; i--) {
			long curPrime = pg.getPrimes().get(i);
			if (isPandigital(curPrime)) {
				System.out.println(curPrime);
				return;
			}
		}
	}

	private boolean isPandigital(long i) {
		String s = String.valueOf(i);
		HashSet<String> digits = new HashSet<String>();
		for (int j = 0; j < s.length(); j++) {
			if (digits.contains(s.substring(j, j + 1))) {
				return false;
			} else {
				digits.add(s.substring(j, j + 1));
			}
		}
		return true;
	}

}
