package sort;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals435 {

    public static void main(String[] args) {
        //1,2,0
        int[][][] lists = {
                { {1,2}, {2,3}, {3,4}, {1,3} },
                { {1,2}, {1,2}, {1,2} },
                { {1,2}, {2,3} },
                { {1,5}, {2,3}, {3,4}, {1,4},{7,7}, {8,9},{1,3}, {2,6} }};

        NonOverlappingIntervals435 p = new NonOverlappingIntervals435();

        for (int[][] list :lists) {
            System.out.println(p.eraseOverlapIntervals(list));
        }
    }
    //给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)return 0;
        //intervals = shellSort(intervals);
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });
        //保留的区域数
        int res = 1;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=right){
                res++;
                right = intervals[i][1];
            }
        }
        //返回去除的区域数
        return intervals.length-res;
    }

    //希尔排序//还缺一层  为什么呢
    public int[][] shellSort(int[][] intervals){
        for (int gap = intervals.length/2;gap>0; gap/=2){
            for (int i = gap; i < intervals.length; i++) {
                if(intervals[i][1]<intervals[i-gap][1]){
                    int[] temp = {intervals[i][0],intervals[i][1]};
                    intervals[i][0]= intervals[i-gap][0];
                    intervals[i][1]= intervals[i-gap][1];
                    intervals[i-gap][1] = temp[1];
                    intervals[i-gap][0] = temp[0];
                }
            }
        }
        return intervals;
    }
}
