/*
ID: saadhku1
LANG: JAVA
TASK: crypt1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class crypt1{
	static int count =0;
	static String setS ="";
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] set = new int[N];
		for(int i=0;i<N;i++){
			set[i] = Integer.parseInt(st.nextToken());
			setS+=set[i];
		}
		
		int[] subList = new int[5];
		solve(set,subList,0);
		out.println(count);
		out.close();
	}
	
	static int solve(int[] numList, int[] subList, int pos){
		for(int ind=0; ind<numList.length; ind++){
			if(pos<5){
				subList[pos] = numList[ind];
				pos = solve(numList, subList, ++pos);
			}else{
				StringBuilder strNum = new StringBuilder();
				for(int n : subList){
					strNum.append(n);
				}

				int mult = Integer.parseInt(strNum.substring(0,3))*Integer.parseInt(strNum.substring(3,5));
				int partialM1 = Integer.parseInt(strNum.substring(0,3))*Integer.parseInt(strNum.substring(4,5));
				int partialM2 = Integer.parseInt(strNum.substring(0,3))*Integer.parseInt(strNum.substring(3,4));

				if(mult<=9999 && partialM1<=999 && partialM2<=999){
					if(String.valueOf(mult).matches("^(["+setS+"]{4})") && String.valueOf(partialM1).matches("^(["+setS+"]{3})")
					 && String.valueOf(partialM2).matches("^(["+setS+"]{3})")){
						//System.out.println(strNum);
						count++;
					}
				}
				return --pos;
			}
		}
		return --pos;
	}
}