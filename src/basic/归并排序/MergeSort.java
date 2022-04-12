package basic.归并排序;

public class MergeSort {

    public static void mergeSort(int [] arr){
        if(arr==null ||arr.length<2){
            return;
        }
        sortProcess(arr,0,arr.length-1);
    }

    private static void sortProcess(int[] arr, int l, int r) {
        if(l==r){
            return;
        }
        int mid = (l+r)/2;
        sortProcess(arr,l,mid);
        sortProcess(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int [] help = new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=mid+1;
        //l和r分别代表左侧排好序跟右侧排好序的数据，然后判断l和r谁小谁小就把谁放到help数组中并且让小的哪个l或者r进行移动
        //p1和p2代表两个指针一个指向数组左边最左侧的数 一个是指向数组数组右边最左侧数，然后比较谁小，小的放到辅助数组里
        while(p1<=mid&&p2<=r){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        //到了这一步代表p1和p2肯定有一个已经越界了也就是有一边已经全部走完把数据放好了。然后把不越界的剩下数据拷贝到数组中
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        //p1和p2虽然写了两个while但是回顺序执行判断p1月越界还是p2越界。如果是p2越界走p1，p1越界走p2.
        while (p2<=r){
            help[i++]=arr[p2++];
        }
        //辅助数组排好序拷贝到原数组上
        for(i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }
    }
    
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,65,56,8,0,10,100};
        mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
