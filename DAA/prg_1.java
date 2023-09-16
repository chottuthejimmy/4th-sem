import java.util.*;
public class prg_1 
{
    void sort(int arr[], int n) 
    {
        for (int i = 0; i < n - 1; i++)
	 {
            int min = i;
            for (int j = i + 1; j < n; j++)
	    {
                if (arr[j] < arr[min])
                min = j;
            }
	    int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    void print_Array(int arr[], int n) 
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " "); // Changed println to print
        System.out.println(); // Added this line to move to the next line after printing the array
    }
    public static void main(String[] args) 
    {
        int arr[] = new int[100000];
        long start, end;
        prg_1 ob = new prg_1();
        Scanner inp = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter the number of elements");
        int n = inp.nextInt();
        inp.close();
        for (int i = 0; i < n; i++) 
        {
            arr[i] = r.nextInt(1000);
        }
        System.out.println("Unsorted array"); // Moved outside the loop
        ob.print_Array(arr, n); // Moved outside the loop
        start = System.nanoTime();
        ob.sort(arr, n);
        end = System.nanoTime();
        System.out.println("Sorted array ");
        ob.print_Array(arr, n);
        System.out.println("Time taken is" + "\t" + (end - start)/1e6 + "ms");
    }
}
