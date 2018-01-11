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

		HashSet<Integer> set = new HashSet<Integer>();
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		for(int p=0; p<=M; p++){
			for(int q=p; q<=M; q++){
				int x = (p*p) + (q*q);
				set.add(x);
			}
		}

		int high = 2*M*M;
		int maxInd = set.size()-N+1;
		boolean found = false;
		ArrayList<Integer> aList = new ArrayList<Integer>(set);
		Collections.sort(aList);
		
		for(int b=1; b <= (high/(N-1)); b++){
			for(int i=0; i<aList.size(); i++){
				int a = aList.get(i);
				if( ((N-1)*b +a)<=high && i < maxInd ){
					boolean seqWhole = true;
					for(int j=1; j<N; j++){
						if(!set.contains(a+j*b)){
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