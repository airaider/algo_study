package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2607_비슷한단어 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] line = new String[N];
		for (int i = 0; i < N; i++) {
			line[i]=br.readLine();
		}
		int[] a1 = new int[26];
		for (int i = 0, size = line[0].length(); i < size; i++) {
			a1[line[0].charAt(i)-'A']++;
			System.out.println(line[0].charAt(i)-'A');
		}
		int[] a2 = new int[26];
		for (int i = 1; i < N; i++) {
			a2 = a1.clone();
			for (int j = 0, size = line[i].length(); j < size; j++) {
				
			}
		}
		System.out.println();
		
	}

}
