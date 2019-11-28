package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순환회로 {
	static int map[][];
	static int N;
	static int order[];
	static int cost=0;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		order = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			order[i]=i;
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		permu(1);
		System.out.println(ans);
		
	}
	private static void permu(int index) {
		if(index == N) {
			int cost=0;
			for (int i = 0; i < N-1; i++) {
				if(map[order[i]][order[i+1]]==0) return;
				cost+=map[order[i]][order[i+1]];
				if(cost>ans) return;
			}
			if(map[order[N-1]][order[0]]==0) return;
			cost+=map[order[N-1]][order[0]];
			if(cost<ans) ans=cost;
			return;
		}
		
		for (int i = index; i < N; i++) {
			int temp = order[i];
			order[i]=order[index];
			order[index]=temp;
			permu(index+1);
			temp = order[i];
			order[i]=order[index];
			order[index]=temp;
		}
	}

}
