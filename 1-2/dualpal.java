/*
ID: saadhku1
LANG: JAVA
TASK: dualpal
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class dualpal{
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int found = 0;
		int numberToCheck=S+1;
		while(found <N){
			int howManyPali = 0;
			for(int base =2; base<=10; base++){
				if(isPalin(convBase(numberToCheck,base))){
					if(++howManyPali==2) break;
				}
			}
			if(howManyPali>=2){
				out.println(numberToCheck);
				found++;
			}
			numberToCheck++;
		}

		out.close();
	}

	public static String convBase(int n, int b){
		char[] allPoss = {'0','1','2','3','4','5','6','7','8','9'};
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