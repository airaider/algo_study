import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
	static boolean[] visit;
	static int N;
	public static void main(String[] args) {
		System.out.println(Character.toString((char)68));
		char a = 'A';
		char b = 'B';
		System.out.println(a<=b);
		System.out.println();
		System.out.println(Integer.valueOf(10));
		String line= "127.158.0.1";
		int c;
		int d;
		StringTokenizer st = new StringTokenizer(line,".");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}
	private static void sub(int index, int count) {
		ArrayList<Integer> test = new ArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
			if(test.get(i)%2==0) {
				test.remove(i);
				i--;
			}
		}
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
		
		
		
	}
	
}
