package basic.插入排序;

import java.util.Arrays;

/**
 * 插入排序默认第一个数是排好的
 * 每次都要从当前这个数到第一个数比较是否小小就交换
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{3,6,7,1,10,5};
        method(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void method(int [] array){
        if(array==null||array.length<2){
            return;
        }
        for(int i=1;i<array.length;i++){
            for(int j =i-1;j>=0&&array[j]>array[j+1];j--){
                swap(array,j,j+1);
            }

        }
    }

    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
