/**
 * 
 */
package com.bishtb.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author birendra
 *
 */
public class InsertionSortSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Please enter array length: ");
		int n = sc.nextInt();
		System.out.println("Please enter the array element: ");
		int[] arr = new int[n];
		for (int i=0; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Array elements given as: ");
		printArray(arr);
		System.out.println("\n After insertion sort: ");
		//printArray(insertionSort(arr, n));
		printArray(nonIncreasingInsertionSort(arr, n));*/
		
		
		int[] a = {1,0,1};
		int[] b = {1,0,1};
		System.out.println("\n after addition: ");
		printArray(addBinaryIntegers(a, b));
	}

	public static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(e->System.out.print(e+"\t"));
	}

	public static int[] insertionSort(int[] arr, int n){
		for(int i = 1; i<n; i++){
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
		return arr;
	}

	// non-increasing sort
	public static int[] nonIncreasingInsertionSort(int[] arr, int n){
		for (int i = 1; i<n; i++){
			int key = arr[i];
			int j = i -1;
			while( j >=0 && arr[j] < key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
		return arr;
	}

	// adding two n-bit binary integers
	public static int[] addBinaryIntegers(int[] a, int[] b){
		int[] c = new int [a.length + 1];
		int carry = 0;
		int i = 0;
		for(; i<a.length; i++){
			int sum = a[i] + b[i] + carry;
			c[i] = sum%2;
			carry = sum/2;
		}
		c[i] = carry;
		return c;
	}
}
