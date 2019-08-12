package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1234_비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int t=1;t<=10;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			String ln = st.nextToken();
			Stack<Integer> stack = new Stack<Integer>();
			for(int i=0;i<N;i++) {
				int next = ln.charAt(i)-'0';
				int top=-1;
				if(!stack.isEmpty()) top = stack.peek();
				if(top==next) {
					stack.pop();
				}
				else stack.add(next);
			}
			int size = stack.size();
			int temp=size;
			int[] ans = new int [size];
			while(!stack.isEmpty()) {
				ans[--temp]=stack.pop();
			}
			System.out.print("#"+t+" ");
			for (int i = 0; i < size; i++) {
				System.out.print(ans[i]);
			}
			System.out.println();
			
		}
	}

}
