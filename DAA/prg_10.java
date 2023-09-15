//Solve 0/1 Knapsack problem using Dynamic Programming method.
import java.util.Scanner;

public class prg_10 {

    public static void main(String[] args) {
        int v[][] = new int[10][10];
        int w[] = new int[10];
        int p[] = new int[10];
        Scanner in = new Scanner(System.in);
        int i, j;

        System.out.println("0/1 Knapsack by Dynamic Programming");
        System.out.println("Enter total number of items");
        int n = in.nextInt();

        System.out.println("Enter weight of each item");
        for (i = 1; i <= n; i++) {
            w[i] = in.nextInt();
        }

        System.out.println("Enter profit of each item");
        for (i = 1; i <= n; i++) {
            p[i] = in.nextInt();
        }

        System.out.println("Enter Knapsack capacity");
        int m = in.nextInt();

        displayInfo(m, n, w, p);
        knapsack(m, n, w, p, v);

        System.out.println("Contents of Knapsack table are");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        optimal(m, n, w, v);

        in.close();
    }

    static void displayInfo(int m, int n, int w[], int p[]) {
        System.out.println("ITEM\tWEIGHT\tPROFIT");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "\t" + w[i] + "\t" + p[i]);
        }
        System.out.println("Capacity=" + "\t" + m);
    }

    static void knapsack(int m, int n, int w[], int p[], int v[][]) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    v[i][j] = 0;
                else if (j < w[i])
                    v[i][j] = v[i - 1][j];
                else
                    v[i][j] = max(v[i - 1][j], v[i - 1][j - w[i]] + p[i]);
            }
        }
    }

    static void optimal(int m, int n, int w[], int v[][]) {
        int i = n, j = m, item = 0;
        int x[] = new int[10];
        
        while (i != 0 && j != 0) {
            if (v[i][j] != v[i - 1][j]) {
                x[i] = 1;
                j = j - w[i];
            }
            i = i - 1;
        }

        System.out.println("Optimal solution is" + "\t" + v[n][m]);
        System.out.println("Selected items are");
        for (i = 1; i <= n; i++) {
            if (x[i] == 1) {
                System.out.print(i + " ");
                item = i;
            }
        }
        
        if (item == 0) {
            System.out.println("Knapsack is full");
        }
    }

    private static int max(int i, int j) {
        return i > j ? i : j;
    }
}
