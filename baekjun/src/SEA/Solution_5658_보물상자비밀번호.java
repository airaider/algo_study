package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String line = br.readLine();
			TreeSet<Integer> set = new TreeSet<>();
			line+=line;
			int c=N/4;
			for (int i = 0; i < c; i++) {
				set.add(Integer.parseInt(line.substring(i, i+c), 16));
				set.add(Integer.parseInt(line.substring(i+c, i+2*c), 16));
				set.add(Integer.parseInt(line.substring(i+2*c, i+3*c), 16));
				set.add(Integer.parseInt(line.substring(i+3*c, i+4*c), 16));
			}
			ArrayList<Integer> answer = new ArrayList<>(set);
			System.out.println("#"+t+" "+answer.get(answer.size()-K));
		}
	}

}
 