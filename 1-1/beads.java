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
		StringBuilder sb = new StringBuilder(in.readLine());

		/*
			second method is very simple 
			okay so

			rwbwrwbwr
			it becomes
			0: rwbwrwbwr and rwbwrwbwr
			1: wbwrwbwrr and rrwbwrwbw
			2: 

		*/
		int lr = count(sb.toString());
		int rl = count(sb.reverse().toString());
		int highestAdded = rl+lr;
		sb.reverse();

		for(int i=1;i<N;i++){
			lr = count(sb.append(sb.charAt(0)).deleteCharAt(0).toString());
			rl = count(sb.reverse().toString());
			sb.reverse();
			highestAdded = ((rl+lr) > highestAdded)? rl+lr:highestAdded;
			if (highestAdded>=N){
				highestAdded=N;
				break;
			}
		}
		out.println(highestAdded);
		out.close();
	}
	public static int count(String beadss){
		char colour = beadss.charAt(0);
		int count =1;
		for(int i=1;i<beadss.length();i++){
			switch(beadss.charAt(i)){
				case 'r':
					if(colour=='b'){
						return count;
					}else if(colour=='w'){
						count++;
						colour='r';
					}else{
						count++;
					}
				break;
				case 'b':
					if(colour=='r'){
						return count;
					}else if(colour=='w'){
						count++;
						colour='b';
					}else{
						count++;
					}
				break;
				case 'w':
					count++;
			}
		}
		return count;
	}
}