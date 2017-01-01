package pe_26_50;

import java.util.ArrayList;

public class PE26 {
	
	int longestProducer = 0;
	int longestCycle = 0;
	int cnt = 0;
	
	public PE26() {
		for (int i = 1; i < 1000; i++) {
			computeCycle(i);
		}
		System.out.println();
		System.out.println("Longest Cycle: " + longestCycle);
		System.out.println("Longest Producer: " + longestProducer);
	}
	
	private void computeCycle(int divisor) {
		int begin = 10;
		boolean noCycleDetected = true;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(noCycleDetected) {
			if (list.contains(begin)) {
				noCycleDetected = false;
				int curCycleLength = list.size() - searchIndexOf(list, begin, divisor);
				if (curCycleLength > longestCycle) {
					longestCycle = curCycleLength;
					longestProducer = divisor;
				}
			}
			
			list.add(begin);
			begin = begin - ((begin/divisor) * divisor);
			begin *= 10;
			
			if (begin == 0) {
				return;
			}
		}
	}
	
	

	private int searchIndexOf(ArrayList<Integer> list, int begin, int j) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == begin) {
				return i;
			}
		}
		return 0;
	}

}
