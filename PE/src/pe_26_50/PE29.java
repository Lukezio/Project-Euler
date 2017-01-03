package pe_26_50;

import java.math.BigInteger;
import java.util.HashSet;

public class PE29 {
	
	HashSet<BigInteger> terms;
	
	public PE29() {
		terms = new HashSet<BigInteger>();
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				BigInteger cur = calcPowerOf(i, j);
				if (!terms.contains(cur)) {
					terms.add(cur);
				}
			}
		}
		System.out.println(terms.size());
	}

	private BigInteger calcPowerOf(int base, int power) {
		if (power == 1) {
			return new BigInteger(String.valueOf(base));
		}
		BigInteger a = calcPowerOf(base, power/2);
		if (power % 2 == 0) {
			return a.multiply(a);
		}
		if (power % 2 == 1) {
			return a.multiply(a.multiply(calcPowerOf(base, 1)));
		}
		return BigInteger.ONE;
	}

}
