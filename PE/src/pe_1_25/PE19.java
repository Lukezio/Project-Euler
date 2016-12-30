package pe_1_25;

public class PE19 {
	
	//beginnt mit dienstag 1. 01. 1901
	
	int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int monthFirstDay = 1; //Dienstag. Montag hat index 0
	int beginYear = 1901;
	int endYear = 2000;
	
	public PE19() {
		int counter = 0;
		for (int i = beginYear; i <= endYear; i++) {
			for (int j = 0; j < months.length; j++) {
				int curDays = months[j];
				if (j == 1 && i % 4 == 0 && (!(i % 100 == 0) || i % 400 == 0)) {
					curDays++;
				}
				monthFirstDay = (monthFirstDay + curDays) % 7;
				if (monthFirstDay == 6) {
					System.out.println(i + ". jahr, " + j + " monat ");
					counter++;
				}
			}
		}
		System.out.println(counter);
	}

}
