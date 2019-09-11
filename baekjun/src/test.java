import java.util.Arrays;

public class test {
	static boolean[] visit;
	static int N;
	public static void main(String[] args) {
		N=6;
		visit = new boolean[N];
		sub(0,0);
		
	}
	private static void sub(int index, int count) {
		if(count==3) {
			for (int i = 0; i < 6; i++) {
				if(visit[i]) System.out.print(i);
			}
			System.out.println();
			return;
		}
		
		visit[index]=true;
		sub(index+1, count+1);
		visit[index]=false;
		sub(index+1, count+1);
	}
	
}
