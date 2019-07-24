package dynamicprogramming;

import java.util.Scanner;

public class Knapsack01 {
	
	public static int knapsack(int n, int W, int[] values, int[] wt) {
		int[][] k = new int[n+1][W+1];
		for(int i=0;i<=n;i++) {
			for(int w=0;w<=W;w++) {
				if(i==0 || w==0) {
					k[i][w] = 0;
				}else if(wt[i-1]<=w) {
					k[i][w] = Math.max(values[i-1]+k[i-1][w-wt[i-1]], k[i-1][w]);
				}else {
					k[i][w] = k[i-1][w];
				}
			}
		}
		return k[n][W];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			int n = sc.nextInt();
			int W = sc.nextInt();
			int[] values = new int[n];
			for(int i=0;i<n;i++) values[i] = sc.nextInt();
			int[] wt = new int[n];
			for(int i=0;i<n;i++) wt[i] = sc.nextInt();
			
			System.out.println(knapsack(n,W,values,wt));
		}
				
	}

}
