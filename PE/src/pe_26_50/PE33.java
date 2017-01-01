package pe_26_50;

public class PE33 {
	
	int denomWithoutDigit;
	int numWithoutDigit;
	int denomsMultiplied = 1;
	
	public PE33() {
		for (int denominator = 11; denominator < 100; denominator++) {
			for (int numinator = 10; numinator < denominator; numinator++) {
				String denomS = String.valueOf(denominator);
				String numS = String.valueOf(numinator);
				if (containSameDigit(numS, denomS) && denominator%10 != 0 && numinator%10 != 0) {
					if (denomWithoutDigit * numinator == numWithoutDigit * denominator) {
						System.out.println(numinator + "/" + denominator + " und: " + numWithoutDigit + "/" + denomWithoutDigit);
						denomsMultiplied *= denomWithoutDigit;
					}
				}
			}
		}
	}
	
	private boolean containSameDigit(String n, String d) {
		for (int i = 0; i < n.length(); i++) {
			for (int j = 0; j < d.length(); j++) {
				if (n.substring(i , i + 1).equals(d.substring(j, j + 1))) {
					if (i == 0) {
						numWithoutDigit = Integer.parseInt(n.substring(1));
					} else {
						numWithoutDigit = Integer.parseInt(n.substring(0, 1));
					}
					if (j == 0) {
						denomWithoutDigit= Integer.parseInt(d.substring(1));
					} else {
						denomWithoutDigit = Integer.parseInt(d.substring(0, 1));
					}
					return true;
				}
			}
		}
		return false;
	}

}
