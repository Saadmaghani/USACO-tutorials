/*
ID: saadhku1
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;

class friday{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

/*
	Notes from the USACO site:
	January 1, 1900 was on a Monday.
	Thirty days has September, April, June, and November, all the rest have 31 except for February which has 28 except in leap years when it has 29.
	Every year evenly divisible by 4 is a leap year (1992 = 4*498 so 1992 will be a leap year, but the year 1990 is not a leap year)
	The rule above does not hold for century years. Century years divisible by 400 are leap years, all other are not. 
	Thus, the century years 1700, 1800, 1900 and 2100 are not leap years, but 2000 is a leap year.

	Notes made by self:
	Months:     Jn Fb     Mr Ap My Jn Jl Ag Sp Oc Nv Dc 
	Days:       31 28/29  31 30 31 30 31 31 30 31 30 31
	
	Months:  Jn Fb Mr Ap My Jn Jl Ag Sp Oc Nv Dc
	ids:     1  2  3  4  5  6  7  8  9  10 11 0

	Days:  M T W T F S S
	ids:   1 2 3 4 5 6 0
*/
		int N = Integer.parseInt(in.readLine());

		int curMonth = 1;
		int bOMI = (1-1)%7; //beggining of month index. formula instead of actual number (0) given 

		int[] daysOfMonth = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30}; //Dec first as its id is 0
		int[] thirteenthDay = new int[7]; //sunday first and then m,t,w,...,sat
		
		for(int curYear = 1900; curYear < (1900+N); curYear++){
			daysOfMonth[2] = isLeapYear(curYear);

			for(int i =0; i<12; i++){
				//getting thirteenth day
				//the thirteenth of every month (thirteenth) will be (13 + bomi)%7 and then thirteenthDay[thirteenth]++
				int thirteenth = (13+bOMI)%7;
				thirteenthDay[thirteenth]++;

				//moving to next month:
				int daysInMonth = daysOfMonth[curMonth];
				int bOMID = (++daysInMonth + bOMI)%7;
				bOMI = bOMID - 1;
				curMonth = (++curMonth)%12;
			}
		}

		int id = 6;
		String output = "";
		for (int i=0; i<6; i++) {
			output+= thirteenthDay[id]+ " ";
			id = ++id%7;	
		}
		output+= thirteenthDay[id];
		
		out.println(output);
		out.close();
	}

	public static int isLeapYear(int year){
		if((year%400 == 0)||(year%4==0 && year%100 !=0)){
			return 29;
		}
		return 28;
	}

}