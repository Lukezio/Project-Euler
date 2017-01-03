package pe_76_100;

public class PE92 {
	
	public PE92() {
		int cnt = 0;
		for (int i = 2; i < 10000000; i++) {
			int temp = i;
			do {
				String cur = String.valueOf(temp);
				temp = 0;
				for (int j = 0; j < cur.length(); j++) {
					int digit = Integer.parseInt(cur.substring(j, j+1));
					temp += (digit * digit);
				}
				if (temp == 89) {
					cnt++;
				}
			} while (temp != 1 && temp != 89);
			
		}
		System.out.println(cnt);
	}

}
