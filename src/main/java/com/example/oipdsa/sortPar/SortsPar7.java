package com.example.oipdsa.sortPar;

import java.util.Arrays;

public class SortsPar7 {

    public static void radixSort(int []a,int n){
        if (n<=1)return;
        int max = a[0];
        for (int i=0;i<n;i++){
            if (max<a[i])max = a[i];
        }

        for (int exp =1;max/exp>0;exp*=10){
            countSort(a,exp);
        }


    }

    private static void countSort(int[] a, int exp) {
        int c[] = new int[10];
        for (int i=0;i<a.length;i++){
            c[(a[i]/exp)%10]++;
        }

        for (int i=1;i<c.length;i++){
            c[i]+=c[i-1];
        }

        int r [] = new int[a.length];
        for (int i=a.length-1;i>=0;--i){
            int index = c[(a[i]/exp)%10]-1;
            r[index] = a[i];
            c[(a[i]/exp)%10]--;
        }

        for (int i=0;i<a.length;i++){
            a[i] = r[i];
        }

    }


    public static void main(String[] args) {
        int [] array = new int []{6,5,7,2,3,3,2,3,2,1,1,6,5,7,2,3,6,5,7,2,3,6,5,7,2,3,2,1,1,};
        radixSort(array,array.length);

        System.out.println(Arrays.toString(array));
    }
}
