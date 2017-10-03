/*
ID: saadhku1
LANG: JAVA
TASK: crypt1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class crypt1{
	int count =0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		//Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] set = new int[N];
		for(int i=0;i<N;i++){
			set[i] = Integer.parseInt(st.nextToken());
		}
		int[] subList = new int[5];

		solve(set,subList,0);
		
		
	}
	
	static int solve(int[] numList, int[] subList, int pos){
		for(int ind=0;ind<numList.length;ind++){
			if(pos<5){
				subList[pos] = numList[ind];
				pos = solve(numList, subList, ind, ++pos);
			}else{
				StringBuilder strNum = new StringBuilder();
				for(int n : subList){
					strNum.append(n);
				}
				int threes = Integer.parseInt(strNum.substring(0,3));
				int twos = Integer.parseInt(strNum.substring(3,5));
				int mult = threes*twos;
				if(mult<=9999 && ){

				}
				return --pos;
			}
		}
		return --pos;
	}
}