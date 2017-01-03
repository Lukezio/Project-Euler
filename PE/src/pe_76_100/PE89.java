package pe_76_100;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PE89 {

	ArrayList<String> lines = new ArrayList<String>();
	ArrayList<String> decimals = new ArrayList<String>();

	public PE89() {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				"pe89.txt")))) {
			String line;
			while ((line = br.readLine()) != null) {
					decimals.add(line);
					int num = 0;
					for (int j = 0; j < line.length(); j++) {
						String cur = line.substring(j, j + 1);
						switch (cur) {
						case "M":
							num += 1000;
							break;

						case "D":
							num += 500;
							break;

						case "C":
							if (j != line.length() - 1
									&& line.substring(j + 1, j + 2).equals("D")) {
								num += 400;
								j++;
								break;
							}
							if (j != line.length() - 1
									&& line.substring(j + 1, j + 2).equals("M")) {
								num += 900;
								j++;
								break;
							}
							num += 100;
							break;

						case "L":
							num += 50;
							break;

						case "X":
							if (j != line.length() - 1
									&& line.substring(j + 1, j + 2).equals("C")) {
								num += 90;
								j++;
								break;
							}
							if (j != line.length() - 1
									&& line.substring(j + 1, j + 2).equals("L")) {
								num += 40;
								j++;
								break;
							}
							num += 10;
							break;

						case "V":
							num += 5;
							break;

						default:
							if (j != line.length() - 1
									&& line.substring(j + 1, j + 2).equals("V")) {
								num += 4;
								j++;
								break;
							}
							if (j != line.length() - 1
									&& line.substring(j + 1, j + 2).equals("X")) {
								num += 9;
								j++;
								break;
							}
							num++;
							break;
						}
					}
				
				lines.add(String.valueOf(num));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int cnt = 0;
		for (int i = 0; i < lines.size(); i++) {
			cnt += decimals.get(i).length();
			cnt -= minimize(lines.get(i)).length();
		}
		System.out.println(cnt);
	}

	private String minimize(String s) {
		String cur = "";
		for (int i = 0; i < s.length(); i++) {
			cur += substitute(s.substring(i, i + 1), s.length() - i);
		}
		return cur;
	}

	private String substitute(String s, int i) {
		switch (s) {
		case "1":
			return (i == 4 ? "M" : (i == 3 ? "C" : (i == 2 ? "X" : "I")));
			
		case "2":
			return (i == 4 ? "MM" : (i == 3 ? "CC" : (i == 2 ? "XX" : "II")));
			
		case "3":
			return (i == 4 ? "MMM" : (i == 3 ? "CCC" : (i == 2 ? "XXX" : "III")));
			
		case "4":
			return (i == 4 ? "MMMM" : (i == 3 ? "CD" : (i == 2 ? "XL" : "IV")));
			
		case "5":
			return (i == 4 ? "MMMMM" : (i == 3 ? "D" : (i == 2 ? "L" : "V")));
			
		case "6":
			return (i == 4 ? "MMMMMM" : (i == 3 ? "DC" : (i == 2 ? "LX" : "VI")));
			
		case "7":
			return (i == 4 ? "MMMMMMM" : (i == 3 ? "DCC" : (i == 2 ? "LXX" : "VII")));
			
		case "8":
			return (i == 4 ? "MMMMMMMM" : (i == 3 ? "DCCC" : (i == 2 ? "LXXX" : "VIII")));
			
		case "9":
			return (i == 4 ? "MMMMMMMMM" : (i == 3 ? "CM" : (i == 2 ? "XC" : "IX")));

		default:
			return "";
		}
	}

}
