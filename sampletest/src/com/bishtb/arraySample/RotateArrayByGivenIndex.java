package com.bishtb.arraySample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
  Input:
		The first line of the input contains T denoting the number of testcases. 
		First line of each test case contains two space separated elements, 
		N denoting the size of the array and an integer D denoting the number size of the rotation. 
		Subsequent line will be the N space separated array elements.
 */
public class RotateArrayByGivenIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-- > 0) {
				int[] arr1 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				int[] arr = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				int[] resultArr = new int[arr.length];
				int i = 0;
				int j = arr1[1];
				for(; j<arr.length; j++){
						resultArr[i] = arr[j];
						i++;
				}
				for(int k=0; k<arr1[1]; k++){
					resultArr[i] = arr[k];
					i++;
				}
				Arrays.stream(resultArr).forEach(result -> System.out.print(result+" "));
				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
