import java.util.Arrays;

public class test {
	static int M;
	private static int N;
	static int[] m;
	public static void main(String[] args) {
		int[] mix = {1,2,3,4,5,6,7,8};
		int N = mix.length;
		int[] method1 = Arrays.copyOfRange(mix, 0, N);
		int temp = method1[N/2];
		method1[N/2] = method1[N/2-1];
		method1[N/2-1] = temp;
		System.out.println(Arrays.toString(method1));
		
		int[] method2l = Arrays.copyOfRange(mix, 0, N/2);
		int[] method2r = Arrays.copyOfRange(mix, N/2, N);
		temp = 0;
		int[] method2 = new int[N];
		for (int i = 0; i < N/2; i++) {
			method2[temp++]=method2l[i];
			method2[temp++]=method2r[i];
		}
		System.out.println(Arrays.toString(method2));
		
		temp = 0;
		int[] method3 = new int[N];
		for (int i = 0; i < N/2; i++) {
			method3[temp++]=method2r[i];
			method3[temp++]=method2l[i];
		}
		System.out.println(Arrays.toString(method3));
		
		temp=0;
		int[] method4 = new int[N];
		for (int i = 0; i < N/2; i++) {
			method4[temp++]=method2r[i];
			method4[temp-1+(N/2)]=method2l[i];
		}
		System.out.println(Arrays.toString(method4));
		
		temp = method4[N/2];
		method4[N/2] = method4[N/2-1];
		method4[N/2-1] = temp;
		System.out.println(Arrays.toString(method4));
	}
	
}
