package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889 {
	static int map[][];
	static int N;
	static int start[];
	static int link[];
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		start = new int[N/2];
		link = new int[N/2];
		check = new boolean[N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		Combi(0);
	}

	private static void Combi(int count) {
		if(count == N/2) {
			System.out.println(Arrays.toString(start));
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!check[i]) {
				start[count]=i;
				check[i] = true;
				Combi(count+1);
				check[i] = false;
			}
		}
		
	}

}
