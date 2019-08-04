package com.bishtb.DPSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find number of sub array which have total sum equivakent to a given number.
 * 
 * This problem can be demonstrated with a recrusive problem of smaller problem.
 * Key here is to check for each element
 *   1) no of sub array without this element are equivalent to given sum
 *   2) no of sub array with this element are having sum equal to given number
 * @author birendra
 *
 */
public class FindTotalSubArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		try {
			t = Integer.parseInt(br.readLine());
			while(t-- > 0) {
				int total = Integer.parseInt(br.readLine());
				int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				System.out.println("Total number of subarray with given sum are: " + totolSets(arr, total));
				System.out.println("Total number of subarray with given sum are: " + totalSetsWithMemoization(arr, total));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static int totolSets(int[] arr, int total) {
		int n = arr.length;
		// starting from the end of the array
		return recursiveTotalSet(arr, total, n-1);
	}

	public static int totalSetsWithMemoization(int [] arr, int total) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		return recrusiveWithMemoization(arr, total, arr.length-1,map);
	}
	// Recursively check pair starting from end of the array element.
	public static int recursiveTotalSet(int[] arr, int total, int i) {
		if (total == 0)
			return 1;
		else if(total < 0 )
				return 0;
		else if(i <0 )
			return 0;
		
		// if total is less than the ith element 
		else if(total < arr[i])
			return recursiveTotalSet(arr, total, i-1);
		else
			return recursiveTotalSet(arr, total - arr[i], i-1) +
					recursiveTotalSet(arr, total, i-1);
	}

	// using DP with bottom memoization
	public static int recrusiveWithMemoization(int[] arr, int total, int i, Map<String, Integer> map) {
		int result = 0;
		String key = String.valueOf(total+"_"+i);
		if(map.get(key) != null){
			return map.get(key);
		}
		if (total == 0)
			return 1;
		else if(total < 0 )
				return 0;
		else if(i <0 )
			return 0;
		else if(total < arr[i]){
			result = recrusiveWithMemoization(arr, total, i-1, map);
		}
		else{
			result = recrusiveWithMemoization(arr, total-arr[i], i-1, map) + 
					recrusiveWithMemoization(arr, total, i-1, map);
		}
		map.put(key, result);		
		return result;
	}
	
}
