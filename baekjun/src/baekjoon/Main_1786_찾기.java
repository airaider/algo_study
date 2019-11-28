package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1786_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String String = br.readLine();
		String Pattern = br.readLine();

		ArrayList<Integer> list = KMP(String, Pattern);
		int size = list.size();
		System.out.println(size);

		for (int i = 0; i < size; i++) {
			System.out.print(list.get(i) + 1 + " ");
		}

	}

	public static ArrayList<Integer> KMP(String str, String pattern) { 

		ArrayList<Integer> list = new ArrayList<>();
		int[] pi = getPi(pattern);
		int LenOfStr = str.length();
		int LenOfPattern = pattern.length();
		int j = 0;

		for (int i = 0; i < LenOfStr; i++) {
			while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (str.charAt(i) == pattern.charAt(j)) {
				if (j == LenOfPattern - 1) {
					list.add(i - LenOfPattern + 1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return list;
	}

	private static int[] getPi(String pattern) {
		int LenOfPattern = pattern.length();     
		int []pi = new int[LenOfPattern];     
		int j = 0;                            
		
		for(int i=1; i<LenOfPattern; i++) {   
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) { 
				j = pi[j-1];                                        
			}if(pattern.charAt(i) == pattern.charAt(j)) {           
				pi[i] = ++j;                                        
			}
		}
		return pi;     


	}

}
