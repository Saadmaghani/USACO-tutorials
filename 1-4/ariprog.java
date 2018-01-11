/*
ID: saadhku1
LANG: JAVA
TASK: ariprog
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class ariprog{
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int high = 2*M*M+10;
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		boolean[] set = new boolean[high];

		for(int p=0; p<=M; p++){
			for(int q=p; q<=M; q++){
				int x = (p*p) + (q*q);
				if(set[x]) continue;
				set[x]=true;
				aList.add(x);
			}
		}
		Collections.sort(aList);

		int maxInd = high-1;
		boolean found = false;
		
		for(int b=1; b <= (high/(N-1)); b++){
			for(int i=0; i<aList.size(); i++){
				int a = aList.get(i);
				if( ((N-1)*b +a)<=high && i < maxInd ){
					boolean seqWhole = true;
					for(int j=1; j<N; j++){
						if(!set[a+j*b]){
							seqWhole=false;
							break;
						}
					}
					if(seqWhole){
						found = true;
						out.println(a+" "+b);
					}
				}else break;
			}	
		}
	
		if(!found) out.println("NONE");
		out.close();
	}
}