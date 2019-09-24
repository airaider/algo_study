package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2247_도서관 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int student[][] = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken());
			student[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(student, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o1[1];
				else return o1[0]-o2[0];
			}
		});
		int inTime=0,outTime=0;
		int in[] = new int[2];
		int out[] = new int[2];
		in = student[0];
		
		for (int i = 1; i < N; i++) {
			int temp[] = student[i];
			if(in[1]<temp[0]) {
				out[0]=in[1];
				out[1]=temp[0];
				
				if(in[1]-in[0]>inTime) {
					inTime=in[1]-in[0]>inTime?in[1]-in[0]:inTime;
					outTime=out[1]-out[0]>outTime?out[1]-out[0]:outTime;
					
				}
				
				
				in=student[i];
				
			}
			else {
				
				
				
			}
		}
		
		
		
	}

}
