package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2577_회전초밥 {
	static int N,d,k,c;
	static int[] sushi;
	static boolean[] eat;
	static int[] cur_cnt;
	static int cur_ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N+k];
		cur_cnt=new int[3000 + 3];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k; i++) {
			sushi[N+i]=sushi[i];
		}
		push(c);
		for (int i = 0; i < k - 1; ++i)
			push(sushi[i]);

		int ans = 0;
		for (int i = 0; i < N; ++i) {
			push(sushi[i + k - 1]);
			ans = Math.max(ans, cur_ans);
			pop(sushi[i]);
		}
		System.out.println(ans);
	}
	
	static void push(int sushi_num) {
		if (cur_cnt[sushi_num]==0) ++cur_ans;
		++cur_cnt[sushi_num];
	}

	static void pop(int sushi_num) {
		--cur_cnt[sushi_num];
		if (cur_cnt[sushi_num]==0) --cur_ans;
	}
	
}
