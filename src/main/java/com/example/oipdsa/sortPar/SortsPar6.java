package com.example.oipdsa.sortPar;

import java.util.Arrays;

public class SortsPar6 {

    public static void bucketSort(int []arr,int bucketSize){
        if (arr.length<2)return;
        int minIndex = arr[0];
        int maxIndex = arr[1];

        for (int i=0;i<arr.length;i++){
            if (minIndex>arr[i]) minIndex = arr[i];
            else if (maxIndex<arr[i]) maxIndex = arr[i];
        }

        int bucketCount = (maxIndex-minIndex)/bucketSize+1;
        int [][]buckets = new int[bucketCount][bucketSize];
        int [] indexArr = new int [bucketCount];

        for (int i=0;i<arr.length;i++){
            int bucketIndex = (arr[i]-minIndex)/bucketSize;
            if (indexArr[bucketIndex]==buckets[bucketIndex].length){
                ensurecapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        int k = 0;
        for (int i=0;i<buckets.length;i++){
            if (indexArr[i]==0)continue;
            quickSortC(buckets[i],0,indexArr[i]-1);
            for (int j=0;j<indexArr[i];j++){
                arr[k++] = buckets[i][j];
            }
        }

    }

    private static void quickSortC(int[] a, int p, int r) {
        if (p>=r)return;
        int q = partition(a,p,r);
        quickSortC(a,p,q-1);
        quickSortC(a,q+1,r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j=p;j<r;j++){
            if (a[j]<=pivot){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,r);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        if (i==j)return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void ensurecapacity(int[][] buckets, int bucketIndex) {
        int [] tempArr = buckets[bucketIndex];
        int [] newArr = new int [tempArr.length*2];

        for (int j=0;j<tempArr.length;j++){
            newArr[j] = tempArr[j];
        }

        buckets[bucketIndex] = newArr;

    }


    public static void main(String[] args) {
        int [] array = new int []{6,5,7,2,3,3,2,3,2,1,1,6,5,7,2,3,6,5,7,2,3,6,5,7,2,3,2,1,1,};
        bucketSort(array,array.length);

        System.out.println(Arrays.toString(array));
    }

}
