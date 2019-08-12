package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1221_GNS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			int arr[] = new int[cnt];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<cnt;i++) {
				switch (st.nextToken()) {
				case "ZRO":
					arr[i]=0;
					break;
				case "ONE":
					arr[i]=1;
					break;
				case "TWO":
					arr[i]=2;
					break;
				case "THR":
					arr[i]=3;
					break;
				case "FOR":
					arr[i]=4;
					break;
				case "FIV":
					arr[i]=5;
					break;
				case "SIX":
					arr[i]=6;
					break;
				case "SVN":
					arr[i]=7;
					break;
				case "EGT":
					arr[i]=8;
					break;
				case "NIN":
					arr[i]=9;
					break;
				default:
					break;
				}
				
			}
			Arrays.sort(arr);
			StringBuilder ans = new StringBuilder();
			for(int i=0;i<cnt;i++) {
				switch (arr[i]) {
				case 0:
					ans.append("ZRO ");
					break;
				case 1:
					ans.append("ONE ");
					break;
				case 2:
					ans.append("TWO ");
					break;
				case 3:
					ans.append("THR ");
					break;
				case 4:
					ans.append("FOR ");
					break;
				case 5:
					ans.append("FIV ");
					break;
				case 6:
					ans.append("SIX ");
					break;
				case 7:
					ans.append("SVN ");
					break;
				case 8:
					ans.append("EGT ");
					break;
				case 9:
					ans.append("NIN ");
					break;
				default:
					break;
				}
				}
			System.out.println("#"+t);
			System.out.println(ans);
			}
			
		}
}


