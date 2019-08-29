package IM_190827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Solution2 {
	static int N;
	static int[] card;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			card = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			num = new int[5];
			permu(0);
		}
	}
	private static void permu(int index) {
		if(index==5) {
			swap();
			System.out.println(Arrays.toString(num));
			if(check()) {
				System.out.println();
			}
			return;
		}
		for (int i = 0; i < 6; i++) {
			num[index]=i;
			permu(index+1);
		}
	}
	private static boolean check() {
		int inc=1, dec=1;
		for (int i = 0; i < N-1; i++) {
			if(card[i+1]>card[i]) continue;
			else {
				inc--;
				break;
			}
		}
		for (int i = 0; i < N-1; i++) {
			if(card[i+1]<card[i]) continue;
			else {
				dec--;
				break;
			}
		}
		if(inc+dec==1) return true;
		return false;
		
	}
	private static boolean swap() {
		if(check()) return true;
		for (int method : num) {
			switch (method) {
			case 0:
				break;
			
			case 1:
				int temp = card[N/2];
				card[N/2] = card[N/2-1];
				card[N/2-1] = temp;
				break;
			
			case 2:
				int[] left = Arrays.copyOfRange(card, 0, N/2-1);
				int[] right = Arrays.copyOfRange(card, N/2, N-1);
				int index=0;
				for (int i = 0; i < N/2; i++) {
					card[index]=left[i];
					card[index+1]=right[i];
					index++;
				}
				break;
			
			case 3:
				int[] l = Arrays.copyOfRange(card, 0, N/2-1);
				int[] r = Arrays.copyOfRange(card, N/2, N-1);
				int it=0;
				for (int i = 0; i < N/2; i++) {
					card[it]=r[i];
					card[it+1]=l[i];
					it++;
				}
				break;
			
			case 4:
				int[] c = Arrays.copyOfRange(card, 0, N/2-1);
				int[] d = Arrays.copyOfRange(card, N/2, N-1);
				int id=0;
				for (int i = 0; i < N/2; i++) {
					card[id]=c[i];
					card[id+N/2] = d[i];
					id++;
				}
				int temp2 = card[N/2];
				card[N/2] = card[N/2-1];
				card[N/2-1] = temp2;
				break;
			
			case 5:
				int[] a = Arrays.copyOfRange(card, 0, N/2-1);
				int[] b = Arrays.copyOfRange(card, N/2, N-1);
				int ia=0;
				for (int i = 0; i < N/2; i++) {
					card[ia]=b[i];
					card[ia+N/2] = a[i];
					ia++;
				}
				break;

			default:
				break;
			}
			if(check()) return true;
		}
		return false;
	}

}
