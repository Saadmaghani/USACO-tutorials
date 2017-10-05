/*
ID: saadhku1
LANG: JAVA
TASK: combo
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class combo{
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("combo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

		int N = Integer.parseInt(in.readLine());
		int[][] locks = new int[2][3];
		for(int i=0; i<2; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<3; j++){
				locks[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		int[] fStart = new int[3];
		int[] mStart = new int[3];
		for(int j=0; j<3; j++){
			fStart[j] = (locks[0][j] -3 + N)%N +1;
			mStart[j] = (locks[1][j] -3 + N)%N +1;
		}
		
		Set<String> combos = new HashSet<String>();
		
		solve(N, fStart, combos);
		solve(N, mStart, combos);
		
		out.println(combos.size());
		out.close();
	}


	static void solve(int N, int[] lStart, Set<String> combos){
		int a,b,c;
		for(int i = 0; i < 5 ; i++){
			a = (lStart[0]+i-1+N)%N+1;
			for(int j = 0; j < 5 ; j++){
				b = (lStart[1]+j-1+N)%N+1;
				for(int k = 0; k < 5 ; k++){
					c = (lStart[2]+k-1+N)%N+1;
					combos.add(""+a+b+c);
					//System.out.println(""+a+b+c);
				}
			}
		} 
	}







/*

	static void solve(int N, int[] lStart, Set<String> combos){
		for(int a = lStart[0]; a != (lStart[0] +4+N)%N +1 ; a = (a+N)%N +1){
			for(int b = lStart[1]; b != (lStart[1] +4+N)%N +1 ; b = (b+N)%N +1){
				for(int c = lStart[2]; c != (lStart[2] +4+N)%N +1 ; c = (c+N)%N +1){
						combos.add(""+a+b+c);
						System.out.println(""+a+b+c);
				}
			}		
		} 
	}

*/
}