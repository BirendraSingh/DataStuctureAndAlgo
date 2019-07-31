package com.bishtb.stringSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
	cannot use additional data structures?
 * @author Birendra
 *
 */
public class UniqueString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String str = br.readLine();
				System.out.println(isUnique(str) ? "Unique" : "not Unique");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * We can create a boolean array and update the index for each character visited
	 * if we found the index has value, we can simply return false
	 * @param str
	 * @return
	 */
	private static boolean isUnique(String str) {
		// base case, if length is greater than unique character set in ASCII
		if(str.length() > 128)
			return false;
		// boolean array with size as 128 to hold the 128 character
		boolean[] char_set = new boolean[128];
		// iterate over string
		for(int i =0; i<str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}
}
