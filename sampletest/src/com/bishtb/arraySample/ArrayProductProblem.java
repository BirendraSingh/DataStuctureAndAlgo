package com.bishtb.arraySample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * A Product Array Puzzle
   Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such 
   that prod[i] is equal to the product of all the elements of arr[] except arr[i]. 
   
   Solve it without division operator and in O(n).
 * @author birendra
 *
 */
public class ArrayProductProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0){
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Arrays.stream(produtArray(arr)).forEach(x -> System.out.print(x+" "));
				System.out.println();
				Arrays.stream(productArrayWithoutDivision(arr)).forEach(x -> System.out.print(x+" "));
				
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Simple solution with O(n) time complexity is using division.
	private static int[] produtArray(int[] arr) {
		int[] result = new int[arr.length];
		int product = 1;
		for(int x:arr){
			product = product*x;
		}
		for(int i=0; i<result.length;i++) {
			result[i] = product/arr[i];
		}
		return result;
	}

	// Solution without using division works to maintain left product as well as right product
	private static int[] productArrayWithoutDivision(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		int temp = 1;
		for(int x : result){
			x=x*temp;
		}
		
		//calculate product for the left array without arr[i] element
		for (int i =0; i<n; i++) {
			result[i] = temp;
			temp *= arr[i];
		}

		//calculate the product on the right of the arr[i]
		temp = 1;
		for(int i=n-1; i>=0; i--) {
			result[i] = result[i] * temp;
			temp *= arr[i];
		}
		return result;
	}
	
}
