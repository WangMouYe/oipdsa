package com.example.oipdsa.sortPar;

import com.example.oipdsa.sort.TrueSorts;

public class SortsPar3 {

    public int bs(int []a,int n,int value){
        if (n<=1)return -1;
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high -low)>>1);
            if (a[mid]==value)return mid;
            else if (a[mid] < value) low = mid + 1;
            else high = mid-1;
        }
        return -1;
    }

    public int bSearch(int []a,int n,int value){
        return bSearchInternally(a,0,n-1,value);
    }

    private int bSearchInternally(int[] a, int low, int high, int value) {
        if (low > high)return -1;
        int mid = low + ((high-low)>>1);
        if (a[mid]==value)return mid;
        else if (a[mid]<value)return bSearchInternally(a,mid+1,high,value);
        else return bSearchInternally(a,low,mid-1,value);
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        TrueSorts.bubbleSort(array,array.length);
        SortsPar3 b = new SortsPar3();
//        int res = b.bs(array,array.length,8);
        int res = b.bSearch(array,array.length,8);
        System.out.println(res);


    }

}
