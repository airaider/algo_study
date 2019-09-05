package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_10164_격자상의경로 {
	static BigInteger mul=BigInteger.ONE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(K==0) {
			for(int i = N+M; i>(N>M?N:M);i--) {
				mul = mul.multiply(BigInteger.valueOf(i));
			}
			for (int i = 1; i <= (N<M?N:M); i++) {
				mul = mul.divide(BigInteger.valueOf(i));	
			}
			System.out.println(mul);
			return;
		}
		int cnt = 1;
		int x=0;
		int y=0;
		find:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cnt++==K) {
					x=i;
					y=j;
					break find;
				}
			}
		}
		int c=N-x-1;
		int d=M-y-1;
		for(int i = x+y; i>(x>y?x:y);i--) {
			mul = mul.multiply(BigInteger.valueOf(i));
		}
		for (int i = 1; i <= (x<y?x:y); i++) {
			mul = mul.divide(BigInteger.valueOf(i));
		}
		for(int i = c+d; i>(c>d?c:d);i--) {
			mul = mul.multiply(BigInteger.valueOf(i));
		}
		for (int i = 1; i <= (c<d?c:d); i++) {
			mul = mul.divide(BigInteger.valueOf(i));
		}
		System.out.println(mul);
		
	}

}
