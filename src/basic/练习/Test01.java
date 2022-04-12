package basic.练习;

/**
 * 冒泡排序
 * 插入排序
 * 选择排序
 */
public class Test01 {

    public static void main(String[] args) {
        int [] arr = new int[]{3,50,31,22,3,60,1,55};
//        bubbleSort(arr);
//        insertSort(arr);
        selectSort(arr);
        print(arr);
    }

    /**
     * 冒泡排序每次都是在0-n范围之间排序出来一个数，然后再次循环排序0-n-1。
     * 直到最后一个数字排序出来方法接触
     * @param arr
     */
    public static void bubbleSort(int [] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    /**
     * 插入排序默认第一个元素是排序好的每次都跟这个比较然后排序
     * @param arr
     */
    public static void insertSort(int [] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j>0;j--){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    /**
     * 选择排序每次到0-n最小的一个数放到数组最左边 然后0-n-1、0-n-2
     * 依次类推直到最后一个数整体都排序好
     * @param arr
     */
    public static void selectSort(int [] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                minIndex=arr[j]<arr[minIndex]?j:minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void print(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
