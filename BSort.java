import java.util.Random;
import java.util.Scanner;

public class BSort {
	public void bsort(int[] sample, int max) {
	      int [] bucket_pool=new int[max+1];
	     
	 
	      for (int i=0; i<bucket_pool.length; i++) {
	    	  bucket_pool[i]=0;
	      }
	 
	      for (int i=0; i<sample.length; i++) {
	    	  bucket_pool[sample[i]]++;
	      }
	 
	      int op=0;
	      
	      for (int i=0; i<bucket_pool.length; i++) {
	         for (int j=0; j<bucket_pool[i]; j++) {
	            sample[op++]=i;
	         }
	      }
	   }
	int max(int[] sample) {
		int max=0;
		for(int i=0; i<sample.length;i++) {
			if(sample[i]>max) {
				max=sample[i];
			}
			
		}
		return max;
		
	}
	 void printRange(int[] arr, int m, int n ) {
	    	for(int i=m; i<n;i++) {
	    		System.out.println(arr[i]);
	    	}
	    }


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BSort bs= new BSort();
		int[] inp= new int[100000];
		
		Random rd = new Random();
		for(int i=0; i<100000;i++) {
			inp[i]=(rd.nextInt((100000 - 0) + 1) + 0);
		}
		
		long startTime = System.nanoTime();
		int max=bs.max(inp);
		
		bs.bsort(inp,max);
		long stopTime = System.nanoTime();
		long elapsed= stopTime-startTime;
		//System.out.println(elapsed);
		Scanner sc= new Scanner(System.in);
		System.out.println("enter range, min and max value");
		int lbound= sc.nextInt();
		int rbound= sc.nextInt();
		bs.printRange(inp, lbound, rbound);

	}

}
