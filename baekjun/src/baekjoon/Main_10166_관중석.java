package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_10166_관중석 {

	private static int D2;
	private static int D1;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D1 = Integer.parseInt(st.nextToken());
		D2 = Integer.parseInt(st.nextToken());
		ans=0;
		HashMap<Double, Boolean> seat = new HashMap<>();
		for (int t = D1; t <= D2; t++) {
			for (int i = 1; i <= t; i++) {
				if(!seat.containsKey((double)i/(double)t)) {
					seat.put(((double)i/(double)t), true);
					ans++;
				}
			}
		}
		System.out.println(ans);
		
	}

}
