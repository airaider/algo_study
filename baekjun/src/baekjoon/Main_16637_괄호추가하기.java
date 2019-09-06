package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16637_괄호추가하기 {
	static boolean result[];
	static int N;
	static char[] line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		line = new char[N];
		result = new boolean[N-1];
		for (int i = 0; i < N; i++) {
			line[i] = input.charAt(i);
		}
		sub(0, false);
		
	}
	private static void sub(int index, boolean flag) {
		if(index==N-1) {
			for (int i = 0; i < N-1; i++) {
				if(result[i]) System.out.print(i);
			}
			System.out.println();
			return;
		}
		if(flag) {
			result[index]=true;
			sub(index+1, false);
			return;
		}
		result[index]=false;
		sub(index+1, false);
		result[index]=true;
		sub(index+1, true);
	}
}
