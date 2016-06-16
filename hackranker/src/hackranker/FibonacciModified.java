package hackranker;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        BigInteger t = null;
        BigInteger f1 = BigInteger.valueOf(a);
        BigInteger f2 = BigInteger.valueOf(b);
        for (int i=2;i<n;i++) {
            t = f2;
            f2 = f2.multiply(f2).add(f1);
            f1 = t;
        }
        System.out.println(f2.toString());
        in.close();
    }
}
