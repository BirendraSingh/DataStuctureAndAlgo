package com.bishtb.stringSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of
	a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
	permutation is a rearrangement of letters. The palindrome does not need to be limited to just
	dictionary words.
	EXAMPLE
	Input: Tact Coa
	Output: True (permutations: "taco cat'; "atc o eta·; etc.)
*/
public class PermutationOfPalindrom {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t-->0) {
				String str = br.readLine();
				System.out.println(isPermuaionPalindrome(str) ? "String permutation is palindrome" : "No Plaindrome is possible");
				System.out.println(isPalindromeOptimized(str) ? "String permutation is palindrome" : "No Plaindrome is possible");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/*
	 * solution 1:
	 * Build a character frequency array and check it should not have more than one odd occurrence of a character.
	 */

	private static boolean isPermuaionPalindrome(String str) {
		int[] charFrequencyTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		char[] charArray = str.toCharArray();
		for(char c: charArray) {
			if(getCharaNumber(c) != -1)
				charFrequencyTable[getCharaNumber(c)]++;
		}

		// Now lets iterate over this frequency table and see for not more than one odd
		boolean isOddFound = false;
		for(int x: charFrequencyTable) {
			if(x % 2 ==1 ) {
				if(isOddFound)
					return false;
				isOddFound = true;
			}
		}
		return true;
	}

	/*
	 * Solution 2:
	 * We can check the odd count while iterating over the string itself so no need to generate frequency array
	 * Space complexity would be O(1) where as time complexity would still be O(N)
	 */

	private static boolean isPalindromeOptimized(String str) {
		char[] charset = str.toCharArray();
		int countOdd = 0;
		for(char c: charset) {
			int x = getCharaNumber(c);
			if(x != -1)
				charset[x]++;
			if(charset[x] % 2 == 1) {
				countOdd++;
			} else {
				countOdd--;
			}
		}
		return countOdd<=1;
	}
	
	// helper method to derive the character numeric value within given range of a - z
	private static int getCharaNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z)
			return val - a;
		return -1;
		
	}
	
}
