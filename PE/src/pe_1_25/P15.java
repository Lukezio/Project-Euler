package pe_1_25;

public class P15 {

	long possibilities = 0;

	public P15() {
		System.out.println(calc(20, 20));
	}
	
	private int calc(int x, int y) {
		if (x == 0) {
			if (y == 0) {
				return 1;
			}
			return calc(x, y - 1);
		}
		if (y == 0) {
			return calc(x - 1, y);
		}
		return calc(x - 1, y) + calc(x, y - 1);
	}

}
