package com.my.agrithm.xbw;

import java.util.Arrays;

public class Sort {
	
	public static void isort2(int[] a){
		int t;
		for(int i = 1 ; i < a.length; i ++)
			for(int j = i; j > 0 ; j--)
				if(a[j] < a[j -1]){
					t = a[j]; a[j] = a[j -1]; a[j - 1] = t; 
				}else
					break;
	
	}
	
	public static void qsort(int[] a, int low, int high){
		if ( low >= high) return ;
		int pivot = partition(a, low , high);
		qsort(a, low, pivot);
		qsort(a, pivot + 1, high);
	}
	
	public static int partition(int[] a, int low, int high){
		
		int p1 = low + 1,p2 = low, temp = a[low];
		while(p1 < high){
			if (a[p1] < temp) { a[p2] = a[p1]; a[p1] = a[++p2];}
			p1++;
		}
		a[p2] = temp;
		return p2;
		
	}

	public static void msort(int[]a ,int[] b, int low, int high){
		if (low > high - 1) return ;
		int mid = low + (high - low) >> 1;
		msort( a ,b , low, mid);
		msort( a ,b , mid + 1 , high);
		int p1= low, p2 = mid + 1;
		for ( int i = 0; i < high - low + 1; i++)
			if (p1 < mid + 1 && p2 < high + 1) 
				if(a[p1] < a[p2] ) b[i] = a[p1++];
					else b[i] = a[p2++];
			else if ( p1 < mid + 1) b[i] = a[p1++];
			else b[i] = a[p2++];
		for( int i = 0; i < high - low + 1; i ++)
			a[i] = b[i];
	}
	public static void merge(){
		
	}

	public static void main(String[] args) {

		int[] arr = { 3, 2, 1, 4, 1, 1, 2, 5, 6 };
		int[] b = { 3, 2, 1, 4, 1, 1, 2, 5, 6 };

//		insertionSort(arr);
	//	qsort(arr, 0 , arr.length - 1 );
		qsort( arr, 0, arr.length );
		System.out.println(Arrays.toString(arr));
	}

}
