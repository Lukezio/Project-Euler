package pe_26_50;


public class PE34 {
	
	int[] facs = new int[10];
	int globalSum = 0;
	
	public PE34() {
		for (int i = 0; i < facs.length; i++) {
			facs[i] = calcFac(i);
		}
		for (int i = 3; i < 1000000; i++) {
			String curSelectedNumber = String.valueOf(i);
			int curSum = 0;
			for (int j = 0; j < curSelectedNumber.length(); j++) {
				curSum += facs[Integer.parseInt(curSelectedNumber.substring(j, j+1))];
			}
			if (curSum == i) {
				globalSum += curSum;
			}
		}
		System.out.println(globalSum);
	}
	
	private int calcFac(int number) {
		int fac = 1;
		for (int j = 1; j <= number; j++) {
			fac = fac * j;
		}
		return fac;
	}

}
