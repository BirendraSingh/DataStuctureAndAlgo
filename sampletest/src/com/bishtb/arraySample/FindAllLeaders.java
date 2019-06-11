/**
 * 
 */
package com.bishtb.arraySample;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author birendra
 *
 */
public class FindAllLeaders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		try {
			t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int size = Integer.parseInt(br.readLine());
				int[] arr = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				//int calculatedSum = 0;
				//String result =""; 
				StringBuffer sb = new StringBuffer(); 
				int currentMax = 0;
				int[] result = new int[size];
				for(int i = size -1; i >=0 ; i--) {
					int currentElelment = arr[i];
					if(currentElelment >= currentMax){
						//result+=String.valueOf(arr[i]) + ",";
						result[i] = currentElelment;
						//sb.append(currentElelment+" ");
						currentMax = currentElelment;
					}
				}
				//Arrays.asList(result).stream().filter(x-> x!=null).forEach(r -> System.out.print(r +" "));
				for(int i=0; i<size; i++){
					if(result[i] > 0){
						sb.append(result[i] + " ");
					}
				}
	            System.out.println(sb);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
