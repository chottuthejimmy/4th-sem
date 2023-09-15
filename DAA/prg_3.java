import java.util.Random;
import java.util.*;
public class prg_3 
{
    public static void main(String[] args) 
    {
        int a[] = new int[100000];
        long start, end;
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter the number of elements to be sorted using Merge sort:");
        int n = sobj.nextInt();
        Random rand = new Random();
        System.out.println("Array elements to be sorted are :");
        for (int i = 0; i < n; i++) 
        {
            a[i] = rand.nextInt(1,1000);
        }
        for (int i = 0; i < n; i++) 
        {
            System.out.print(a[i] + " ");
        }
        start = System.nanoTime();
        int temp[] = new int[n]; // Create a temporary array for merging
        mergesort(a, temp, 0, n - 1);
        end = System.nanoTime();
        System.out.println("\nThe sorted elements are :");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nThe time taken to sort is " + (end - start) / 1_000_000.0 + " ms");
    }// end of main
    private static void mergesort(int[] arr, int[] temp, int left, int right) 
    {
        if (left < right) 
        {
            int mid = left + (right - left) / 2;
            mergesort(arr, temp, left, mid);
            mergesort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) 
    {
        for (int i = left; i <= right; i++) 
        {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) 
        {
            if (temp[i] <= temp[j]) 
            {
                arr[k] = temp[i];
                i++;
            } 
            else 
            {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) 
        {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
