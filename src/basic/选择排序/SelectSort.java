package basic.选择排序;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 排序时候找到一个最小的放到前边。依次类推
 */
public class SelectSort {

    public static void main(String[] args) {
        int size=10;
        int value=100;
        int times=500000;
        boolean succeed=true;
        for(int i=0;i<times;i++){
            int[] randomArray = getRandomArray(size,value);
            int[] arr1 = copyArray(randomArray);
            int[] arr2 = copyArray(randomArray);
            selectSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                succeed=false;
                println(randomArray);
                break;
            }
        }
        System.out.println(succeed?"Nice":"Fucking Fucked");
    }

    private static void println(int[] array) {
        String result = Arrays.asList(array).stream().map(data -> String.valueOf(data)).collect(Collectors.joining(","));
        System.out.println("错误的数组是:"+result);
    }

    private static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static void selectSort(int [] array){
        if(array==null||array.length<2){
            return;
        }
        for(int i=0;i<array.length;i++){
            int minIndex=i;
            for(int j =i+1;j<array.length;j++){
                minIndex = array[j]<array[minIndex]?j:minIndex;
            }
            swap(array,i,minIndex);
        }
    }

    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    /**
     * 生成一个随机数组 长度和值不会超过给定的长度和值
     * @param size
     * @param value
     * @return
     */
    public static int[] getRandomArray(int size,int value){
        int [] arr = new int[(int)((size+1)*Math.random())];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)((value+1)*Math.random())-(int)(value*Math.random());
        }
        return arr;
    }

    /**
     * 复制数组
     * @param array
     * @return
     */
    public static int[] copyArray(int [] array){
        if(array ==null){
            return null;
        }
        int [] res=new int[array.length];
        for(int i=0;i<array.length;i++){
            res[i]=array[i];
        }
        return res;
    }

    /**
     * 验证两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[]arr1,int[]arr2){
        if((arr1==null&&arr2!=null)||(arr1!=null && arr2==null)){
            return false;
        }
        if(arr1==null&&arr2==null){
            return true;
        }
        if(arr1.length!=arr2.length){
            return false;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }


}
