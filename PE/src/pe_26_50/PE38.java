package pe_26_50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PE38 {
	
	ArrayList<Integer> usedDigits = new ArrayList<Integer>();
	ArrayList<Integer> candidates = new ArrayList<Integer>();
	String currentString = "";
	
	public PE38() {
		
		for (int i = 1; i < 10000; i++) {
			for (int j = 1; j < 10; j++) {
				int cur = i * j;
				if (!canAdd(cur, i)) {
					usedDigits.clear();
					currentString = "";
					break;
				}
				if (currentString.length() == 9) {
					if (!currentString.contains("0")) {
						candidates.add(Integer.parseInt(currentString));						
					}
					usedDigits.clear();
					currentString = "";
					break;
				}
			}
		}
		
		Collections.sort(candidates);
		Collections.reverse(candidates);
		System.out.println(candidates.get(0));
		System.out.println(candidates.size());
		
	}

	private boolean canAdd(int product, int l) {
		String cur = String.valueOf(product);
		for (int i = 0; i < cur.length(); i++) {
			
			int curInt = Integer.parseInt(cur.substring(i, i + 1));
			if (!usedDigits.contains(curInt)) {
				usedDigits.add(curInt);
				currentString += String.valueOf(curInt);
			} else {
				return false;
			}
		}
		return true;
	}

}
