package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {
	static int parents[];
	static int n,m;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents=new int[n+1];
		Arrays.fill(parents, -1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int what=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(what == 0) {
				union(a,b);
			}
			else {
				if(a==b) {
					System.out.println("YES");
				}
				else {
					if(find(a)!=find(b)) {
						System.out.println("NO");
					}else {
						System.out.println("YES");
					}
				}
			}
		}
		
		
	}
	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa!=pb) {
			parents[pb]=pa;
			return true;
		}
		return false;
		
	}
	private static int find(int a) {
		if(parents[a]<0) {
			return a;
		}
		return parents[a] =  find(parents[a]);
	}

}
