
import java.util.Random;
import java.util.Scanner;

public class MSort {
	 void combine(int sample1[], int left, int midvalue, int right)
	    {
	        
	        int size1 = midvalue - left + 1;
	        int size2 = right - midvalue;
	 
	        
	        int temp1[] = new int [size1];
	        int temp2[] = new int [size2];
	 
	        
	        for (int i=0; i<size1; ++i)
	            temp1[i] = sample1[left + i];
	        for (int j=0; j<size2; ++j)
	            temp2[j] = sample1[midvalue + 1+ j];
	 
	 
	        
	        int i = 0, j = 0;
	 
	        int k = left;
	        while (i < size1 && j < size2)
	        {
	            if (temp1[i] <= temp2[j])
	            {
	                sample1[k] = temp1[i];
	                i++;
	            }
	            else
	            {
	                sample1[k] = temp2[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < size1)
	        {
	            sample1[k] = temp1[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < size2)
	        {
	            sample1[k] = temp2[j];
	            j++;
	            k++;
	        }
	    }
	 
	    // Main function that sorts arr[l..r] using
	    // merge()
	    void msort(int[] sample, int left, int right)
	    {
	        if (left < right)
	        {
	            
	            int midvalue = (left+right)/2;
	 
	            // Sort first and second halves
	            msort(sample, left, midvalue);
	            msort(sample , midvalue+1, right);
	 
	            // Merge the sorted halves
	            combine(sample, left, midvalue, right);
	        }
	    }
	    void printRange(int[] arr, int m, int n ) {
	    	for(int i=m; i<n;i++) {
	    		System.out.println(arr[i]);
	    	}
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inp= new int[100000];
		Random rd = new Random();
		for(int i=0; i<100000;i++) {
			inp[i]=(rd.nextInt((100000 - 0) + 1) + 0);
		}
		
		MSort ms= new MSort();
		long start = System.nanoTime();
		ms.msort(inp, 0, inp.length-1);
		long stop = System.nanoTime();
		long running= stop-start;
		//System.out.println(running);
		Scanner sc= new Scanner(System.in);
		System.out.println("enter range i.e. min and max value");
		int lbound= sc.nextInt();
		int ubound= sc.nextInt();
		ms.printRange(inp, lbound, ubound);
		

	}

}
