package com.bishtb.arrayListSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1 's
 * digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list. EXAMPLE Input: (7-> 1 -> 6) + (5 -> 9
 * -> 2).That is,617 + 295. Output: 2 -> 1 -> 9. That is, 912. FOLLOW UP Suppose
 * the digits are stored in forward order. Repeat the above problem. Input: (6
 * -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. Output: 9 -> 1 -> 2. That is,
 * 912.
 * 
 * @author birendra
 *
 */
public class SumLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str1 = br.readLine();
				String str2 = br.readLine();
				// check if both are null then result is 0
				if (str1 == null || str2 == null)
					System.out.println("0");
				// if first number is greater than second one, pad zero in the
				// beginning of second
				if (str1.length() > str2.length()) {
					int padding = str1.length() - str2.length();
					str2 = padZeros(str2, padding);
				} else if (str2.length() > str1.length()) { // pad first one, if
															// second number is
															// greater
					int padding = str2.length() - str1.length();
					str1 = padZeros(str1, padding);
				}
				// create linked list, while traversing given number in reverse
				// order to make sure
				// head is pointing to last digit of the number.

				List<Integer> l1 = new ArrayList<>();
				List<Integer> l2 = new ArrayList<>();
				for (int i = str1.length(); i > 0; i--) {
					l1.add(Integer.parseInt(str1.substring(i - 1, i)));
					l2.add(Integer.parseInt(str2.substring(i - 1, i)));
				}
				// call add on both the list
				List<Integer> result = addList(l1, l2);
				for (int x : result) {
					System.out.print(x);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static List<Integer> addList(List<Integer> l1, List<Integer> l2) {
		// TODO Auto-generated method stub
		int carry = 0;
		int sum = 0;
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < l1.size(); i++) {
			int val = carry + l1.get(i) + l2.get(i);
			carry = val / 10;
			sum = val % 10;
			result.add(sum);
		}
		Collections.reverse(result);
		return result;
	}

	private static String padZeros(String str, int padding) {
		// TODO Auto-generated method stub
		StringBuilder sbr = new StringBuilder();
		for (int i = 0; i < padding; i++) {
			sbr.append("0");
		}
		return sbr.append(str).toString();
	}

}
