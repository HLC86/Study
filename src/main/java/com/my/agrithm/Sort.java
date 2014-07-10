package com.my.agrithm;

import com.my.interfac.interface1;

public class Sort {

	public void bubbleSort(int[] arr) {
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index])
					index = j;
			}
			if (i != index) {
				int tmp = arr[i];
				arr[i] = arr[index];
				arr[index] = tmp;
			}
		}
	}

	// without tmp variable.
	public void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j - 1] > arr[j]) {
					arr[j - 1] = arr[j - 1] + arr[j];
					arr[j] = arr[j - 1] - arr[j];
					arr[j - 1] = arr[j - 1] - arr[j];
				}
			}
		}
	}

	public void shellSort(int[] a) {
		int n = a.length;
		for (int gap = 0; gap < n; gap++) {
			for (int i = gap; i < n; i++) {
				int tmp = a[i];
				int j = i;
				for (; j >= gap && a[j - gap] > tmp; j -= gap) {
					a[j] = a[j - gap];
				}
				a[j] = tmp;
			}
		}
	}

	// be worthy of the name?
	public void insertionSort2(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int tmp = arr[i];
			int j = i;
			for (; j > 0 && arr[j - 1] > tmp; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = tmp;
		}
	}

	public void quickSort(int[] arr, int l, int r) {
		if (r > l) {
			int p = partition(arr, l, r);
			quickSort(arr, l, p);
			quickSort(arr, p + 1, r);
		}
	}

	private int partition(int[] arr, int l, int r) {
		int pivotIndex = (l + r) / 2;
		int pivotValue = arr[pivotIndex];
		int index = l;

		swap(arr, r, pivotIndex);

		for (int i = l; i < r; i++) {
			if (arr[i] < pivotValue) {
				swap(arr, i, index++);
			}
		}

		swap(arr, r, index);

		return index;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

    private void merge(int[] arr, int p, int q, int r){
        int l1=q-p+1;
        int l2=r-q;
        int[] arrL = new int[l1+1];
        int[] arrR = new int[l2+1];
        arrL[l1]=99;
        arrR[l2]=99;
        for(int m =0;m<l1;m++){
            arrL[m]=arr[p+m];
        }
        for(int m=1;m<=l2;m++){
            arrR[m-1]=arr[q+m];
        }
        int i=0;
        int j=0;
        for(int k=p;k<=r;k++){
            if(arrL[i]<arrR[j]){
                arr[k]=arrL[i];
                i++;
            }
            else {
                arr[k]=arrR[j];
                j++;
            }
        }
    }

    public void  mergeSort(int[] arr, int p, int r){
        if(p<r){
            int q = (p+r)/2;
            mergeSort(arr,p, q);
            mergeSort(arr,q+1,r);
            merge(arr,p,q,r);
        }
    }
}
