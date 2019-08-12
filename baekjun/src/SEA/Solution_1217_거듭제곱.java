package SEA;

import java.util.Scanner;

public class Solution_1217_거듭제곱 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int T=sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("#"+t+" "+(int)Math.pow(a, b));
		}
		
	}

}
