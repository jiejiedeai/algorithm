package basic.快排.partition;

/**
 * 题目:给定一个数组arr，和一个数num。请把小于等于num的数放在数组的左边，大于num的数放在数组右边。
 * 要求额外空间复杂度o(1),时间复杂度o(n)。
 * 历数组的过程中，设定一个变量指针，变量指针的初始值是数组第一个值。但是变量指针指向的位置永远是当前遍历数组的前一个位置。
 * 再遍历数组得过程中用数组每一个元素得值跟目标值比较
 * 如果值小于等于目标值那么变量指针就不动。
 * 如果大于等于目标值那么把当前变量指针往下移动一位并且跟当前遍历的数组元素值进行交换
 */
public class Solution {

    public static void main(String[] args) {
        int target = 5;
        int [] arr = new int[]{10,20,40,2,11,4};
        result(arr,target,0);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void result(int [] array,int target,int L){
        if(array==null||array.length<=1){
            return;
        }
        for(int i=0;i<array.length;i++){
            if(array[i]<target){
                swap(array,L++,i);
            }
        }
    }

    public static void swap(int [] arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
