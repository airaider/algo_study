package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_5014 {
	static int F,S,G,U,D;
	static boolean visit[];
	static int ans = 0;
	static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		G=Integer.parseInt(st.nextToken());
		U=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		visit = new boolean [F+1];
		
		
		if(U==0 && G>S) {
			System.out.println("use the stairs");
			return;
		}
		if(D==0 && G<S) {
			System.out.println("use the stairs");
			return;
		}
		bfs();
		if(ans==0) {
			System.out.println("use the stairs");
		}
	}
	private static void bfs() {
		q = new LinkedList<Point>();
		q.add(new Point(S,0));
		boolean [] visit = new boolean[F+1];
		visit[S]=true;
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x = p.x;
			int cnt = p.y;
			if(x==G) {
				ans=1;
				System.out.println(cnt);
				return;
			}
			
			if(x+U<=F && !visit[x+U]) {
				visit[x+U]=true;
				q.add(new Point(x+U,cnt+1));
			}
			if(x-D>=1 && !visit[x-D]) {
				visit[x-D]=true;
				q.add(new Point(x-D,cnt+1));
			}
		}
		System.out.println("use the stairs");
		return;
	}
	

}
