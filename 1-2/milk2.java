/*
ID: saadhku1
LANG: JAVA
TASK: milk2
*/

import java.util.*;
import java.io.*;

class milk2{
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

		/*
		okay sooooooo
		two methods:
		one for finding longest time at least one cow was being milked.
			check one time (x) with all others until x becomes irrelevant.
			irrelevancy:
				smaller duration 
				beg time irrelevant
				end time irrelevant
			the way we do this is make a chain of intersecting times and add this chain to an array. 
			then we compute the largest chain of intersecting times. now whenever a chain is made, any time duration within that chain is irrelevant.
		one for finding longest time no cow was being milked.
			using the idea of chains of intersecting times we can compute the longest between the chains. cool
		*/

		int N = Integer.parseInt(in.readLine());
		int[][] times = new int[N][2];

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}

		//making chains:
		ArrayList<int[]> chains = new ArrayList<int[]>(N);
		int chainL = 0;
		for(int i=0; i<N; i++){
			if (existInChains(times[i],chains,chainL)) continue;
			int beg=times[i][0], end=times[i][1];
			for(int j=0; j<N;j++){
				if(i==j) continue;
				if(beg <= times[j][1] && beg > times[j][0]){
					beg = times[j][0];
					j=0;
				}
				if(end >= times[j][0] && end < times[j][1]){
					end = times[j][1];
					j=0;
				}
			}
			
			int[] adding = {beg,end};
			boolean added=false;
			for(int j=0;j<chainL;j++){ 
				if(beg < chains.get(j)[0]){
					chains.add(j,adding);
					added=true;
					break;
				}
			}
			if(!added) chains.add(adding);
			chainL++;
		}

		
		int long1 = 0, longn1 = 0;
		for(int[] cs:chains){
			if(long1 < cs[1]-cs[0]) long1 = cs[1]-cs[0];
			System.out.println(cs[0]+ "  "+cs[1]+" "+(cs[1]-cs[0]));
		}

		for(int i=0; i<chainL-1;i++){
			if(longn1 < chains.get(i+1)[0]-chains.get(i)[1]) longn1= chains.get(i+1)[0]-chains.get(i)[1];
		}

		out.println(long1 + " "+longn1);
		out.close();
	}

	public static boolean existInChains(int[] time, ArrayList<int[]> chains, int n){
		for(int[] cs:chains){
			if(cs[0] <= time[0] && cs[1] >= time[1]){
				return true;
			}
		}
		return false;
	}

}