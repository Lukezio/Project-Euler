package p_1_25;

public class P9 {

	int sum = 0;

	public P9() {
		for (int i = 0; i <= 800; i++) {
			for (int j = 0; j <= 800; j++) {
				double c = Math.sqrt(i * i + j * j);
				int z = (int) c;
				// System.out.println(c + " " + z);
				if (((double) z) - c == 0.0) {
					if (i + j + z == 1000 && z != 0 && i != 0 && j != 0) {
						System.out.println(i + j + z + " " + i * j * z);
						return;
					}
				}
			}
		}
	}

}
