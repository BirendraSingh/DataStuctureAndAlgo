package sampletest;

import java.util.Scanner;
import java.util.Stack;

public class BracketAndBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = new String[]{"[{(B)}{(B)(B)}]", "[(B]", "{(B)}", "[{B}]"};
		String input = new Scanner(System.in).nextLine();
		switch (input) {
		case "Simple":
			for(String s : str){
				System.out.println(isBalancedDescription(s));
			}
			break;
		case "Complex":
			for(String s: str){
				if (isBalancedDescription(s) == 1) {
					System.out.println(fixDesrciption(s));
				} else {
					System.out.println(s +" is a valid description.");
				}
			}
			
			break;
		default:
			System.out.println("Not a valid mode of operation.");
		}

	}

	/**
	 * @param description
	 * @return int value, indicating it's okay (0) or bad (1).
	 */
	static int isBalancedDescription(String description) {
		if (description == null || description.isEmpty())
			return 1;
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < description.length(); i++) {
			char c = description.charAt(i);
			// if c is a starting parenthesis, push it
			if (c == '(' || c == '{' || c == '[') {
				s.push(c);
			}
			// if closing parenthesis, pop and check for match
			if (c == ')' || c == '}' || c == ']') {
				if (s.isEmpty()) {
					return 1;
				} else if (!isMatchingPair(s.pop(), c)) {
					return 1;
				}
			}
		}
		if (s.isEmpty()) {
			return 0;
		} else {
			return 1;
		}
	}
	/**
	 * @param desc
	 * @return String, fixed desc if possible.
	 * 
	 * Condition:
	 * if only one bracket of type "[" or "]" is missing, it can be fixed
	 * else not possible to fix the description.
	 */
	static String fixDesrciption(String desc) {
		  String result = desc;
	     int count = minParentheses(desc);
	     if(count < 0){
	    	 for(int i=0; i<Math.abs(count); i++){
	    		 result = "[" + result;
	    	 }
	     } else if(count>0){
	    	 for(int i=0; i<count; i++){
	    		 result = result + "]";
	    	 }
	     } else{
	    	 return "Description can not be fixed.";
	     }
		return "After fix description is: "+result;
	}

	private static int minParentheses(String p)  
    {  
        
        // maintain balance of string  
        int bal = 0;  
        int ans = 0;  
        
        for (int i = 0; i < p.length(); ++i) {  
        	if(p.charAt(i) == '['){
        		bal = bal + 1;
        	} else if(p.charAt(i) == ']') {
        		bal = bal -1;
        	} 
            if (bal == -1) {  
                ans += 1;  
                bal += 1;  
            }  
        }  
        return bal + ans;  
    }  

	static boolean isMatchingPair(char ch1, char ch2) {
		if ((ch1 == '(' && ch2 == ')') || (ch1 == '{' && ch2 == '}') || (ch1 == '[' && ch2 == ']'))
			return true;
		else
			return false;
	}

}
