package dynamicprogramming;

import java.util.Scanner;

public class UglyNumbers {

	public static void main(String[] args) {
		long[] dt = new long[10001];
		dt[0] = 1;
		int i2 =0, i3 = 0, i5 = 0;
		
		for(int i=1;i<10001;i++) {
			dt[i] = Math.min(dt[i2]*2, Math.min(dt[i3]*3, dt[i5]*5));
			if(dt[i2]*2==dt[i]) i2++;
			if(dt[i3]*3==dt[i]) i3++;
			if(dt[i5]*5==dt[i]) i5++;
		}
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0) {
			System.out.println(dt[sc.nextInt()-1]);
		}
		sc.close();
	}

}
