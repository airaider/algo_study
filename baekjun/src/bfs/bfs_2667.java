package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_2667 {
	static int stoi(String s) { return Integer.parseInt(s);}
	static int T;
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	static int[][] map;
	static int count=0;
	public static void main(String[] args) throws IOException {
		int c=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		map = new int[T][T];
		for(int i=0;i<T;i++) {
			String s = br.readLine();
			for(int j=0;j<T;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<T; i++) {
            for(int j=0; j<T; j++) {
                if(map[i][j] == 1) {
                    bfs(i,j);
                    c++;
                    pq.add(count);
                    count=0;
                }
            }
        }
		System.out.println(c);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		
	}
	
	
	
	
	
	
	
	private static void bfs(int a, int b) {
		map[a][b]=0;
		count++;
		for(int i=0;i<4;i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			if(0<=nx && nx<T && 0<=ny && ny<T) {
				if(map[nx][ny]==1) {
					bfs(nx,ny);
				}
			}
		}
		
	}







	private static void show() {
		for(int i=0;i<T;i++) {
			for(int j=0;j<T;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
