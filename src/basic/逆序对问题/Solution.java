package basic.逆序对问题;

import java.util.Arrays;

/**
 * 逆序对跟小和求解问题一样 小和是左边的数比右边小而逆序对是左边的比右边的大。同样都是使用归并排序来求解
 */
public class Solution {

    public static void reverse(int [] arr){
        if(arr==null || arr.length<2){
            Arrays.asList(arr).forEach(System.out::println);
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(l==r){
            return;
        }
        int mid = l+((r-l) >>1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int [] help = new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=mid+1;
        while (p1<=mid&&p2<=r){
            if(arr[p1]>arr[p2]){
                for(int j=p2;j<=r;j++){
                    System.out.println(arr[p1]+","+arr[j]);
                }
            }
            help[i++]=arr[p1]>arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=r){
            help[i++]=arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }
    }

    public static void main(String[] args) {
        int [] arr = new int[]{11,23,3,4,5,16,7};
        reverse(arr);
    }
}
