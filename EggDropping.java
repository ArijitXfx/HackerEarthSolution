package dynamicprogramming;

import java.util.Scanner;

public class EggDropping {

	public static int minAttempt(int n, int k) {
		int[][] dp = new int[n+1][k+1];
		for(int i=1;i<=n;i++)
			dp[i][1] = 1;
		for(int i=1;i<=k;i++)
			dp[1][i] = i;
		
		for(int i=2;i<=n;i++) {
			for(int j=2;j<=k;j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for(int x=1;x<=j;x++) {
					int res = 1+Math.max(dp[i-1][x-1], dp[i][j-x]);
					if(dp[i][j]>res) dp[i][j] = res;
				}
			}
		}
		
//		for(int i=0;i<=n;i++) {
//			for(int j=0;j<=k;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		return dp[n][k];
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(minAttempt(n, k));
		}
		sc.close();
	}

}
