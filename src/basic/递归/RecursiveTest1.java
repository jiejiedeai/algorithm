package basic.递归;

/**
 * 一个数组中取最大数用递归的方式来实现
 * 递归可以用master公式来计算复杂程度T(N)=a*T(N/d)+o(n^d)
 */
public class RecursiveTest1 {

    public static int getMax(int[]array,int l,int r){
        if(l==r){
            return array[l];
        }
        int mid = (l+r)/2;
        int maxLeft = getMax(array,l,mid);
        int maxRight = getMax(array,mid+1,r);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,50,8,9,10};
        System.out.println(getMax(array,0,array.length-1));
    }
}
