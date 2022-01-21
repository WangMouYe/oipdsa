package com.example.oipdsa.sortPar;

import java.util.Arrays;

public class SortsPar2 {

    //kp
    public static void quickSort(int []a,int n){
        if (n<=1) return;
        quickSortInternally(a,0,n-1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p>=r)return;
        int q = partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j=p;j<r;++j){
            if (a[j]<pivot){
                if (i==j){
                    ++i;
                }else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

    //gb
    private static void mergeSort(int []a,int n){
        if (n<=1)return;
        mergeSortInternally(a,0,n-1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p>=r)return;
        int q = p + ((r-p)>>1);
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
        merge(a,p,q,r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0;
        int []tmp = new int[r-p+1];

        while (i<=q && j<=r){
            if (a[i]<=a[j]){
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }

        int start = i;
        int end = q;
        if (j<=r){
            start = j;
            end = r;
        }

        while (start<=end){
            tmp[k++] = a[start++];
        }

        for (i=0;i<=r-p;++i){
            a[p+i] = tmp[i];
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
//        quickSort(array, array.length);
//        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));


    }
}
