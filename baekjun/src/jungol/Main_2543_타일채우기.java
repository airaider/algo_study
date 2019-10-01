package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2543_타일채우기 {
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x =  Integer.parseInt(st.nextToken());
		int y =  Integer.parseInt(st.nextToken());
		split(1,1,n,n,x+1,y+1,0);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static void split(int sx, int sy, int ex, int ey, int hx, int hy, int hc) {
		if(sx==ex) {
			map[sx][sy]=hc;
			return;
		}
		
		int mx = (sx+ex)/2;
		int my = (sy+ey)/2;
		
		if(hx>=sx && hx<=mx && hy>=sy && hy<=my) {
			map[mx+1][my]=1;
			map[mx][my+1]=1;
			map[mx+1][my+1]=1;
			split(sx,sy,mx,my,hx,hy,hc);
			split(mx+1,sy,ex,my,mx+1,my,1);
			split(sx,my+1,mx,ey,mx,my+1,1);
			split(mx+1,my+1,ex,ey,mx+1,my+1,1);
		}
		else if(hx>=mx+1 && hx<=ex && hy>=sy && hy<=my) {
			map[mx][my]=2;
			map[mx+1][my]=2;
			map[mx+1][my+1]=2;
			split(sx,sy,mx,my,hx,hy,3);
			split(mx+1,sy,ex,my,hx,hy,hc);
			split(sx,my+1,mx,ey,mx,my+1,3);
			split(mx+1,my+1,ex,ey,mx+1,my+1,3);
		}
		else if(hx>=sx && hx<=mx && hy>=my+1 && hy<=ey){
			map[mx][my]=3;
			map[mx][my+1]=3;
			map[mx+1][mx+1]=3;
			split(sx,sy,mx,my,mx,my,2);
			split(mx+1,sy,ex,my,mx+1,my,2);
			split(sx,my+1,mx,ey,hx,hy,hc);
			split(mx+1,my+1,ex,ey,mx+1,my+1,2);
		}
		else if(hx>=mx+1 && hx<=ex && hy>=my+1 && hy<=ey) {
			map[mx][my]=4;
			map[mx+1][my]=4;
			map[mx][my+1]=4;
			split(sx,sy,mx,my,mx,my,4);
			split(mx+1,sy,ex,my,mx+1,my,4);
			split(sx,my+1,mx,ey,mx,my+1,4);
			split(mx+1,my+1,ex,ey,hx,hy,hc);
		}
		
		
		
				
	}
}
