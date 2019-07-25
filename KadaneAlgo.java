package dynamicprogramming;

import java.util.Scanner;

public class KadaneAlgo {

	public static int kadane(int[] arr) {
		int max = Integer.MIN_VALUE;
		boolean isAllNeg = true;
		for(int i:arr) {
			if(i>=0) {
				isAllNeg = false;
				break;
			}
			if(max<i) max = i;
		}
		if(isAllNeg) return max;
		int maxEndHere = 0;
		int maxSoFar = 0;
		for(int i:arr) {
			maxEndHere+=i;
			maxEndHere = maxEndHere<0?0:maxEndHere;
			maxSoFar = maxEndHere>maxSoFar?maxEndHere:maxSoFar;
		}
		
		return maxSoFar;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			System.out.println(kadane(arr));
		}
		sc.close();
	}

}
