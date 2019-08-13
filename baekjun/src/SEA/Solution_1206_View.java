package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int [N];
			int temp1;
			int temp2;
			int temp3;
			int temp4;
			int max;
			int room = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for (int i = 2; i < N-2; i++) {
				temp1=arr[i-2];
				temp2=arr[i-1];
				temp3=arr[i+1];
				temp4=arr[i+2];
				if(temp1>=arr[i] || temp2>=arr[i] || temp3>=arr[i] || temp4>=arr[i]) continue;
				max = Math.max(temp1, temp2);
				max = Math.max(max, temp3);
				max = Math.max(max,  temp4);
				room+=arr[i]-max;
			}
			System.out.println("#"+t+" "+room);
		}
		
	}

}
