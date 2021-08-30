package com.ajay.springbootjpademo.controllers;

public class StringPalindrome {

	public static void main(String[] args) {

		//System.out.println(isPalindrome("yaja"));

		System.out.println(reverse("ajay"));

	}

	private static String reverse(String name) {
		int len = name.length()-1;
		
		StringBuffer sb= new StringBuffer();
		
		for(int i=len;i>=0;i--) {
			sb.append(name.charAt(i));
			System.out.println(sb.toString());
		}
		
	return sb.toString();
		
	}

	private static boolean isPalindrome(String name) {
		int mid = name.length() / 2;
		int len = name.length() - 1;

		for (int i = 0; i < mid; i++) {
			if (name.charAt(i) != name.charAt(len - i)) {
				return false;
			}

		}
		return true;

	}

}
