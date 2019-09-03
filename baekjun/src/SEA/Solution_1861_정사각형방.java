package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	static int N;
	static int map[][];
	static int ans;
	static int cor;
	static int ax,ay;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans=1;
			cor=Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ax=i;
					ay=j;
					move(i,j,1);
				}
			}
			System.out.println("#"+t+" "+cor+" "+ans);
			
		}

	}
	private static void move(int x, int y, int count) {
		int temp = map[x][y]+1;
		if(x+1<N && map[x+1][y]==temp) {
			move(x+1,y,count+1);
		}
		else if(y+1<N && map[x][y+1]==temp) {
			move(x,y+1,count+1);
		}
		else if(x-1>=0 && map[x-1][y]==temp) {
			move(x-1,y,count+1);
		}
		else if(y-1>=0 && map[x][y-1]==temp) {
			move(x,y-1,count+1);
		}
		else {
			if(count==1) return;
			if(count>=ans) {
				if(count==ans && map[ax][ay]<cor) {
					ans=count;
					cor=map[ax][ay];
				}
				else if (count > ans) {
					ans=count;
					cor=map[ax][ay];
				}
			}
		
		return;
		}
	}

}
