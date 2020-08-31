package leetcode11;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited= new int[rooms.size()];
        Stack<Integer> keys = new Stack<Integer>();
        keys.push(new Integer(0));
        while (!keys.empty()){
            int i = keys.pop();
            if(visited[i] == 0){
                List<Integer> roomKeys = rooms.get(i);
                for (Integer key:roomKeys) {
                    keys.push(key);
                }
                visited[i] = 1;
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if(visited[i] == 0)return false;
        }
        return true;
    }
}
