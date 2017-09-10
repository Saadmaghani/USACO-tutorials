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
		one for finding longest time no cow was being milked.
		*/

		int N = Integer.parseInt(in.readLine());
		int[][] times = new int[N][2];
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++){
			System.out.println(times[i][0] +"   "+times[i][1]);
		}
		int beg1=times[0][0], end1=times[0][1], longn1 = 10000000, long1 = end1-beg1;
		for(int i=1;i<N;i++){
			for(int j=0;j<N;j++){

				if(end1 < times[j][1] && end1 > times[j][0]){
					end1 = times[j][1];
				}
				if(beg1 > times[j][0] && beg1 <= times[j][1]){
					beg1 = times[j][0];
				}
				long1=end1-beg1;
				if(long1 < times[j][1] - times[j][0]){
					long1 = times[j][1] - times[j][0];
					beg1 = times[j][0];
					end1=times[j][1];
				}
			}			
		}
		System.out.println("beg1: "+beg1);
		System.out.println("end1: "+end1);
		System.out.println("long1: "+long1);

		
	}

}