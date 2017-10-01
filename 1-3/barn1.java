/*
ID: saadhku1
LANG: JAVA
TASK: barn1
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class barn1{
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] stalls = new int[S+1];
		for(int i=1; i<=C;i++){
			stalls[Integer.parseInt(in.readLine())] = 1;
		}

		ArrayList<int[]> chains = new ArrayList<>();
		

		for(int i=1; i<=S; i++){
			if(stalls[i]==1){
				int j;
				for(j=i+1;j<=S;j++){
					if(stalls[j]!=1) break;
				}			
				chains.add(new int[] {i,j-1});
				i=j;
			}
		}
		/* going from L->R gave 183 for test case 8
		int chainLength=1, chainB, chainE, nxtChainB, nxtChainE;
		while(chains.size()>M){
			chainLength++;
			for(int i = 0; i < (chains.size()-1); i++){
				nxtChainB = chains.get(i+1)[0];
				chainE = chains.get(i)[1];
				if((chainE + chainLength) <S && (chainE+chainLength==nxtChainB) ){
					chainB = chains.get(i)[0];
					nxtChainE = chains.get(i+1)[1];
					chains.set(i, new int[] {chainB, nxtChainE});
					chains.remove(i+1);
					i--;			
				}
				if(chains.size()==M) break;
			}			
		}	
		*/
		//going from R->L this worked... not sure what the difference is
		int chainLength=1, chainB, chainE, nxtChainB, nxtChainE;
		while(chains.size()>M){
			chainLength++;
			for(int i = (chains.size()-1); i > 0; i--){
				nxtChainE = chains.get(i-1)[1];
				chainB = chains.get(i)[0];
				if((chainB - chainLength) >0 && (chainB-chainLength==nxtChainE) ){
					chainE = chains.get(i)[1];
					nxtChainB = chains.get(i-1)[0];
					chains.set(i, new int[] {nxtChainB, chainE});
					chains.remove(i-1);			
				}
				if(chains.size()==M) break;
			}			
		}


		int totalBlocked =0;
		for(int i=0; i<chains.size();i++){
			chainB = chains.get(i)[0];
			chainE = chains.get(i)[1];	
			totalBlocked += (chainE-chainB+1);
			//System.out.println(chainB+ "   "+chainE);
		}
		out.println(totalBlocked);
		out.close();
	}
}