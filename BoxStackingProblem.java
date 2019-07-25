package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class BoxStackingProblem {
	
	static class Box{
		int a;
		int b;
		int c;
		
		public Box(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static int boxStack(Box[] box, int n) {
		int[] dp = new int[n*3];
		
		for(int i=0;i<n*3;i++)
			dp[i] = box[i].c;
		
		for(int i=1;i<n*3;i++) {
			for(int j=0;j<i;j++) {
//				System.out.println(j+"th box:("+box[j].a+","+box[j].b+","+box[j].c+")");
//				System.out.println(i+"th box:("+box[i].a+","+box[i].b+","+box[i].c+")");
				if(box[j].a>box[i].a && box[j].b>box[i].b && dp[i] < box[i].c+dp[j])
					dp[i] = box[i].c+dp[j];
//				System.out.println(Arrays.toString(dp));
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i:dp)
			max = i>max?i:max;
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			int n = sc.nextInt();
			Box[] box = new Box[3*n];
			int i = -1;
			while(i<3*n-1){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				
				box[++i] = new Box(Math.min(a, b),Math.max(a, b),c);
				box[++i] = new Box(Math.min(b, c),Math.max(b, c),a);
				box[++i] = new Box(Math.min(a, c),Math.max(a, c),b);
			}
			Arrays.sort(box,(b1,b2)->{
				return b2.a*b2.b-b1.a*b1.b;
			});
			
			System.out.println(boxStack(box,n));
		}
		sc.close();
	}

}
