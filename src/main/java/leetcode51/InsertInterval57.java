package leetcode51;

public class InsertInterval57 {
    /**
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * */
    public static void main(String[] args)  {
        int[][]intervals = {{2,3},{6,9}};
        int[]newInterval = {0,2};
        InsertInterval57 p = new InsertInterval57();
        int[][]result = p.insert(intervals,newInterval);

        for (int i = 0; i < result.length; i++) {
            System.out.print("{"+result[i][0]+","+result[i][1]+"},");
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //边界
        if(newInterval==null)return intervals;
        if(intervals==null||intervals.length==0){
            intervals= new int[1][2];
            intervals[0][0]=newInterval[0];
            intervals[0][1]= newInterval[1];
            return intervals;
        }
        //开头边界
        if(newInterval[0]<intervals[0][0]){
            //完全插入
            if(newInterval[1]<intervals[0][0]){
                return insert(0,intervals,newInterval);
            }
            //要确定new的尾部

        }
        for (int i = 0; i < intervals.length; i++) {
            //如果new的开始落在i区间的中间
            if(newInterval[0]>=intervals[i][0]&&newInterval[0]<=intervals[i][1]){
                int index= i;
                while (true){
                    //找到第一个大于的区间
                    if(newInterval[1]>intervals[i][1]){
                        i++;
                        if(i>=intervals.length){
                            newInterval[0] = intervals[index][0];
                            return insert(index,i-1,intervals,newInterval);
                        }
                        continue;
                    }
                    //new结束也在某个区间中
                    //index到i这个区间要合并
                    if(newInterval[1]>=intervals[i][0]&&newInterval[1]<=intervals[i][1]){
                        newInterval[0] = intervals[index][0];
                        newInterval[1] = intervals[i][1];
                        return insert(index,i,intervals,newInterval);

                    }else if(newInterval[1]<intervals[i][0]){
                        newInterval[0] = intervals[index][0];
                        return insert(index,i-1,intervals,newInterval);
                    }
                }
            }

            //new的开始落在i区间后面，
            if(newInterval[0]>intervals[i][1]){
                //i已经是最后一个区间，new要插入后面
               if(i==intervals.length-1){
                   return insert(i+1,intervals,newInterval);
               }//i不是最后一个区间
               else{
                   int index= ++i;
                   while (true){
                       //找到第一个大于的区间
                       if(newInterval[1]>intervals[i][1]){
                           i++;
                           if(i>=intervals.length){
                               return insert(index,i-1,intervals,newInterval);
                           }
                           continue;
                       }
                       //new结束也在某个区间中
                       //index到i这个区间要合并
                       if(newInterval[1]>=intervals[i][0]&&newInterval[1]<=intervals[i][1]){
                           newInterval[1] = intervals[i][1];
                           return insert(index,i,intervals,newInterval);
                       }else if(newInterval[1]<intervals[i][0]){
                           if(index==i-1){//new夹在中间，需要插入
                               return insert(i,intervals,newInterval);
                           }
                           //否则合并index到i-1
                           return insert(index,i-1,intervals,newInterval);
                       }
                   }
               }
            }

        }
        return null;
    }
    //仅插入处理
    private int[][] insert(int i,int[][] intervals, int[] newInterval){
        int[][] newIn = new int[intervals.length+1][2];
        for (int j = 0; j < intervals.length+1 ; j++) {
            if(j<i){
                newIn[j][0]=intervals[j][0];
                newIn[j][1]=intervals[j][1];
            }
            else if(j>i){
                newIn[j][0]=intervals[j-1][0];
                newIn[j][1]=intervals[j-1][1];
            }
            else{
                newIn[j][0]=newInterval[0];
                newIn[j][1]=newInterval[1];
            }
        }
        return newIn;
    }
    //index到i这个区间要合并,合并的区间为newInterval
    private int[][] insert(int index,int i,int[][] intervals, int[] newInterval){
        //减少的区间数量
        int num = i-index;
        int[][] newIn = new int[intervals.length-num][2];
        for (int j = 0; j < newIn.length; j++) {
            if(j<index){
                newIn[j][0]=intervals[j][0];
                newIn[j][1]=intervals[j][1];
            }
            else if(j==index){
                newIn[j][0]=newInterval[0];
                newIn[j][1]=newInterval[1];
            }
            else{
                i++;
                newIn[j][0]=intervals[i][0];
                newIn[j][1]=intervals[i][1];
            }
        }
        return newIn;
    }
}
