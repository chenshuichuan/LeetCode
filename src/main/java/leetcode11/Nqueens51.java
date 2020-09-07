package leetcode11;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * a[] a[i]=0表示第i行上还没有皇后；
 * b[] b[i]=0表示第i列反斜线/上没有皇后；
 * c[] c[i]=0表示第i列正斜线\上没有皇后。
 * */
public class Nqueens51 {


    public static void main(String[] args){
        StringBuilder builder= new StringBuilder("......");;
        StringBuilder temp = new StringBuilder(builder).replace(2,3,"Q");
        System.out.println(temp.toString());

        for (int i = 1; i < 10; i++) {
            Nqueens51 p = new Nqueens51();
            List<List<String>> lists = p.solveNQueens(i);
            for (List<String> strings:lists) {
                for (String  str: strings) {
                    System.out.println(str);
                }
                System.out.println("----------------------------");
            }
        }
    }

    private int[]board;
    private int[] a ;
    private int[]b;
    private int[]c;
    private StringBuilder builder= new StringBuilder();;
    List<List<String>> lists= new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        a= new int[n];
        b= new int[2*n];
        c = new int[2*n];
        board = new int[n];
        for (int i = 0; i < n; i++) {
            builder.append('.');
        }
        dfs(0,n);
        return lists;
    }

    private void dfs(int t,int n) {
        if (t == n) {//说明已经排了n行了（从0开始的），即排列结束了
            List<String> str = new ArrayList<String>();
            for (int i = 0; i<n; i++) {
                int j = board[i];
                StringBuilder temp = new StringBuilder(builder).replace(j,j+1,"Q");
                str.add(temp.toString());
            }
            lists.add(str);
            return;
        }
        //看放哪一列
        for (int i = 0; i<n; i++) {
            //有冲突
            if (a[i] == 1||b[i - t + n] == 1||c[i + t] == 1) continue;

            //没有冲突
            a[i] = 1;
            b[i - t + n] = 1;
            c[i + t] = 1;
            board[t] = i;
            dfs(t + 1,n);//深搜递归

            board[t] = 0;
            //后退处理
            c[i + t] = 0;
            b[i - t + n] = 0;
            a[i] = 0;
        }
    }
}
