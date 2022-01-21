package com.example.oipdsa.sortPar;

import java.util.Arrays;

public class SortsPar1 {

    //mp
    public static void mp(int []a,int n){
        if (n<=1)return;
        for (int i=0;i<n;++i){
            boolean flag = false;
            for (int j=0;j<n-i-1;++j){
                if (a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag)break;
        }
    }




    //cr
    public static void cr(int []a,int n){
        if (n<=1)return;
        for (int i=1;i<n;++i){
            int value = a[i];
            int j = i-1;
            for (;j>=0;--j){
                if (a[j]>value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }






    //xz
    public static void xz(int []a,int n){
        if (n<=1)return;
        for (int i=0;i<n-1;++i){
            int minIndex = i;
            for (int j=i+1;j<n;++j){
                if (a[j]<a[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }




    public static void mp1(int[]a,int n){
        if (n<=1)return;
        for (int i=0;i<n;i++){
            boolean flag = false;
            for (int j=0;j<n-i-1;j++){
                if (a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag)break;
        }
    }

    public static void mp2(int [] a,int n){
        if (n<=1)return;
        int lastExchange = 0;
        int sortBorder = n-1;
        for (int i=0;i<n;i++){
            boolean flag = false;
            for (int j=0;j<sortBorder;j++){
                if (a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag)break;
        }
    }



    public static void cr1(int []a,int n){
        if (n<=1)return;
        for (int i=1;i<n;i++){
            int value = a[i];
            int j = i-1;
            for (;j>=0;j--){
                if (a[j]>value)a[j+1] = a[j];
                else break;
            }
            a[j+1] = value;
        }
    }

    public static void xz1(int []a,int n){
        if (n<=1)return;
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for (int j=i+1;j<n;j++){
                if (a[j]<a[minIndex])minIndex = j;
            }
            int tmp  = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }



    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
//        mp(array, array.length);
//        mp1(array, array.length);
//        cr1(array, array.length);
        xz1(array, array.length);
        System.out.println(Arrays.toString(array));


    }










}










