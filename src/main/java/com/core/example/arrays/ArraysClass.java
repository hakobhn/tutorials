package com.core.example.arrays;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysClass {

	public static void main(String[] args) {
		int arr[] = {4, 6, 5, 8, 3, 9, 7, 3, 2, 8};
		
		System.out.println("Arrays: " + Arrays.toString(arr));
		
/*		Arrays.sort(arr, 0, 5);
		System.out.println("Half Sorted Arrays: " + Arrays.toString(arr));
		
		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, 1);
		System.out.println("Position of 9 in sorted com.core.example.arrays is: " + index);
		
		int[] copyArr = Arrays.copyOf(arr, arr.length);
		System.out.println("Copies com.core.example.arrays: " + Arrays.toString(copyArr));
		
		Arrays.fill(arr, 0, 3, 5);
		System.out.println("Arrays filled with 5 from 0 to 3: "+ Arrays.toString(arr));*/
		
		List<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println("As a List() :" + al);
	}
}
