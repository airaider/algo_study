package IM_190828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1 {

	private static int N;
	private static int[] card;
	private static int[] method1;
	private static int[] method2;
	private static int[] method2l;
	private static int[] method2r;
	private static int[] method3;
	private static int[] method4;
	static boolean flag=false;
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
			shuffle(card, 0);
			
		}
	}


	private static void shuffle(int[] mix, int index) {
		if(index>5) {
			return;
		}
		if(check(mix)) {
			System.out.println(index);
			flag=true;
			return;
		}
		
		method1 = Arrays.copyOfRange(mix, 0, N);
		int temp = method1[N/2];
		method1[N/2] = method1[N/2-1];
		method1[N/2-1] = temp;
		if(index==2)System.out.println(Arrays.toString(method1));
		if(check(method1)) {
			System.out.println(index+1);
			flag=true;
			return;
		}
		else shuffle(method1, index+1);
		
		method2l = Arrays.copyOfRange(mix, 0, N/2);
		method2r = Arrays.copyOfRange(mix, N/2, N);
		temp = 0;
		method2 = new int[N];
		for (int i = 0; i < N/2; i++) {
			method2[temp++]=method2l[i];
			method2[temp++]=method2r[i];
		}
		if(index==2)System.out.println(Arrays.toString(method2));
		if(check(method2)) {
			System.out.println(index+1);
			flag=true;
			return;
		}
		else shuffle(method2, index+1);
		
		temp = 0;
		method3 = new int[N];
		for (int i = 0; i < N/2; i++) {
			method3[temp++]=method2r[i];
			method3[temp++]=method2l[i];
		}
		if(index==2)System.out.println(Arrays.toString(method3));
		if(check(method3)) {
			System.out.println(index+1);
			flag=true;
			return;
		}
		else shuffle(method3, index+1);
		
		temp=0;
		method4 = new int[N];
		for (int i = 0; i < N/2; i++) {
			method4[temp++]=method2r[i];
			method4[temp-1+(N/2)]=method2l[i];
		}
		if(index==2)System.out.println(Arrays.toString(method4));
		if(check(method4)) {
			System.out.println(index+1);
			flag=true;
			return;
		}
		else shuffle(method4, index+1);
		
		temp = method4[N/2];
		method4[N/2] = method4[N/2-1];
		method4[N/2-1] = temp;
		if(index==2)System.out.println(Arrays.toString(method4));
		if(check(method4)) {
			System.out.println(index+1);
			flag=true;
			return;
		}
		else shuffle(method4, index+1);
		
		
		
	}

	private static boolean check(int[] mix) {
		if(flag) return true;
		if(mix[0]==1) {
			for (int i = 0; i < N; i++) {
				if(mix[i]!=i+1) return false;
			}
			return true;
		}else if(mix[0]==N) {
			for (int i = 0; i < N; i++) {
				if(mix[i]!=N-i) return false;
			}
			return true;
		}
		
		return false;
	}

}
