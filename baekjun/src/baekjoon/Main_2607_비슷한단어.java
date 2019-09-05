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
		int ans=0;
		int[] a1 = new int[26];
		int[] a2 = new int[26];
		for (int i = 1; i < N; i++) {
			a2 = a1.clone();
			int b=1;
			for (int j = 0, size = line[i].length(); j < size; j++) {
				if(a2[line[i].charAt(j)-'A']!=0) {
					a2[line[i].charAt(j)-'A']--;
				}else if(a2[line[i].charAt(j)-'A']==0 && b==1) {
					b=0;
				}else {
					break;
				}
				if(j==size-1) ans++;
			}
			
		}
		System.out.println(ans);
		
	}

}
