package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기 {
	static int N,M;
	static boolean flag;
	static int formula[];
	static int clue[];
	static int what[];
	static ArrayList<int[]> list;
	static int possible[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <=T; t++) {
			sb.append("#").append(t);
			possible = new int[3];
			list = new ArrayList<>();
			make();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			formula = new int[6];
			clue = new int[3];
			Arrays.fill(clue, -1);
			for (int i = 0; i < N; i++) {
				flag=false;
				char[] input = br.readLine().toCharArray();
				int cnt=0;
				
				for (int j = 0; j < 3; j++) {
					if(formula[2*j]!=0 || formula[2*j+1]!=0) {
						clue[j]=formula[2*j]-formula[2*j+1];
					}
				}
				
				for (int j = 0, size = input.length; j < size; j++) {
					if(!flag && input[j]=='.') {
						cnt++;
					}
					else flag=true;
					
					switch (input[j]) {
					case '(':
						formula[0]++;
						break;
					case ')':
						formula[1]++;
						break;
					case '{':
						formula[2]++;
						break;
					case '}':
						formula[3]++;
						break;
					case '[':
						formula[4]++;;
						break;
					case ']':
						formula[5]++;
						break;

					default:
						break;
					}
				}
				calculate(cnt);
			}
			
			clue = new int[3];
			what = new int[6];
			for (int i = 0; i < M; i++) {
				char[] input = br.readLine().toCharArray();
				int check=0;
				int fans=0;
				int arr[]=list.get(0);
				for (int j = 0; j < 3; j++) {
					fans+=arr[j]*clue[j];
				}
				check=fans;
				for (int k = 1, size = list.size(); k < size; k++) {
					int arr1[]=list.get(k);
					fans=0;
					for (int j = 0; j < 3; j++) {
						fans+=arr1[j]*clue[j];
					}
					if(check!=fans) {
						fans=-1;
						break;
					}
				}
				

				sb.append(" "+fans);
				for (int j = 0, size = input.length; j < size; j++) {
					switch (input[j]) {
					case '(':
						what[0]++;
						break;
					case ')':
						what[1]++;
						break;
					case '{':
						what[2]++;
						break;
					case '}':
						what[3]++;
						break;
					case '[':
						what[4]++;;
						break;
					case ']':
						what[5]++;
						break;

					default:
						break;
					}
				}
				for (int j = 0; j < 3; j++) {
					if(what[2*j]!=0 || what[2*j+1]!=0) {
						clue[j]=what[2*j]-what[2*j+1];
					}
				}
				
				
				
			}
			sb.append("\n");
		}
		System.out.println(sb);


	}
	private static void calculate(int cnt) {
		
		for (int i = 0; i < list.size(); i++) {
			int[] test = list.get(i);
			int ans=0;
			for (int j = 0; j < 3; j++) {
				if(clue[j]!=-1) {
					ans+=test[j]*clue[j];
				}
			}
			if(ans!=cnt) {
				list.remove(i);
				i--;
			}
			
			
		}
		
		
	}
	private static void make() {
		
		for (int i = 1; i <= 20; i++) {
			possible[0]=i;
			for (int j = 1; j <= 20; j++) {
				possible[1]=j;
				for (int k = 1; k <= 20; k++) {
					possible[2]=k;
					list.add(possible.clone());
				}
			}
		}
		
	}

}
