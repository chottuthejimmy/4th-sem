/* Design and implement C++/Java Program to find a subset of a given set S = {Sl, S2,…, Sn} of n positive
 integers whose SUM is equal to a given positive integer d. For example, if S = {1, 2, 5, 6, 8} 
and d= 9, there are two solutions {1, 2, 6} and {1, 8}. Display a suitable message, if the given 
problem instance doesn't have a solution. */

import java.util.Scanner;
public class prg_11 {
    static int c = 0;
    public static void main(String[] args) {
        int w[] = new int[10];
        int n, d, i, sum = 0;
        int x[] = new int[10];
        Scanner in = new Scanner(System.in);
        System.out.println("Subset Sum Problem");
        System.out.println("Enter the number of elements");
        n = in.nextInt();
        System.out.println("Enter elements in increasing order");
        for (i = 0; i < n; i++)
            w[i] = in.nextInt();
        System.out.println("Enter the value of d");
        d = in.nextInt();
        for (i = 0; i < n; i++)
            sum += w[i];
        if (sum < d) {
            System.out.println("Subset not possible");
        } else {
            subset(0, 0, sum, x, w, d);
            if (c == 0) {
                System.out.println("Subset not possible");
            }
        }
        in.close();
    }
    static void subset(int cs, int k, int r, int x[], int w[], int d) {
        x[k] = 1;
        if (cs + w[k] == d) {
            c++;
            System.out.print("\nSolution " + c + " is {");
            for (int i = 0; i <= k; i++) {
                if (x[i] == 1) {
                    System.out.print(w[i] + " ");
                }
            }
            System.out.println("}");
        } else if ((cs + w[k] + w[k + 1]) <= d) {
            subset(cs + w[k], k + 1, r - w[k], x, w, d);
        }
        if ((cs + r - w[k]) >= d && (cs + w[k + 1]) <= d) {
            x[k] = 0;
            subset(cs, k + 1, r - w[k], x, w, d);
        }
    }
}
