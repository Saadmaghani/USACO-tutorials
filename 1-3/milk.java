/*
ID: saadhku1
LANG: JAVA
TASK: milk
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class milk{
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int totalMilk = Integer.parseInt(st.nextToken());
		int totalFarmers = Integer.parseInt(st.nextToken());

		int[][] fPnA = new int[totalFarmers][2]; 
		for(int i=0; i<totalFarmers;i++){
			st = new StringTokenizer(in.readLine());
			fPnA[i][0] = Integer.parseInt(st.nextToken());
			fPnA[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fPnA, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return Integer.valueOf(a[0]).compareTo(b[0]);
			}
		});
		
		int curMilk=0, curPrice=0, i=0 ,fMilk, fPrice,milkToAdd;
		while(curMilk<totalMilk){
			fMilk = fPnA[i][1];
			fPrice = fPnA[i++][0];
			milkToAdd = ((curMilk+fMilk) < totalMilk)? fMilk : (totalMilk-curMilk);
			curPrice += milkToAdd*fPrice;
			curMilk+=milkToAdd;
			//System.out.println(curMilk+ " "+curPrice);
		}
		out.println(curPrice);
		out.close();
	}
}