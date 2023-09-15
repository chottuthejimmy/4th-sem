//To solve Knapsack problem using Greedy method.

import java.util.Scanner;
public class prg_4 {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("0/1 Knapsack problem by Greedy Method");
        System.out.println("Enter total number of items");
        int n = in.nextInt();
        float[] w = new float[n+1];
        float[] p = new float[n+1];
        float[] ratio = new float[n+1];
        System.out.println("Enter weight of each item");
        for (int i = 1; i <= n; i++) 
        {
            w[i] = in.nextFloat();
        }
        System.out.println("Enter profit of each item");
        for (int i = 1; i <= n; i++) 
        {
            p[i] = in.nextFloat();
        }
        System.out.println("Enter Knapsack capacity");
        int m = in.nextInt();
        for (int i = 1; i <= n; i++)
        {
            ratio[i] = p[i] / w[i];
        }
        System.out.println("Information about the problem is");
        displayInfo(n, w, p, ratio);
        System.out.println("Capacity is " + m);
        sortArray(n, ratio, w, p);
        System.out.println("Details after sorting items on p/w ratio in descending order");
        displayInfo(n, w, p, ratio);
        greedyKnapsack(m, n, w, p);
        in.close();
    }
    static void sortArray(int n, float[] ratio, float[] w, float[] p) 
    {
        for (int i = 1; i <= n; i++)
         {
            for (int j = 1; j <= n - i; j++) 
            {
                if (ratio[j] < ratio[j + 1])
                 {
                    float tempRatio = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = tempRatio;
                    float tempW = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = tempW;
                    float tempP = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = tempP;
                }
            }
        }
    }
    static void displayInfo(int n, float[] w, float[] p, float[] ratio) 
    {
        System.out.println("ITEM\tWEIGHT\tPROFIT\tRATIO");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "\t" + w[i] + "\t" + p[i] + "\t" + ratio[i]);
        }
    }
    static void greedyKnapsack(int u, int n, float[] w, float[] p) {
        float[] x = new float[n + 1];
        float tp = 0;
        int i;
        for (i = 1; i <= n; i++) 
        {
            x[i] = 0;
        }
        for (i = 1; i <= n; i++)
         {
            if (w[i] > u) 
            {
                break;
            } 
            else 
            {
                x[i] = 1;
                tp += p[i];
                u -= w[i];
            }
        }
        if (i <= n) 
        {
            x[i] = u / w[i];
        }
        tp += x[i] * p[i];
        System.out.println("Result is");
        for (i = 1; i <= n; i++) 
        {
            System.out.println("\t" + x[i]);
        }
        System.out.println("Max profit = " + tp);
    }
}
