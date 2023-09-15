
/* Design and implement C++/Java Program to find all Hamiltonian Cycles in a connected 
undirected Graph G of n vertices using backtracking principle.*/
import java.util.Scanner;

public class prg_12 {
    int count;
    int path = 1;

    public static void main(String[] args) {
        int graph[][] = new int[10][10];
        Scanner in = new Scanner(System.in);

        System.out.println("Hamiltonian Cycles");
        System.out.println("Enter the number of nodes");
        int n = in.nextInt();

        System.out.println("Enter the adjacency matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;

        System.out.println("All possible Hamiltonian Cycles are:");
        new prg_12().permute(arr, graph);

        in.close();
    }

    void permute(int arr[], int graph[][]) {
        permute(arr, 0, arr.length - 1, graph);
    }

    void permute(int arr[], int i, int n, int cost[][]) {
        int j;
        if (i == n) {
            hamCycle(arr, cost);
        } else {
            for (j = i; j <= n; j++) {
                swap(arr, i, j);
                permute(arr, i + 1, n, cost);
                swap(arr, i, j);
            }
        }
    }
    void hamCycle(int a[], int graph[][]) {
        count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (graph[a[i]][a[i + 1]] != 0)
                count++;
        }
        if (count == a.length - 1 && graph[a[a.length - 1]][a[0]] == 1) {
            System.out.println("Cycle no. " + path + " ->");
            for (int i = 0; i < a.length; i++)
                System.out.print(a[i] + " ");
            System.out.println(a[0]);
            System.out.println();
            path++;
        }
    }
    void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
