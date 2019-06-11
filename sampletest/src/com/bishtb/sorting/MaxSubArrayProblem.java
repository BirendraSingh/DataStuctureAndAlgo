package com.bishtb.sorting;

public class MaxSubArrayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		int low = 0;
		int high = arr.length;
		int[] result = maxSubArray(arr, low, high);
		System.out.println(" Max profit will be while buying on: "+result[0]
				+ " selling on: "+result[1]+" and max profit: "+result[2]);
	}

	public static int[] maxSubArray(int[] arr, int low, int high){
		if(low == high){
			int[] result = new int[3];
			result[0] = low;
			result[1] = high;
			result[2] = arr[0];
			return result;
		}
		int mid = (high+low)/2;
		int[] leftArr = maxSubArray(arr, low, mid);
		int[] rightArr = maxSubArray(arr, mid+1, high);
		int[] crossOverArr = maxCrossOverSubarray(arr, low, mid, high);
		if(leftArr[2] >= rightArr[2] && leftArr[2] >= crossOverArr[2]){
			return leftArr;
		} else if (rightArr[2] >= leftArr[2] && rightArr[2] >= crossOverArr[2]){
			return rightArr;
		} else{
			return crossOverArr;
		}
	}

	private static int[] maxCrossOverSubarray(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int[] result = new int[3];
		int left_sum = Integer.MIN_VALUE;
		int sum = 0;
		int max_lef_index = 0;
		for(int i = mid; i>=low; i--){
			sum = sum + arr[i];
			if(sum > left_sum){
				left_sum = sum;
				max_lef_index = i;
			}
		}
		result[0] = max_lef_index;
		int right_sum = Integer.MIN_VALUE;
		sum =0;
		int max_right_index = 0;
		for(int i = mid+1; i<high; i++){
			sum = sum + arr[i];
			if(sum > right_sum){
				right_sum = sum;
				max_right_index = i;
			}
		}
		result[1] = max_right_index;
		result[2] = left_sum + right_sum;
		return result;
	}


}