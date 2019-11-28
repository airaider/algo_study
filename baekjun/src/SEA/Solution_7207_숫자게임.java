package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7207_숫자게임 {
	static String line;
	static String temp;
	static int len;
	static boolean[] visit;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			line = br.readLine();
			temp = line;
			len = line.length();
			visit = new boolean[len-1];
			ans=0;
			System.out.println("======");
		}
		
	}
	

}
