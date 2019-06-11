package sampletest;

import java.util.ArrayList;
import java.util.List;
//import static java.lang.Math.abs;
//import static java.lang.*;
//import static java.lang.Math.*;

class A{
	static String str = "abc";
	void overload(){
		System.out.println("I am in a");
	}
}
class B extends A {

	static String str = "def";
	void overload(){
		System.out.println("I m in B");
	}

}

public class SampleMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Object> myList = new ArrayList<String>();
		A b = new B();
		b.overload();

	}
}
