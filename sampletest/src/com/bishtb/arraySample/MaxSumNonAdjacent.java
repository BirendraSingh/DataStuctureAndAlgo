package com.bishtb.arraySample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumNonAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0){
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int n = arr.length;
				System.out.println("Max sum of non adjacent elements: "+FindMaxSum(arr, n));
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static int FindMaxSum(int arr[], int n) 
    { 
        int incl = arr[0]; 
        int excl = 0; 
        int excl_new;  
  
        for (int i = 1; i < n; i++) 
        { 
            /* current max excluding i */
            excl_new = Math.max(incl , excl); 
  
            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new; 
        } 
  
        /* return max of incl and excl */
        return Math.max(excl,incl); 
    } 
}
