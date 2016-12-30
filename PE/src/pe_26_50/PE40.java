package p_26_50;

public class PE40 {

	public PE40() {
		int a = 1;
		int array[][] = new int[2][7];
		for (int i = 0; i < array[0].length; i++) {
			array[0][i] = (int) Math.pow(10, i);
		}
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			sum += 9 * i * a;
			a *= 10;
		}
		System.out.println(sum);
	}
}
