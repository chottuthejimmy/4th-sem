//To find Minimum Cost Spanning Tree of a given connected undirected graph using Kruskal's algorithm. Use Union-Find algorithms in your program. 

import java.util.Scanner;
public class prg_6 {
    public static void main(String[] args) {
        int cost[][] = new int[10][10];
        int i, j, mincost = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Kruskal's Algorithm");
        System.out.println("Enter the number of nodes");
        int n = in.nextInt();
        System.out.println("Enter the cost matrix");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = in.nextInt();
            }
        }
        System.out.println("The entered cost matrix is");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                System.out.print(cost[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("The MST edges and costs are");
        mincost = kruskal(cost, n);
        System.out.println("The MST cost is");
        System.out.println(mincost);
        in.close();
    }
    static int kruskal(int cost[][], int n) {
        int mincost = 0;
        int parent[] = new int[10];
        for (int i = 1; i <= n; i++) {
            parent[i] = 0;
        }
        for (int ne = 1; ne < n; ) {
            int min = 999, a = 0, b = 0, u = 0, v = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }
            u = find(u, parent);
            v = find(v, parent);
            if (union(u, v, parent) != 0) {
                System.out.print((ne++) + ") Min edge is ");
                System.out.println("(" + a + "," + b + ") and cost is " + min);
                mincost += min;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        return mincost;
    }
    static int find(int i, int parent[]) {
        while (parent[i] != 0) {
            i = parent[i];
        }
        return i;
    }
    static int union(int i, int j, int parent[]) {
        if (i != j) {
            parent[j] = i;
            return 1;
        } else {
            return 0;
        }
    }
}
