package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(lbs(arr,n));
		}
		sc.close();
	}

	private static int lbs(int[] arr, int n) {
		int[] lis = lis(arr,n);
//		System.out.println(Arrays.toString(lis));
		int[] lds = lds(arr,n);
//		System.out.println(Arrays.toString(lds));
		
		int max = lis[0]+lds[0]-1;
		for(int i=1;i<n;i++)
			if(max<lis[i]+lds[i]-1)
				max = lis[i]+lds[i]-1;
		return max;
	}

	private static int[] lis(int[] arr, int n) {
		int[] lis = new int[n];
		Arrays.fill(lis, 1);
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && lis[j]+1>lis[i])
					lis[i] = lis[j]+1;
			}
		}
		
		return lis;
	}

	private static int[] lds(int[] arr, int n) {
		int[] lds = new int[n];
		Arrays.fill(lds, 1);
		for(int i=n-2;i>=0;i--) {
			for(int j=n-1;j>i;j--) {
				if(arr[i]>arr[j] && lds[i]<lds[j]+1)
					lds[i] = lds[j]+1;
			}
		}
		
		return lds;
	}

}
