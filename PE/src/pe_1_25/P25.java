package p_1_25;

import java.math.BigInteger;

public class P25 {

	public P25() {

		BigInteger b = new BigInteger("1");
		BigInteger a0 = new BigInteger("0");
		BigInteger a1 = new BigInteger("1");
		int index = 1;
		while (String.valueOf(a1).length() < 1000) {
			b = a1;
			a1 = a1.add(a0);
			a0 = b;
			index++;
		}
		System.out.println(a1);
		System.out.println(index);

	}

}
