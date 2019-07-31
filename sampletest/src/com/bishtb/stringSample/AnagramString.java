package com.bishtb.stringSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				String s1 = br.readLine();
				String s2 = br.readLine();
				System.out.println(isAnagram(s1, s2) ? "Anagram" : "Not Anagram");
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean isAnagram(String s1, String s2) {
		// if string are not same length, return false
		if(s1.length() != s2.length())
			return false;
		int[] charSet = new int[128]; // ASCII chracter only
		// iterate over any string and fill the corresponding index location for each character.
		for(int i=0; i<s1.length(); i++) {
			int val = s1.charAt(i);
			charSet[val]++;
		}
		
		// iterate over second string and check boolean array.
		for(int i =0; i<s1.length(); i++) {
			int val = s2.charAt(i);
			charSet[val]--;
			if(charSet[val] < 0)
				return false;
		}
		return true;
	}

}
