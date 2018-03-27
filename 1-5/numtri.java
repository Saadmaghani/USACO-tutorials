/*
ID: saadhku1
LANG: JAVA
TASK: numtri
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class numtri{
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

		ArrayList<Integer> tree = new ArrayList<Integer>();
		int R = Integer.parseInt(in.readLine());

		for(int i=0;i<R;i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<=i; j++){
				tree.add(Integer.parseInt(st.nextToken()));
			}
		}

		numtri ans = new numtri();
		int max = ans.solve2(tree,R);
		//System.out.println(max);
		out.println(max);
		out.close();
	}

	//this is a complete solution but slow... O(2^d)... top->down
	public int solve1(ArrayList<Integer> tree, int index, int depth){
		if(index + depth <tree.size()){
			int firstBacha = solve1(tree, index+depth, depth+1);
			int secondBacha = solve1(tree, index+depth + 1, depth+1);

			if(firstBacha > secondBacha){
				return tree.get(index) + firstBacha;
			}else{
				return tree.get(index) + secondBacha;
			}
		}else{
			return tree.get(index);
		}
	}

	//complete solution but O(d^2) :D down->top
	public int solve2(ArrayList<Integer> tree, int depth){
		if(depth>1){
			
			for(int i=0; i<depth-1; i++){
				int ind = getInd(depth)+i;
				int a = tree.get(ind), b = tree.get(ind+1);

				int pInd = ind-depth+1;
				int parentVal = tree.get(pInd);
				if(a>b){
					tree.set(pInd, parentVal+ a);
				}else{
					tree.set(pInd, parentVal+ b);
				}
			}
			return solve2(tree, depth-1);
		}else{
			return tree.get(0);
		}
	}

	public static int getInd(int cat){
		return (cat*cat - cat)/2;
	}
}