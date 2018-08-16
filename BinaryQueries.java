/**
 * Some problems appear hard though they are very easy. Today Aakash is stuck in a range query problem. He has been given an array with only numbers 0 and 1. There are two types of queries -

0 L R : Check whether the number formed from the array elements L to R is even or odd and print EVEN or ODD respectively. Number formation is the binary number from the bits status in the array L to R

1 X : Flip the Xth bit in the array 

Indexing is 1 based

Input
First line contains a number N and Q as input. Next line contains N space separated 0 or 1. Next Q lines contain description of each query 

Output
Output for only query type 0 L R whether the number in range L to R is "EVEN" or "ODD" (without quotes).

Constraints
1≤ N ≤ 10^6 
1≤ L ≤ R ≤ 10^6 
1≤ Q ≤ 10^6

1≤ X ≤ N

SAMPLE INPUT 
5 2
1 0 1 1 0
1 2
0 1 4
SAMPLE OUTPUT 
ODD
Explanation
Our first query is 1 2 that means that we have to flip the 2nd bit in the given array so now our array becomes 1 1 1 1 0
2nd query is 0 1 4 which means that if i pick the subarray 1 to 4 i.e 1 1 1 1 then the number formed by decimal representation of this binary number is of what kind ?. Here the number formed is 15 so its odd and ODD is the output

Time Limit:	3.0 sec(s) for each input file.
Memory Limit:	256 MB
Source Limit:	1024 KB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BinaryQueries
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args)
    {
        FastReader sc=new FastReader();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        while(q--!=0){
        	int menu = sc.nextInt();
        	if(menu==1){
        		int pos = sc.nextInt();
        		pos--;
        		if(arr[pos]==0) arr[pos] = 1;
        		else arr[pos] = 0;
        	}else{
        		int start = sc.nextInt();
        		int end = sc.nextInt();
        		System.out.println(arr[end-1]==1?"ODD":"EVEN");
        	}
        }
    }
}