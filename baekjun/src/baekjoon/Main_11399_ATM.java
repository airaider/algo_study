package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	static int N;
	static int[] numbers;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		int min=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i; j++) {
				min+=numbers[j];
			}
		}
		System.out.println(min);
		
	}

	
}
