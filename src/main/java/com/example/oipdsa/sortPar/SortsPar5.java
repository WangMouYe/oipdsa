package com.example.oipdsa.sortPar;

import java.util.Arrays;

public class SortsPar5 {

    private static void countingSort(int a[],int n){
        if (n<=1)return;
        int max = a[0];
        for (int i=0;i<n;i++){
            if(max<a[i])max = a[i];
        }

        int c [] = new int[max+1];

        for (int i=0;i<=max;i++){
            c[i] = 0;
        }

        for (int i=0;i<n;i++){
            c[a[i]]++;
        }

        for(int i=1;i<=max;i++){
            c[i] +=c[i-1];
        }

        int []r = new int [n];
        for (int i=n-1;i>=0;--i){
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        for (int i=0;i<n;i++){
            a[i] = r[i];
        }



    }





    public static void main(String[] args) {
        int [] array = new int []{3,2,3,2,1,1,6,5,7};
        countingSort(array,array.length);

        System.out.println(Arrays.toString(array));
     }

}
