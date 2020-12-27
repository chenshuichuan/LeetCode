package sort;

import java.util.Arrays;

public class AssignCookies455 {
    public static void main(String[] args) {
        int[]g = {1,2,5,8,3,7}, s = {1,2,3};
        AssignCookies455 p = new AssignCookies455();

        System.out.println(p.findContentChildren(g,s));
    }

    //分发饼干：s是饼干大小g是最小胃口
    //g和s排序之后，按照最小适合原则优先分配，双指针遍历g和s
    public int findContentChildren(int[] g, int[] s) {
//        g = bubbleSort(g);
//        s = bubbleSort(s);
//        Arrays.sort(g);
//        Arrays.sort(s);
        g = quickSort(g,0,g.length-1);
        s = quickSort(s,0,s.length-1);
        int gi = 0;
        int si = 0;
        int count = 0;
        while(gi<g.length && si<s.length){
            if(s[si] >= g[gi]){
                count++;
                gi++;
            }
            si++;
        }

        return count;
    }

    //计数排序
    public int[]countSort(int[]array){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(min>array[i])min = array[i];
            if(max<array[i])max = array[i];
        }
        return array;
    }

    //冒泡排序
    public int[] bubbleSort(int[] array){

        boolean isChange = true;
        int index = array.length-1;
        int temp = 0;//临时变量，用于交换两个数
        while (isChange){
            isChange = false;
            for (int i = 0; i < index; i++) {
                if(array[i]>array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    isChange = true;
                }
            }
            index--;
        }
        return array;
    }

    //快速排序：以left为基准，递归地将比基准小的放left，大的放right
    public int[] quickSort(int[] array,int left, int right){
        if(left<right){
            int pivote  = partition(array,left,right);
            quickSort(array,left,pivote-1);
            quickSort(array,pivote+1,right);
        }
        return array;
    }
    //比基准小的放arr的left，要返回基准值的下标
    private int partition(int[]arr, int left, int right){
        int temp = 0;
        int pivot = left;
        int index = pivot+1;
        for (int i = index; i <= right; i++) {
            if(arr[i]<arr[pivot]){
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        //到此位置index处比pivot处的值大，所以最后要交换index-1
        //或是说当前index-1处一定比pivot小
        temp = arr[pivot];
        arr[pivot] = arr[index-1];
        arr[index-1] = temp;
        return index-1;
    }
}
