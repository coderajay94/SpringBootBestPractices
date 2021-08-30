package com.ajay.springbootjpademo.service;

public class MissingNumber {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 3, 5, 2, 4, 6, 8 };
		System.out.println(findMissingNumber(8, arr));

	}

	private static int findMissingNumber(int n, int[] arr) {

		int totalSum = (n * (n + 1)) / 2;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}

		return totalSum - sum;

	}

}
