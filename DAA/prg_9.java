//Solve Travelling Sales Person problem using Dynamic programming.
import java.util.Scanner;

public class prg_9 {
    public static void main(String[] args) {
        int c[][] = new int[10][10];
        int tour[] = new int[10];
        int cost;
        Scanner in = new Scanner(System.in);

        System.out.println("TSP by Dynamic Programming");
        System.out.println("Enter the number of cities");
        int n = in.nextInt();

        System.out.println("Enter the cost matrix");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                c[i][j] = in.nextInt();
            }
        }

        for (int i = 1; i <= n; i++)
            tour[i] = i;
        
        cost = tsp(c, tour, 1, n);

        System.out.println("The accurate path is:");
        for (int i = 1; i <= n; i++)
            System.out.print(tour[i] + " -> ");
        System.out.println("1");

        System.out.println("The accurate cost is " + cost);
        in.close();
    }

    static int tsp(int c[][], int tour[], int start, int n) {
        int mintour[] = new int[10];
        int temp[] = new int[10];
        int mincost = 999, ccost, i, j, k;
        
        if (start == n - 1) {
            return (c[tour[n - 1]][tour[n]] + c[tour[n]][1]);
        }
        
        for (i = start + 1; i <= n; i++) {
            System.arraycopy(tour, 1, temp, 1, n);
            temp[start + 1] = tour[i];
            temp[i] = tour[start + 1];

            ccost = tsp(c, temp, start + 1, n);
            
            if ((c[tour[start]][tour[i]] + ccost) < mincost) {
                mincost = c[tour[start]][tour[i]] + ccost;
                System.arraycopy(temp, 1, mintour, 1, n);
            }
        }
        
        System.arraycopy(mintour, 1, tour, 1, n);
        return mincost;
    }
}
