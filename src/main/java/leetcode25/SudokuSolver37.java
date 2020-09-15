package leetcode25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver37 {
    public static void main(String[] args) {
//        char[][] board = {{'A','B','C'},{'A','B','C'},{'A','B','C'}};
//        char[][] copyB = new char[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            copyB[i] = Arrays.copyOf(board[i],board[i].length);
//        }
//        copyB[0][0] = 'D';
//        System.out.println(copyB[0]);
//        System.out.println(board[0]);
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        SudokuSolver37 p = new SudokuSolver37();
        p.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
        }
    }
    private List<List<Integer>> lists = new ArrayList<>();
    private int[]nums = {1,2,3,4,5,6,7,8,9};
    private boolean isOk = false;
    public void solveSudoku(char[][] board) {
        //以行为基础计算该需要填充的数字
        for (int i = 0; i < board.length; i++) {
            int[]num = Arrays.copyOf(nums,nums.length);
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!='.')num[board[i][j]-'1'] = 0;
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < num.length; j++) {
                if(num[j]!=0)list.add(num[j]);
            }
            lists.add(list);
        }
        dfs(board,0);
    }
    /**
     * 对于每一行，从待填充数字列表list中拿一个数字，找到一个board[i][j]=='.'的有效位置放进去
     * */
    private void dfs(char[][] board,int i){
        List<Integer> list = lists.get(i);
        Integer c = list.remove(list.size()-1);
        char w = (char)('0'+c);
        for (int j = 0; j < board[i].length; j++) {
            if(board[i][j]=='.' && valid(board,w,i,j)){
                board[i][j] = w;
                //该行的待填充数字放完了
                if(list.size() == 0){
                    //如果是最后一行，说明找到了答案
                    if(i == board.length-1){
                        isOk = true;
                        return;
                    }
                    //否则dfs进入下一行
                    dfs(board,i+1);
                }
                //该行没放完待填充数字，还要继续试探
                else dfs(board,i);
                //这里剪枝，如果前面的dfs已经找到答案，就返回了，不再回溯，如果要找多个答案则可以从这里放行
                if(isOk)return;
                board[i][j] = '.';
            }
        }
        list.add(c);
    }
    //检查列方向和3*3范围内是否冲突
    //行范围在dfs前的检查过了
    private boolean valid(char[][] board,char c, int i, int j){
        //列范围
        for (int k = 0; k < 9; k++) {
            if(board[k][j] == c)return false;
        }
        int ix = i/3;
        int jx = j/3;
        //3*3范围
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if(board[ix*3+k][jx*3+l] ==c)return false;
            }
        }
        return true;
    }
}
