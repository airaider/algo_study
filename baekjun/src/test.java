
public class test {
	static int M;
	private static int N;
	public static void main(String[] args) {
		M=3;
		N=5;
		combi(0,0,"");
	}
	private static void combi(int index, int flag, String result) {
		if(index == M) {
			System.out.println(result);
			return;
		}
		for (int i = index; i < N; i++) {
			if((flag&1<<i)==0) {
				combi(index+1, flag|1<<i,result+i);
			}
		}
	}
}
