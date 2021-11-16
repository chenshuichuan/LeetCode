package leetcode71;

import java.util.Arrays;

public class BoatsToSavePople881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int low = 0;
        int hight = people.length-1;
        while(low<hight){
            if(people[low]+people[hight] <=limit){
                low++;
                hight--;
            }else hight--;
            count++;
        }
        if(low == hight)count++;
        return count;
    }
}
