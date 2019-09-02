package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int N, W, H;
	static int[][] map;
	static int[][] temp;
	static int[] select;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			temp = new int[H][W];
			select = new int[N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					temp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combi(0);
			System.out.println(ans);
		}

	}

	private static void combi(int index) {
		if (index == N) {
			System.out.println(Arrays.toString(select));
			bomb();
			count();
			return;
		}

		for (int i = 0; i < W; i++) {
			select[index]=i;
			combi(index+1);
		}

	}

	private static void count() {
		int cnt=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(temp[i][j]!=0) cnt++;
			}
		}
		ans=Math.min(cnt, ans);
	}

	private static void bomb() {
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = temp[i][j];
			}
		}
		
		int r=0;
		for (int loc : select) {
			for (int i = 0; i < H; i++) {
				if(map[i][loc]!=0) {
					int cnt=0;
					int radius = map[i][loc];
					map[i][loc]=0;
					while(cnt!=radius) {
						if(loc-cnt>=0) {
							r = map[i][loc-cnt];
							map[i][loc-cnt]=0;
							if(r>1) {
								bomb2(i,loc-cnt, r);
							}
						}
						if(loc+cnt<W) {
							r = map[i][loc+cnt];
							map[i][loc+cnt]=0;
							if(r>1) {
								bomb2(i,loc+cnt, r);
							}
						}
						if(i+cnt<H) {
							r = map[i+cnt][loc];
							map[i+cnt][loc]=0;
							if(r>1) {
								bomb2(i+cnt,loc, r);
							}
						}
						cnt++;
					}
					break;
				}
			}
			sitdown();
		}
		print();
	}

	private static void sitdown() {
		for (int i = 0; i < W; i++) {
			for (int j = H-1; j> 0; j--) {
				if(map[i][j]==0 && map[i][j-1]!=0) {
					map[i][j]=map[i][j-1];
					map[i][j-1]=0;
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void bomb2(int a, int b, int radius) {
		int cnt=0;
		int r = 0;
		while(cnt!=radius) {
			if(a-cnt>=0) {
				r = map[a-cnt][b];
				map[a-cnt][b]=0;
				if(r>1) {
					bomb2(a-cnt,b,r);
				}
			}
			if(a+cnt<N) {
				r = map[a+cnt][b];
				map[a+cnt][b] = 0;
				if(r>1) {
					bomb2(a+cnt,b,r);
				}
			}
			if(b-cnt>=0) {
				r = map[a][b-cnt];
				map[a][b-cnt] = 0;
				if(r>1) {
					bomb2(a,b-cnt,r);
				}
			}
			if(b+cnt<N) {
				r = map[a][b+cnt];
				map[a][b+cnt] = 0;
				if(r>1) {
					bomb2(a,b+cnt,r);
				}
			}
			
			cnt++;
			
		}
		
	}

}
