package pe_26_50;

import java.math.BigInteger;
import java.util.ArrayList;

public class PE43 {
	
	private int[] d = new int[10];
	private ArrayList<String> pandigitalNumbers = new ArrayList<String>();
	private ArrayList<Integer> usedDigits = new ArrayList<Integer>();
	
	public PE43() {
		for (int i = 0; i < d.length; i++) {
			d[i] = -1;
		}
		for (int i = 506; i < 600; i+=11) {
			String s = String.valueOf(i);
			if (i != 550) {
				d[5] = Integer.parseInt(s.substring(0, 1));
				d[6] = Integer.parseInt(s.substring(1, 2));
				d[7] = Integer.parseInt(s.substring(2, 3));
				usedDigits.add((Integer) d[5]);
				usedDigits.add(d[6]);
				usedDigits.add(d[7]);
				calcD8();
				usedDigits.remove((Integer) d[5]);
				usedDigits.remove((Integer) d[6]);
				usedDigits.remove((Integer) d[7]);
			}
		}
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < pandigitalNumbers.size(); i++) {
			sum = sum.add(new BigInteger(pandigitalNumbers.get(i)));
		}
		System.out.println(sum);
	}
	
	private void calcD8() {
		int cur = d[6] * 100 + d[7] * 10;
		int d8 = 13 - (cur%13);
		if (!usedDigits.contains(d8) && d8 <= 9) {
			d[8] = d8;
			usedDigits.add(d8);
			calcD9();
			usedDigits.remove((Integer) d[8]);
		}
	}
	
	private void calcD9() {
		int cur = d[7] * 100 + d[8] * 10;
		int d9 = 17 - (cur%17);
		if (!usedDigits.contains(d9) && d9 <= 9) {
			d[9] = d9;
			usedDigits.add(d9);
			calcD4();
			usedDigits.remove((Integer) d[9]);
		}
	}
	
	private void calcD4() {
		int cur = (d[5] * 10) + d[6];
		for (int i = 0; i <= 9; i++) {
			if ((i * 100 + cur) % 7 == 0 && !usedDigits.contains(i)) {
				d[4] = i;
				usedDigits.add(i);
				calcD3();
				usedDigits.remove((Integer) i);
			}
		}
	}

	private void calcD3() {
		for (int i = 0; i < 10; i+= 2) {
			if (!usedDigits.contains(i)) {
				d[3] = i;
				usedDigits.add(i);
				calcD2();
				usedDigits.remove((Integer) i);
			}
		}
	}
	
	private void calcD2() {
		int cur = (d[3] * 10) + d[4];
		for (int i = 0; i <= 9; i++) {
			if ((i * 100 + cur) % 3 == 0 && !usedDigits.contains(i)) {
				d[2] = i;
				usedDigits.add(i);
				calcRest();
				usedDigits.remove((Integer) i);
			}
		}
	}
	
	private void calcRest() {
		int a = -1;
		int b = -1;
		for (int i = 0; i <= 9; i++) {
			if (!usedDigits.contains(i)) {
				if (a == -1) {
					a = i;
				} else {
					b = i;
				}
			}
		}
		d[0] = a;
		d[1] = b;
		addNewString();
		d[0] = b;
		d[1] = a;
		addNewString();
	}
	
	private void addNewString() {
		String s = "";
		for (int i = 0; i < d.length; i++) {
			s += String.valueOf(d[i]);
		}
		if (!pandigitalNumbers.contains(s)) {
			pandigitalNumbers.add(s);			
		}
	}

}
