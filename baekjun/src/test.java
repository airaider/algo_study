import java.util.ArrayList;

public class test {
	static boolean[] visit;
	static int N;
	public static void main(String[] args) {
		N=6;
		visit = new boolean[N];
		sub(0,0);
		
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
