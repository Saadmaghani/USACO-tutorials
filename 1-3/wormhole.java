/*
ID: saadhku1
LANG: JAVA
TASK: wormhole
*/

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

class wormhole{
	static ArrayList<int[]> pairs = new ArrayList<int[]>();
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));

		int N = Integer.parseInt(in.readLine());
		int[][] wormholes = new int[N][2];
		StringTokenizer st;
		int[] allNumbers = new int[N]; 
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			wormholes[i][0] = Integer.parseInt(st.nextToken());
			wormholes[i][1] = Integer.parseInt(st.nextToken());
			allNumbers[i]=i;
		}

		allNumbers = Arrays.copyOfRange(allNumbers, 1, allNumbers.length);
		ArrayList<Integer> combos = new ArrayList<Integer>();
		combos.add(0);
		createPairs(combos, allNumbers, new int[0]);
		
		int count =0;
		for(int i=0; i < pairs.size(); i++){
			int[] curCombo = pairs.get(i);
			
			outer:
			for(int j=0; j<N; j++){
				int startHole = j, curHole=startHole;				
				while(curHole!=-1){
					curHole = checkYnHole(wormholes, curHole);
					if(curHole!=-1){
						curHole = getPair(curCombo, curHole);
						if(curHole==startHole){
							count++;
							break outer;
						}
					}
				}				
			}
		}

		out.println(count);
		out.close();
	}

	private static int getPair(int[] pairs, int holeId){
		for(int i=0; i<pairs.length;i++){
			if(pairs[i]==holeId){
				if(i%2==0) 
					return pairs[i+1];
				else
					return pairs[i-1];
			}
		}
		return -1;
	}

	private static int checkYnHole(int[][] holes, int curHole){
		int minX = 2000000000;
		int mini = -1;
		for(int i=0; i<holes.length;i++){
			if(holes[i][1]==holes[curHole][1] && holes[i][0] > holes[curHole][0] && i!=curHole){
				if(holes[i][0]<minX){
					mini=i;
					minX = holes[i][0];
				}
			}
		}
		return mini;
	}
	
	private static void createPairs(ArrayList<Integer> combos,int[] left, int[] right){
		int[] numList = concate(left,right);
		ArrayList<Integer> curCombo = new ArrayList<>(combos);
		if(numList.length == 2){
			curCombo.add(numList[0]);
			curCombo.add(numList[1]);
			pairs.add(conv(curCombo));
			return;
		}else if(numList.length%2==0){
				curCombo.add(numList[0]);
				createPairs(curCombo, Arrays.copyOfRange(numList,0, 0), Arrays.copyOfRange(numList,1, numList.length));
				curCombo = new ArrayList<>(combos);
		}else{
			for(int i=0; i<numList.length;i++){
				curCombo.add(numList[i]);
				createPairs(curCombo, Arrays.copyOfRange(numList,0, i), Arrays.copyOfRange(numList,i+1, numList.length));
				curCombo = new ArrayList<>(combos);
			}
		}	
	}

	private static int[] concate(int[] a1, int[] a2){
		int[] a3 = new int[a1.length+a2.length];
		int i;
		for(i=0; i<a1.length; a3[i]= a1[i++]);
		for(int j=0; j<a2.length;a3[i++]=a2[j++]);
		return a3;
	}

	private static int[] conv(ArrayList<Integer> al){
		int[] a = new int[al.size()];
		for(int i=0; i<al.size(); a[i]=al.get(i++));
		return a;
	}
	
}