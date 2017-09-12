/*
ID: saadhku1
LANG: JAVA
TASK: namenum
*/

import java.util.*;
import java.io.*;

class namenum{

 	static HashMap<Character,char[]> hm;
	static String[] words;
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

		/*
			2: A,B,C     5: J,K,L    8: T,U,V
			3: D,E,F     6: M,N,O    9: W,X,Y
			4: G,H,I     7: P,R,S

			so its 3^n and max is 3^12 < 2 mill so we're gonna go through all the options
			arrghh recursion is taking too long
		*/
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		int i=0;
		String w;
		words = new String[4650];
		while((w = dict.readLine())!=null) words[i++]=w;
		
		char[] sNo = in.readLine().toCharArray();

		hm = new HashMap<Character,char[]>();
		hm.put('2',new char[]{'A','B','C'});
		hm.put('3',new char[]{'D','E','F'});
		hm.put('4',new char[]{'G','H','I'});
		hm.put('5',new char[]{'J','K','L'});
		hm.put('6',new char[]{'M','N','O'});
		hm.put('7',new char[]{'P','R','S'});
		hm.put('8',new char[]{'T','U','V'});
		hm.put('9',new char[]{'W','X','Y'});

		ArrayList<String> list=new ArrayList<String>();
		int asd = recursive(new String(sNo), sNo, 0, list);

		if(list.isEmpty()){
			out.println("NONE");
		}else{
			for(String name:list) out.println(name);
		}
		out.close();
	}

	public static int recursive(String oG, char[] sNo, int ind, ArrayList<String> l){
		
		for(int i=0;i<3;i++){
			sNo[ind] = (hm.get(oG.charAt(ind)))[i];
			if(ind==oG.length()-1){
				String aName = new String(sNo);
				try{
					if(checkInDict(aName)) l.add(aName);
			 	}catch(IOException e){}
			}else{
				ind = recursive(oG, sNo, ++ind, l);
			}
		}
		return --ind;
	}

	public static boolean checkInDict(String word) throws IOException{
		boolean found = false;
		String readWord;
		int i=0;
		while(!found){
			readWord = words[i];
			if((int)word.charAt(0) <(int)readWord.charAt(0) || (int)readWord.charAt(0)==90) break;
			if(word.equals(readWord)) found = true;
			i++;
		}
		return found;	
	}
}