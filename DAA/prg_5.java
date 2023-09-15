//To find shortest paths to other vertices from a given vertex in a weighted connected graph, using Dijkstra's algorithm. 

import java.util.Scanner;
public class prg_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, sv;
        System.out.println("DIJKSTRA");
        System.out.println("Enter the number of nodes:");
        n = in.nextInt();
        int[][] cost = new int[n + 1][n + 1];
        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];
        System.out.println("Enter the cost matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter the source vertex:");
        sv = in.nextInt();
        dijkstra(cost, dist, sv, n, path);
        printShortestPaths(sv, n, dist, path);
        in.close();
    }
    static void dijkstra(int cost[][], int dist[], int sv, int n, int path[]) {
        int visited[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = 0;
            dist[i] = cost[sv][i];
            path[i] = (cost[sv][i] == 999) ? 0 : sv;
        }
        visited[sv] = 1;
        for (int count = 2; count <= n; count++) {
            int min = 999, v = 0;
            for (int w = 1; w <= n; w++) {
                if (dist[w] < min && visited[w] == 0) {
                    min = dist[w];
                    v = w;
                }
            }
            visited[v] = 1;
            for (int w = 1; w <= n; w++) {
                if (dist[w] > dist[v] + cost[v][w]) {
                    dist[w] = dist[v] + cost[v][w];
                    path[w] = v;
                }
            }
        }
    }
    static void printShortestPaths(int sv, int n, int dist[], int path[]) {
        for (int w = 1; w <= n; w++) {
            if (w != sv) {
                System.out.println("Shortest distance from " + sv + " to " + w + " is " + dist[w]);
                System.out.print("Path: " + w);
                int t = path[w];
                while (t != sv) {
                    System.out.print(" <- " + t);
                    t = path[t];
                }
                System.out.println(" <- " + sv);
            }
        }
    }
}

