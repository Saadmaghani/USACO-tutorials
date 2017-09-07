/*
ID: saadhku1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

class ride{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		String cName = in.readLine(), gName = in.readLine();
		int cMod = 1, gMod=1;

		for(int i=0; i<cName.length(); cMod *= (((int) cName.charAt(i++)) -64));
		for(int i=0; i<gName.length(); gMod *= (((int) gName.charAt(i++)) -64));
		cMod = cMod % 47;
		gMod = gMod % 47;

		String o = (cMod==gMod)?"GO":"STAY";
		
		out.println(o);
		out.close();
	}

}