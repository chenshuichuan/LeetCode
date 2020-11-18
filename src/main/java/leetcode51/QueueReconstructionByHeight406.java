package leetcode51;

import java.util.Arrays;
import java.util.LinkedList;

public class QueueReconstructionByHeight406 {
    public static void main(String[] args){
        QueueReconstructionByHeight406 p = new QueueReconstructionByHeight406();
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        people = p.reconstructQueue(people);

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i][0]+","+people[i][1]);
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i][0]+","+people[i][1]);
        }
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
//        for(int i = 0;i<list.size();i++){
//            System.out.println(list.get(i)[0]);
//        }
        return list.toArray(new int[list.size()][2]);
    }
    public int[][] reconstructQueue3(int[][] people) {
        //按身高从小到大插入排序
        for (int i = 1; i < people.length; i++) {
            int j = i-1;

            while(j>=0 && people[j][0]>people[j+1][0]){
                swage(people,j,j+1);
                j--;
            }
            //如果身高相同，r大的排前面
            while(j>=0 && people[j][0]==people[j+1][0] &&people[j][1]<people[j+1][1]){
                swage(people,j,j+1);
                j--;
            }
        }
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
    public int[][] reconstructQueue2(int[][] people) {
        //按身高从小到大插入排序
        for (int i = 1; i < people.length; i++) {
            int j = i-1;
            while(j>=0 && people[j][0]>people[j+1][0]){
                swage(people,j,j+1);
                j--;
            }
            //如果身高相同，r大的排前面
            while(j>=0 && people[j][0]==people[j+1][0] &&people[j][1]<people[j+1][1]){
                swage(people,j,j+1);
                j--;
            }
        }
        //按身高从大到小调整
        for (int i = people.length-1; i >=0; i--) {
            int k = people[i][1];
            int j = i+1;
            //根据r大小往高处前进r位
            while (k>0&&j<people.length){
                swage(people,j-1,j);
                k--;
                j++;
            }
        }
        return people;
    }
    private void swage(int[][]people,int i,int j){
        int h = people[i][0];
        int r = people[i][1];
        people[i][0] = people[j][0];
        people[i][1] = people[j][1];
        people[j][0] = h;
        people[j][1] = r;
    }
}
