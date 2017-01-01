package pe_26_50;

import java.math.BigInteger;

public class PE48 {
	
	public BigInteger a[] = new BigInteger[1000];
	
	public PE48() {
		for (int i = 1; i <= 1000; i++) {
			a[i - 1] = calcSelfPower(i, i);
		}
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < a.length; i++) {
			sum = sum.add(a[i]);
		}
		String sumString = String.valueOf(sum);
		System.out.println(sumString.substring(sumString.length() - 10));
	}
	
	private BigInteger calcSelfPower(int base, int power) {
		if (power == 1) {
			return new BigInteger(String.valueOf(base));
		}
		BigInteger a = calcSelfPower(base, power/2);
		if (power % 2 == 0) {
			return a.multiply(a);
		}
		if (power % 2 == 1) {
			return a.multiply(a.multiply(calcSelfPower(base, 1)));
		}
		return BigInteger.ONE;
	}

}
