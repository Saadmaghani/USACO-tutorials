/*
ID: saadhku1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1{
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

/*
okay so what i have to do is that there will be one kv pair. this will be like this:
{key: name_of_guy, val: people_he_owes}

THERE WILL BE ANOTHER KV PAIR U IDGET SERIOUSLY
{key: name_of_guy, val: netamount}

IDIOT
*/
		int NP = Integer.parseInt(in.readLine());
		
		LinkedHashMap<String,Integer> net = new LinkedHashMap<String,Integer>();

		for(int i =0;i<NP;i++){
			String name = in.readLine();
			net.put(name,0);
		}
		for(int i=0;i<NP;i++){
			String name = in.readLine();

			StringTokenizer moneys = new StringTokenizer(in.readLine());
			int neg = Integer.parseInt(moneys.nextToken());
			int no = Integer.parseInt(moneys.nextToken());
			if(no!=0){
				int givingChange = (neg % no) - neg;
				int curBalance = net.get(name);
				givingChange += curBalance;
				net.replace(name,givingChange);
				for(int j=0;j<no;j++){
					String toName = in.readLine();
					curBalance = net.get(toName);
					curBalance += neg/no;
					net.replace(toName,curBalance);			
				}	
			}
			
		}
		for (Map.Entry<String, Integer> entry : net.entrySet()){
			    out.println(entry.getKey() + " " + entry.getValue());
		}
		out.close();
	}

}