package basic.快排.荷兰国旗;

/**
 * 给定一个数组arr，和一个数num。请把小于等于num的数放在数组的左边，大于num的数放在数组右边，等于目标值的放在中间。要求额外空间复杂度o(1),时间复杂度o(n)。
 * 1.	同上边的patition分区问题一样，只不过在基础上增加了一个等于的区域放在中间
 * 2.	我们要用2个变量实现这个事儿分别是最小于域的指针、最大区域的在最右边.
 * 3.	如果小于current和小于区域的下一个数交换，交换完以后小于区域和当前区域都++。
 * 4.	如果是大于current和大于区域的前一个数交换，交换完以后大于区域—当前区域++
 * 5.	最终当前区域和大于、小于的指针变量值相等时候退出
 * 6.	我们左边区域和右边区域在代码演示时候可以用L和R不一定是数组最左侧和最右侧开始，可以设计方法时候让用户传递一个范围进来这样功能更好扩展
 */
public class Solution {

    public static void main(String[] args) {
        int target = 11;
        int [] arr = new int[]{10,20,11,23,50,40,2,111,4,11};
        result(arr, target, 0, arr.length - 1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static int [] result(int [] array,int num,int L,int R){
        int less=L-1;
        int more = R+1;
        while (L < more) {
            if(array[L]<num){
                swap(array,++less,L++);
            }else if(array[L]>num){
                swap(array,--more,L);
            }else{
                L++;
            }
        }
        return new int[]{less+1,more-1};
    }

    public static void swap(int[]arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
