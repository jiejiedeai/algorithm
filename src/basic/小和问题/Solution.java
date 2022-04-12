package basic.小和问题;

/**
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的累加起来，叫做这个数组的小和。求一个数组的小和。
 */
public class Solution {

    public static int smallSum(int [] arr){
        if(arr==null || arr.length<2){
            return 0;
        }
        return mergeSort(arr,0,arr.length-1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if(l==r){
            return 0;
        }
        //此种写法跟(l+r)/2一样。但是l+r可能回造成溢出，而这种不会。防止溢出的写法l+(r-l)/2 然后除以2这种又可以变成a向右移动1位
        int mid = l+((r-l)>>1);
        int leftResult = mergeSort(arr,l,mid);
        int rightResult = mergeSort(arr,mid+1,r);
        return leftResult+rightResult+merge(arr,l,mid,r);

    }

    private static int merge(int [] arr, int l, int mid, int r) {
        int [] help = new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=mid+1;
        //起始此处跟归并排序完全一样只不过多了一个求解
        int res=0;
        //p1和p2代表两个指针一个指向数组左边最左侧的数 一个是指向数组数组右边最左侧数，然后比较谁小，小的放到辅助数组里。然后计算结果
        while (p1<=mid && p2<=r){
            //此处如果左边的数比右边的数小那么一定也比右边所有结果集都小因为拆分完以后的数组右边都是排好序的
            res = arr[p1]<arr[p2]?(r-p2+1)*arr[p1]:0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        //走到此处代表p2完全走完
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        //走到此处代表p1完全走完 把p2全部拷贝到辅助数组 跟p1只可能有一个到达此处
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        //辅助数组排好序拷贝到原数组上
        for(i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,65,56,8,0,10,100};
        int res = smallSum(arr);
        System.out.println(res);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
