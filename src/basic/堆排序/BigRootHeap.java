package basic.堆排序;

/**
 * 堆排序
 * 大根堆
 */
public class BigRootHeap {

    public static void heapSort(int [] arr){
        if (null == arr || arr.length < 2) {
            return;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);//将数组0-i上转换成一个大根堆的数组，保证二叉树每一个根节点都是当前最大的
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * 将数组转换成大根堆
     * @param arr
     * @param index
     */
    private static void heapInsert(int [] arr,int index) {
        //当前的树比他所在的父节点大时就交换 i-1/2就可以获取当前节点的父节点
        //交换完以后仍然网上找上一个父节点 知道不比父节点大为止
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            //查找更上一层的父节点 知道不必当前父节点大位置
            index = (index-1)/2;
        }
    }

    /**
     * 将小的数沉浸到下边
     * @param arr
     * @param i
     * @param j
     */

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{10,20,11,23,50,40,2,111,4,2,2,2};
        heapSort(arr);
    }
}
