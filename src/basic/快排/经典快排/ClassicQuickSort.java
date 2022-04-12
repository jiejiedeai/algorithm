package basic.快排.经典快排;

/**
 * 1.	经典快排原理是找到数组最后一个数，然后判断比他大的放到数组的左边，比它小的放到数组的右边
 * 2.	执行完这个以后然后接着对左边区域重复执行上边过程。数组右边的区域也执行上边的过程
 * 3.	递归的进行下去直到最后一个过程执行完完成排序
 */
public class ClassicQuickSort {

    public static void quickSort(int [] arr){
         if(arr==null || arr.length<=1){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int [] arr,int L,int R){
        if(L<R){
            int [] p= partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    public static int[] partition(int [] arr,int L, int R){
        int less= L-1;
        int more = R;
        while (L<more){
            if(arr[L]<arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                swap(arr,--more,L);
            }else {
                L++;
            }
        }
        swap(arr,more,R);
        //返回等于区域L-R的下标
        return new int[]{less+1,more};
    }

    public static void swap(int[]arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{10,20,11,23,50,40,2,111,4,11,2,2,2};
        quickSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
