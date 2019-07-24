package dynamicprogramming;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			String str = sc.next();
			System.out.println(lps(str,str.length()));
		}
		sc.close();
	}

	private static int lps(String str, int n) {
		int[][] dp = new int[n+1][n+1];
		
		for(int i=0;i<=n;i++)
			dp[i][i] = 1;
		
		for(int l=2;l<=n;l++) {
			for(int i=1;i<=n-l+1;i++) {
				int j = i+l-1;
				if(str.charAt(i-1)==str.charAt(j-1) && l==2)
					dp[i][j] = 2;
				else if(str.charAt(i-1)==str.charAt(j-1))
					dp[i][j] = 2+dp[i+1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
			}
		}
		for(int i=0;i<=n;i++) {
		for(int j=0;j<=n;j++) {
			System.out.print(dp[i][j]+" ");
		}
		System.out.println();
	}
		
		return dp[1][n];
	}

}
