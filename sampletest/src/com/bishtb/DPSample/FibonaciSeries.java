package com.bishtb.DPSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * There are atleast 3 ways we can find a fibonaci number for a function
 * f(n) = return the nth fibonaci number
 * 1. using recursion
 * 2. DP 
 * 			(1) using recursion with memoization
 * 			(2)	Bottom up approach 
 * 
 * f(n) = {  n >= 3    f(n-1) + f(n-2)
 * 			 n = 1 or n =2  return 1
 *
 * @author birendra
 *
 */
public class FibonaciSeries {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-- > 0) {
				int n = Integer.parseInt(br.readLine());
				long startTime = System.nanoTime();
				int result = 0;
				// this wont work when n is higher like 100
				result = recusiveSolution(n);
				long endTime = System.nanoTime();
				System.out.println("Fibonica number is " + result + " "
						+ "and time taken by RecursiveSolution is : "+ 
						(endTime - startTime) + "nanoseconds");
				startTime = System.currentTimeMillis();
				int[] memoizedArr = new int[n+1]; 
				// This wont work with n=100 or 1000
				result = recursionWithMemoization(n, memoizedArr);
				endTime = System.nanoTime();
				System.out.println("Fibonica number is " + result + "recursionWithMemoization took : "+ (endTime - startTime) +"nanoSeconds");
				startTime = System.nanoTime();
				// This one is the perfect and best solution and would work for any input
				result = bottomUp(n);
				endTime = System.nanoTime();
				System.out.println("Fibonica number is " + result + "DP bottom up approach took : "+ (endTime - startTime) +"nanoseconds");
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// Recursion based approach
	public static int recusiveSolution(int n) {
		if ( n==1 || n == 2)
			return 1;
		else
			return recusiveSolution(n-1) + recusiveSolution(n-2);
	}

	// Recursion with memoization
	public static int recursionWithMemoization(int n, int memoizedArr[]) {
		int result = 1;
		if(n==1 || n==2)
			return 1;
		if(memoizedArr[n] != 0)
			return memoizedArr[n];
		else
			result = recursionWithMemoization(n-1, memoizedArr) + recursionWithMemoization(n-1, memoizedArr);
		memoizedArr[n] = result;
		return result;	
	}

	// Bottom up approach
	public static int bottomUp(int n) {
		int[] bottomUp = new int[n+1];
		bottomUp[1] = 1;
		bottomUp[2] = 1;
		for(int i=3;i<=n; i++){
			bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
		}
		return bottomUp[n];
	}
}
