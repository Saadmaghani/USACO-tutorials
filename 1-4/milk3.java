/*
ID: saadhku1
LANG: JAVA
TASK: milk3
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class milk3{
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int maxA = Integer.parseInt(st.nextToken());
		int maxB = Integer.parseInt(st.nextToken());
		int maxC = Integer.parseInt(st.nextToken());

		
		ArrayList<Integer> ans = new ArrayList<Integer>();
	
		LinkedList<state> frontier = new LinkedList<state>();
		
		frontier.addFirst(new state(0,0,maxC));
		HashSet<state> explored = new HashSet<state>();
	
		while(frontier.peek() != null){
			state curState = frontier.poll();
			if(!explored.contains(curState)){
				if(isGoalState(curState)) ans.add(curState.get(2));
				for(int i=0; i<3; i++){
					for(int j=0; j<3; j++){
						if(i!=j){
							int maxTo = getJarByIndex(j,maxA,maxB,maxC);
							if(curState.get(i)!=0 && curState.get(j)<maxTo){
								state newState = new state(curState);
								if(maxTo - curState.get(j) >= curState.get(i)){
									newState.addOn(j, newState.get(i));
									newState.set(i, 0);
								}else{
									newState.addOn(i, newState.get(j)-maxTo);
									newState.set(j,maxTo);
								}
								frontier.addFirst(newState);
							}
						}
					}
				}
				explored.add(curState);
			}
		}
		Collections.sort(ans);
		
		String finalAns ="";
		for(int i=0; i<ans.size()-1;i++){
			finalAns+=ans.get(i)+" ";
		}
		finalAns+=ans.get(ans.size()-1)+"";
		out.println(finalAns);
		out.close();
	}

	public static boolean isGoalState(state s){
		if(s.get(0)==0) return true;
		return false;
	}

	public static int getJarByIndex(int index, int a, int b, int c){
		switch(index){
			case 0:
				return a;
			case 1:
				return b;
			default:
				return c;	
		}
	}
	
	static class state{
		int a, b,c;
		
		state(state x){
			a = x.a;
			b = x.b;
			c = x.c;
		}
		
		state(int a,int b, int c){
			this.a=a;
			this.b=b;
			this.c=c;
		}
		
		public int get(int index){
			switch(index){
			case 0:
				return a;
			case 1:
				return b;		
			default:
				return c;
			}
		}

	
		public void addOn(int index, int val){
			switch(index){
			case 0:
				a += val;
				break;
			case 1:
				b +=val;
				break;
			default:
				c +=val;
			}
		}
		
		public void set(int index, int val){
			switch(index){
			case 0:
				a = val;
				break;
			case 1:
				b =val;
				break;
			default:
				c =val;
			}
		}
		
		@Override
		public boolean equals(Object obj) {
			state o = (state)obj;
			for(int i=0; i<3; i++){
				if(this.get(i)!=o.get(i)) return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			int newHash=0;
			newHash+= c;
			newHash+= 100*b;
			newHash+= 1000*a;
			return newHash;
		}
		
		
	}
	
}