package basic.练习;

/**
 * 归并排序
 * 小和
 */
public class Test02 {

    public static void main(String[] args) {
        int [] arr = new int[]{3,50,31,22,3,60,1,55};
//        recursiveSort(arr,0,arr.length-1);
        int sum = smallSum(arr,0,arr.length-1);
        System.out.println(sum);
        print(arr);
    }

    /**
     * 递归排序
     * @param arr
     * @param L
     * @param R
     */
    public static void recursiveSort(int [] arr,int L,int R){
        if(L==R){
            return;
        }
        int mid = L+((R-L)>>1);
        recursiveSort(arr,L,mid);
        recursiveSort(arr,mid+1,R);
        recursiveMerge(arr,L,mid,R);
    }

    public static int smallSum(int [] arr,int L,int R){
        if(L==R){
            return arr[L];
        }
        int mid = L+((R-L)>>1);
        return smallSum(arr,L,mid)+smallSum(arr,mid+1,R)+smallSumMerge(arr,L,mid,R);
    }

    private static int smallSumMerge(int[] arr, int L, int mid, int R) {
        int [] help = new int[R-L+1];
        int i =0;
        int sum =0;
        int p1=L;
        int p2=mid+1;
        while (p1<=mid && p2<=R){
            sum = arr[p1]<arr[p2]?(R-p2+1)*arr[p1]:0;
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1 <=mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for(i = 0;i<help.length;i++){
            arr[L+i] = help[i];
        }
        return sum;
    }


    public static void recursiveMerge(int [] arr, int L, int mid, int R){
        int [] help = new int[R-L+1];
        int p1 = L;
        int p2 = mid+1;
        int i=0;
        while (p1<=mid&&p2<=R){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++]=arr[p1++];
        }
        while(p2<=R){
            help[i++]=arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
    }

    private static void print(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
