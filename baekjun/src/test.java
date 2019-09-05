import java.util.Arrays;

public class test {
	static int M;
	private static int N;
	static int[] m;
	public static void main(String[] args) {
		int x = 3;
		int y = 0;
		int mul =1;
		for(int i = x+y; i>(x>y?x:y);i--) {
			mul*=i;
		}
		int s = 1;
		
		for (int i = 1; i <= (x<y?x:y); i++) {
			s*=i;
		}
		System.out.println(mul);
		System.out.println(s);
		System.out.println(mul/s);
	}
	
}
