package com.bishtb.arraySample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * @author birendra
 *
 */
public class ArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int k = Integer.parseInt(br.readLine());
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				System.out.println(ispairExistWithGivenSum(arr, k));
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean ispairExistWithGivenSum(int[] arr, int k) {
		// first create a set and add array element to the set to avoid duplicate
		Set<Integer> set = new HashSet<Integer>();
		for(int x : arr) {
			if(set.contains(x))
				return true;
			set.add(k-x);
		}
		return false;
	}
}
