package pe_51_75;

import java.math.BigInteger;
import java.util.ArrayList;

public class PE55 {
	
	private static final int MAX_ITERATION = 50;
	
	private ArrayList<Integer> lychrels = new ArrayList<Integer>();
	
	public PE55() {
		for (int i = 0; i < 10000; i++) {
			boolean isLychrel = true;
			BigInteger cur = new BigInteger(String.valueOf(i));
			for (int j = 0; j <= MAX_ITERATION; j++) {
				BigInteger inverse = new BigInteger(inverseOf(String.valueOf(cur)));
				cur = cur.add(inverse);
				if (i == 9999) {
				}
				if (cur.compareTo(new BigInteger(inverseOf(String.valueOf(cur)))) == 0) {
					isLychrel = false;
					break;
				}
			}
			if (isLychrel) {
				lychrels.add(i);
			}
		}
		System.out.println(lychrels.size());
	}

	private String inverseOf (String s){
		int m = s.length()/2;
		return m==0 ? s : inverseOf(s.substring(m)) + inverseOf(s.substring(0,m));
	}


}
