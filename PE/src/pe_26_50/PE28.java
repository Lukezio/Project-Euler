package pe_26_50;

import java.math.BigInteger;

public class PE28 {
	
	BigInteger a[][];
	
	int direction;
	public final int UP = 0;
	final int RIGHT = 1;
	final int DOWN = 2;
	final int LEFT = 3;
	int counter = 3;
	int curX; //col
	int curY; //row
	BigInteger sum = BigInteger.ZERO;
	
	public PE28() {
		a = new BigInteger[1001][1001];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = new BigInteger("-1");
			}
		}
		a[500][500] = BigInteger.ONE;
		a[500][501] = new BigInteger("2");
		direction = LEFT;
		curX = 501;
		curY = 501;
		fillMatrix();
		calcSum();
		System.out.println(sum);
		
	}
	
	private void fillMatrix() {
		while (counter <= a.length * a[0].length) {
			a[curY][curX] = new BigInteger(String.valueOf(counter));
			counter++;
			switch (direction) {
				case 0:
					if (a[curY][curX + 1].compareTo(BigInteger.ZERO) == -1) {
						direction = RIGHT;
						curX += 1;
					} else {
						curY -= 1;
					}
					break;
			
				case 1:
					if (a[curY + 1][curX].compareTo(BigInteger.ZERO) == -1) {
						direction = DOWN;
						curY += 1;
					} else {
						curX += 1;
					}
					break;
				
				case 2:
					if (a[curY][curX -1].compareTo(BigInteger.ZERO) == -1) {
						direction = LEFT;
						curX -= 1;
					} else {
						curY += 1;
					}
					break;

				default:
					if (a[curY - 1][curX].compareTo(BigInteger.ZERO) == -1) {
						direction = UP;
						curY -= 1;
					} else {
						curX -= 1;
					}
				break;
			}
		}
	}
	
	private void calcSum() {
		for (int i = 0; i < a.length; i++) {
			sum = sum.add(a[i][i]);
			sum = sum.add(a[a.length - 1 - i][i]);
		}
		sum = sum.subtract(a[500][500]);
	}

}
