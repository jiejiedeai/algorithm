package basic.快排.随机排序;


public class RandomQuickSort {

    private static void quickSort(int[] arr) {
        if(arr==null || arr.length<=1){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if(L < R){
            //再L-R上随机获取一个数并且把这个数交换到最后
            swap(arr,L+(int)(Math.random()*(R-L+1)),R);
            int [] p = partition(arr,L,R);
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
        int [] arr = new int[]{10,20,11,23,50,40,2,111,4,2,2,2};
        quickSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
