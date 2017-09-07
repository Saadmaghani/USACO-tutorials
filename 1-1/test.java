/*
ID: saadhku1
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test{
	public static void main(String [] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		out.println(x+y);
		out.close();
	}
}
