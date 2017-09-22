/*
ID: saadhku1
LANG: JAVA
TASK: palsquare
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class palsquare{

 
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

		int base = Integer.parseInt(in.readLine());
		for(int i=1; i<=300; i++){
			int sq = i*i;
			String iYipped = new StringBuilder(convBase(i,base)).reverse().toString();
			String sqYipped = new StringBuilder(convBase(sq,base)).reverse().toString();

			if(isPalin(sqYipped)) out.println(iYipped+" "+sqYipped);
			
		}
		out.close();
	}

	public static String convBase(int n, int b){
		char[] allPoss = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
		String conv ="";
		int iDiv =n/b, iRem = n%b;
		conv += allPoss[iRem];
		while(iDiv!=0){
			iRem = iDiv%b;
			iDiv = iDiv/b;
			conv += allPoss[iRem];
		}
		
		return conv;
	}
	public static boolean isPalin(String toCheck){
		for(int i=0;i<(((toCheck.length()+1)/2.0)-1);i++){
			if(toCheck.charAt(i) != toCheck.charAt(toCheck.length()-1-i)) return false;
		}
		return true;
	}
}