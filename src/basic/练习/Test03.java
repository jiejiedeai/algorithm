package basic.练习;

/**
 * 分区问题
 * 荷兰国旗
 * 快速排序
 */
public class Test03 {

    public static void main(String[] args) {
        int [] arr = new int[]{3,50,31,22,3,60,1,55,13};
        int target = 21;
//        partition(arr,0,target);
        solution(arr,0,arr.length-1,target);
        print(arr);
    }

    private static void solution(int [] arr,int L,int R,int target){
        int less = L-1;
        int more = R+1;
        while (L< more){
            if(arr[L]<target){
                swap(arr,++less,L++);
            }else if(arr[L]>target){
                swap(arr,--more,L);
            }else{
                L++;
            }
        }
    }

    private static void partition(int [] arr,int L,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<target){
                swap(arr,L++,i);
            }
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
