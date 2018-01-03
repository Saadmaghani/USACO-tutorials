/*
ID: saadhku1
LANG: JAVA
TASK: skidesign
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class skidesign{
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		
		int N = Integer.parseInt(in.readLine());

		int[] hills = new int[N];
		for(int i=0;i<N;i++){
			hills[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(hills);
		
	//	for(int i=0;i<hills.length;i++)
	//		System.out.println(hills[i]);

		int ans = solve(hills,N);
		out.println(ans);
		out.close();
	}


	static int solve(int[] hills, int N){
		int minH = hills[0];
		int maxH = hills[N-1];
		int minCost = maxH*maxH*N;
		for(int i=minH; i<=maxH-17; i++){
			int cost=0;
			for(int j=0; j<N; j++){
				if(hills[j] < i)
					cost+= Math.pow((i-hills[j]),2);
				else if(hills[j] > (i+17))
					cost+= Math.pow((hills[j]-i-17),2);
			}
			minCost =(minCost<cost)? minCost:cost;
		}
		return minCost;
	}
}
