/*
ID: saadhku1
LANG: JAVA
TASK: pprime
*/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;

class pprime{
	
	static ArrayList<Integer> start;
	static ArrayList<Integer> end;
	static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("pprime.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		start = intToArray(a);
		end = intToArray(b);

		for(int i=start.size(); i<=end.size(); i++){
			int pali[] = new int[i];
			makePalis(pali,0);
		}

		out.close();
	}

	static ArrayList<Integer> intToArray(int x){
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		while(x!=0){
			numArray.add(0, x%10);
			x/=10;
		}
		return numArray;
	}

	static boolean checkStart(int[] paliArray, int offSet){
		int checkTill=offSet;
		if(offSet==(paliArray.length-1)/2)	checkTill=start.size()-1;
		for(int i=0; i<=checkTill; i++){
			if(paliArray[i] < start.get(i)) return false;
			if(paliArray[i] > start.get(i)) return true;
		}
		return true;
	}
	static boolean checkEnd(int[] paliArray, int offSet){
		int checkTill=offSet;
		if(offSet==(paliArray.length-1)/2)	checkTill=end.size()-1;
		for(int i=0; i<=checkTill; i++){
			if(paliArray[i] > end.get(i)) return false;
			if(paliArray[i] < end.get(i)) return true;
		}
		return true;
	}

	static int makeInt(int[] x){

		StringBuilder strNum = new StringBuilder();

		for (int n : x) 
		{
		     strNum.append(n);
		}
		return Integer.parseInt(strNum.toString());
	}

	static void makePalis(int[] paliArray, int offSet){
		
		for(int i=(offSet==0)?1:0; i<10; i++){
			paliArray[offSet]=i;
			paliArray[paliArray.length-1-offSet]=i; //if even. will overwrite if odd 			
		
			if(paliArray.length == start.size() && !checkStart(paliArray, offSet)) continue;
			else if(paliArray.length == end.size() && !checkEnd(paliArray,offSet)) break;

			if((paliArray.length%2==1 && offSet == paliArray.length-1-offSet) || (paliArray.length%2==0 && offSet+1 == paliArray.length-1-offSet)){ //base case
				//for(int j=0; j<paliArray.length;System.out.print(paliArray[j++]));
				//System.out.println(); 
				int finalInt = makeInt(paliArray);
				if(isPrime(finalInt)) out.println(finalInt);
			}else{
				makePalis(paliArray, offSet+1);
			}
		}
	}


	static BigInteger[] coeff(int n) {
		BigInteger c[] = new BigInteger[n+1];
        c[0] = new BigInteger("-1");
        c[n] = c[0].negate();
        for (int k = 0; k < (n/2); ++ k){
            c[k+1] = c[k].negate().multiply(BigInteger.valueOf(n-k));
            c[k+1] = c[k+1].divide(BigInteger.valueOf(k+1));
            c[n-k-1] = c[k+1].negate();
        }
        return c;
    }
 
    static boolean isPrime(int n) {
		BigInteger c[] = coeff(n);
		c[0]=c[0].add(BigInteger.ONE);
        c[n]=c[n].add(BigInteger.valueOf(-1));
        for(int i=0; i<=n;i++){
            if(c[i].mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)==false)return false;
        }
        return true;
    }
}