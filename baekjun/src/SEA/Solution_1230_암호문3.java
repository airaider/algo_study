package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution_1230_암호문3{
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1;t<=10;t++) {
            int N=Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> amho = new LinkedList<Integer>();
            for(int i=0;i<N;i++) {
                amho.add(Integer.parseInt(st.nextToken()));
            }
            int M=Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                String what = st.nextToken();
                switch (what) {
				case "I":
					int here = Integer.parseInt(st.nextToken());
	                int howmuch = Integer.parseInt(st.nextToken());
	                for(int m=0;m<howmuch;m++) {
	                    amho.add(here+m, Integer.parseInt(st.nextToken()));
	                }
					break;
				case "D":
					int delete = Integer.parseInt(st.nextToken());
	                int many = Integer.parseInt(st.nextToken());
	                for(int m=delete;m<many;m++) {
	                	amho.remove(m);
	                }
					break;
				case "A":
					int add = Integer.parseInt(st.nextToken());
	                for(int m=0;m<add;m++) {
	                	 amho.add(Integer.parseInt(st.nextToken()));
	                }
					break;

				default:
					break;
				}
                
            }
            System.out.print("#"+t+" ");
            for(int i=0;i<10;i++) {
                System.out.print(amho.get(i)+" ");
            }
            System.out.println();
             
        }
    }
 
}