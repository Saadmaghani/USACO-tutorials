/*
ID: saadhku1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

class beads{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
	
		int N = Integer.parseInt(in.readLine());
		String beeaads = in.readLine();

		/*
			first method will be the "dash" method. count number of adjacent same coloured beads and put in array. first go from L->R then R->L 
			and see which two adjacent "dashes" are the largest and thus form the most number of beads
			DOESNT WORK. but close. problem of: rwbwrwbwr comes
		*/

		int[] dashLR = doIT(N,beeaads);
		int[] dashRL = doIT(N,new StringBuilder(beeaads).reverse().toString());

		for(int i=0;i<N;i++){
			System.out.print(dashLR[i]+" ");
		}
		System.out.println();
		for(int i=0;i<N;i++){
			System.out.print(dashRL[i]+" ");
		}
		
		int highestAdjDash = 0;
		for(int i=0;i<N-1;i++){
			int lr = dashLR[i] + dashLR[i+1];
			int rl = dashRL[i] + dashRL[i+1];

			lr = (rl>lr) ? rl:lr;
			highestAdjDash = (highestAdjDash>lr)? highestAdjDash: lr;
		}

		out.println(highestAdjDash);
		out.close();
	}

	public static int[] doIT(int n, String beeads){
		int[] dashArray = new int[n];
		int dashIndex = 0;

		char prevColour = beeads.charAt(0);
		char firstColour='w';   
		dashArray[dashIndex]++;
		for(int i=1;i<n;i++){                 
			switch(beeads.charAt(i)){
				case 'w':
					dashArray[dashIndex]++;
				break;
				case 'r':
					if(prevColour=='b'){
						dashIndex++;
						dashArray[dashIndex]++;
						if(dashIndex==1) firstColour='b';
					}else{
						dashArray[dashIndex]++;
					}
					prevColour='r';
				break;
				case 'b':
					if(prevColour=='r'){
							dashIndex++;
							dashArray[dashIndex]++;
							if(dashIndex==1) firstColour='r';
					}else{
						dashArray[dashIndex]++;
					}
					prevColour='b';
			}
		}

		if(prevColour == firstColour){
			dashArray[0]+=dashArray[dashIndex];
			dashArray[dashIndex]=0;
		}
		return dashArray;
	}
}