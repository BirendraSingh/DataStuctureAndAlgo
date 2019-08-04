package com.bishtb.DPSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecodeMessage {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int  t= Integer.parseInt(br.readLine());
			while(t-->0) {
				String data = br.readLine();
				System.out.println(countDecodeMessage(data));
				System.out.println(countDecodeMessageWithMemo(data));
				
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static int countDecodeMessage(String data) {
		return countDecodeRecursively(data, data.length());
	}

	private static int countDecodeMessageWithMemo(String data){
		return countDecodeMessageWithDP(data, data.length(), new int[data.length()+1]);
	}
	private static int countDecodeRecursively(String data, int length) {
		// Base case
		if (length == 0)
			return 1;
		if (Integer.valueOf(data.substring(0, 1)) == 0)
			return 0;
		// number of decode message can be formed
		int result = countDecodeRecursively(data, length - 1);
		if (length >= 2 && Integer.valueOf(data.substring(0, 2)) <= 26) {
			result += countDecodeRecursively(data, length - 2);
		}
		return result;
	}

	private static int countDecodeMessageWithDP(String data, int length, int[]memo) {
		// Base case
		if(length == 0)
			return 1;
		if (Integer.valueOf(data.substring(0, 1)) == 0)
			return 0;
		if(0 != memo[length])
			return memo[length];
		// number of decode message can be formed
		int result = countDecodeMessageWithDP(data, length-1, memo);
		if (length >= 2 && Integer.valueOf(data.substring(0, 2)) <= 26) {
			result += countDecodeMessageWithDP(data, length - 2, memo);
		}
		memo[length] = result;
		return result;
	}
}
