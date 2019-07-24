package dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class CatalanNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BigInteger[] dt = new BigInteger[101];
		dt[0] = dt[1] = BigInteger.ONE;
		for(int i=2;i<101;i++) {
			dt[i] = BigInteger.ZERO;
			for(int j=0;j<i;j++) {
				dt[i] = dt[i].add(dt[j].multiply(dt[i-j-1]));
			}
		}
		
//		for(int i=0;i<11;i++) System.out.println(dt[i]);
		
		int test = sc.nextInt();
		while(test-->0) {
			System.out.println(dt[sc.nextInt()]);
		}
		
		sc.close();
	}

}
