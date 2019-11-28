package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임 {
	static int N;
	static String input;
	static int[][] map;
	static int[] result;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			input=st.nextToken();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+t);
			
			switch (input) {
			case "up":
				for (int i = 0; i < N-1; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==0) {
							for (int j2 = i+1; j2 < N; j2++) {
								if(map[j2][j]!=0) {
									map[i][j]=map[j2][j];
									map[j2][j]=0;
									break;
								}
							}
						}
					}
				}
				for (int i = 0; i < N-1; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==map[i+1][j]) {
							map[i][j]+=map[i+1][j];
							map[i+1][j]=0;
						}
					}
				}
				for (int i = 0; i < N-1; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==0) {
							for (int j2 = i+1; j2 < N; j2++) {
								if(map[j2][j]!=0) {
									map[i][j]=map[j2][j];
									map[j2][j]=0;
									break;
								}
							}
						}
					}
				}
				
				break;
			case "down":
				for (int i = N-1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==0) {
							for (int j2 = i-1; j2 >= 0; j2--) {
								if(map[j2][j]!=0) {
									map[i][j]=map[j2][j];
									map[j2][j]=0;
									break;
								}
							}
						}
					}
				}
				for (int i = N-1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==map[i-1][j]) {
							map[i][j]+=map[i-1][j];
							map[i-1][j]=0;
						}
					}
				}
				for (int i = N-1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==0) {
							for (int j2 = i-1; j2 >= 0; j2--) {
								if(map[j2][j]!=0) {
									map[i][j]=map[j2][j];
									map[j2][j]=0;
									break;
								}
							}
						}
					}
				}
				break;
			case "left":
				for (int i = 0; i < N-1; i++) {
					for (int j = 0; j < N; j++) {
						if(map[j][i]==0) {
							for (int j2 = i+1; j2 < N; j2++) {
								if(map[j][j2]!=0) {
									map[j][i]=map[j][j2];
									map[j][j2]=0;
									break;
								}
							}
						}
					}
				}
				for (int i = 0; i < N-1; i++) {
					for (int j = 0; j < N; j++) {
						if(map[j][i]==map[j][i+1]) {
							map[j][i]+=map[j][i+1];
							map[j][i+1]=0;
						}
					}
				}
				for (int i = 0; i < N-1; i++) {
					for (int j = 0; j < N; j++) {
						if(map[j][i]==0) {
							for (int j2 = i+1; j2 < N; j2++) {
								if(map[j][j2]!=0) {
									map[j][i]=map[j][j2];
									map[j][j2]=0;
									break;
								}
							}
						}
					}
				}
				break;
			case "right":
				for (int i = N-1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						if(map[j][i]==0) {
							for (int j2 = i-1; j2 >= 0; j2--) {
								if(map[j][j2]!=0) {
									map[j][i]=map[j][j2];
									map[j][j2]=0;
									break;
								}
							}
						}
					}
				}
				for (int i = N-1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						if(map[j][i]==map[j][i-1]) {
							map[j][i]+=map[j][i-1];
							map[j][i-1]=0;
						}
					}
				}
				for (int i = N-1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						if(map[j][i]==0) {
							for (int j2 = i-1; j2 >= 0; j2--) {
								if(map[j][j2]!=0) {
									map[j][i]=map[j][j2];
									map[j][j2]=0;
									break;
								}
							}
						}
					}
				}
				break;

			default:
				break;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
	
}
