package dynamicprogramming;

import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumLengthChainPairs {
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			int n = sc.nextInt();
			Pair[] point = new Pair[n];
			for(int i=0;i<n;i++) 
				point[i] = new Pair(sc.nextInt(),sc.nextInt());
			
			System.out.println(maximumLengthChainPairs(point,n));
		}
		sc.close();
	}

	private static int maximumLengthChainPairs(Pair[] point, int n) {
		Arrays.sort(point,(p1,p2)->{
			return p1.x - p2.x;
		});
		int[] dp = new int[n];
		
		for(int i=0;i<n;i++) dp[i] = 1;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(point[i].x>point[j].y && dp[i]<dp[j]+1)
					dp[i] = dp[j]+1;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i:dp)
			max = max<i?i:max;
		return max;
	}
}
