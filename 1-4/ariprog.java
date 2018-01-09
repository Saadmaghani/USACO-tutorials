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

		SortedSet<Integer> set = new TreeSet<Integer>();
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		for(int p=0; p<=M; p++){
			for(int q=p; q<=M; q++){
				int x = (p*p) + (q*q);
				set.add(x);
			}
		}

//		System.out.println(set.size());

		int high = set.last();
		int maxInd = set.size()-N+1;
		boolean found = false;
		for(int b=1; b <= (high/(N-1)); b++){
			
			int ind = 0;
			Iterator it = set.iterator();
			while(it.hasNext()){
				int a = (Integer) it.next();	
				if(((N-1)*b +a) <=high && ind++ < maxInd ){
					boolean seqWhole = true;
					for(int i=1; i<(N-1); i++){
						if(!set.contains(a+i*b)){
							seqWhole=false;
							break;
						}
					}
					if(seqWhole){
						found = true;
						out.println(a+" "+b);
					}
				}else{
					break;
				}
			}	
		}

		if(!found) out.println("NONE");
		out.close();
	}
}