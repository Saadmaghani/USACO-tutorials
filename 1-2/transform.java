/*
ID: saadhku1
LANG: JAVA
TASK: transform
*/

import java.util.*;
import java.io.*;

class transform{
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		/*
		from exercise:
			#1: 90 Degree Rotation: The pattern was rotated clockwise 90 degrees.
			#2: 180 Degree Rotation: The pattern was rotated clockwise 180 degrees.
			#3: 270 Degree Rotation: The pattern was rotated clockwise 270 degrees.
			#4: Reflection: The pattern was reflected horizontally 
				(turned into a mirror image of itself by reflecting around a vertical line in the middle of the image).
			#5: Combination: The pattern was reflected horizontally and then subjected to one of the rotations (#1-#3).
			#6: No Change: The original pattern was not changed.
			#7: Invalid Transformation: The new pattern was not obtained by any of the above methods.
			
		own notes:
			so 7 possible transformations(1;2;3;4;5:4+1,4+2,4+3)
			then one no change
			then one invalid
			okay so just transform and then check. transform from 1->5 and check after each transformation. and then check 6. and then declare 7
			okay so 2 basic functions and 5 is just doing 4 then 1/2/3
			cool

			gonna store in char array? YEEE
		*/
		int N = Integer.parseInt(in.readLine());
		char[][] squareB = new char[N][N];
		char[][] squareA = new char[N][N];

		for(int i=0;i<N;i++){
			String l = in.readLine();
			for(int j=0;j<N;j++){
				squareB[i][j]=l.charAt(j);
			}
		}
		for(int i=0;i<N;i++){
			String l = in.readLine();
			for(int j=0;j<N;j++){
				squareA[i][j]=l.charAt(j);
			}
		}

		char[][] tf = squareB;
		int onTransform=0;
		int tries =0, counter =0;
		while(onTransform==0){
			switch(tries){
				case 0:
				case 1:
				case 2:
					tf = rotate(tf,N);
					tries++;
					break;
				case 3:
					tf = reflect(squareB,N);
					tries++;
					break;
				case 4:
					tf = rotate(tf,N);
					counter++;
					break;
				case 5:
					tf = squareB;
					tries++;
					break;
				case 6:
					onTransform=7;
					break;
			}
			if(matchup(tf,squareA,N)){
				if(counter > 0 && counter<=3){
					onTransform = 5;
				}else{
					onTransform = tries;
				}
			}	
			
			if(counter==3) {
				counter=4;
				tries=5;
			}
		}

		out.println(onTransform);
		out.close();
	}
	public static boolean matchup(char[][] tf, char[][] checkAgainst, int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(tf[i][j] != checkAgainst[i][j]) return false;
			}
		}
		return true;
	}
		
	public static char[][] rotate(char[][] toTransform, int n){ //90 Degree Rotation:
		char[][] transformed = new char[n][n];
		for(int i=0; i<n; i++){
			for(int j=n-1; j>=0; j--){
				transformed[i][(((-1-j)%n)+n)%n] = toTransform[j][i];
			}
		}
		return transformed;
	}

	public static char[][] reflect(char[][] toTransform, int n){ //reflect:
		char[][] transformed = new char[n][n];
		for(int i=0; i<n; i++){
			for(int j=0;j<n;j++){
				transformed[i][j] = toTransform[i][(((-1-j)%n)+n)%n];
			}
		}
		return transformed;
	}
	

}