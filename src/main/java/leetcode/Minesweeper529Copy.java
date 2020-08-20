package leetcode;

public class Minesweeper529Copy {
    public static void main(String[] args){
        Minesweeper529Copy minesweeper529 = new Minesweeper529Copy();

        char[][]board = new char[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'E';
            }
        }
        board[1][7] = 'M';
        board[2][2] = 'M';
        board[3][0] = 'M';
        board[7][2] = 'M';
        board[7][3] = 'M';
        minesweeper529.printBoard(board);
        int i = 10;
        System.out.println(i);

        int[] click = {0,0};
        //char[][] boardAll = minesweeper529.getBoardAll(board);
        //minesweeper529.printBoard(boardAll);
        char[][]result = minesweeper529.updateBoard(board,click);
        minesweeper529.printBoard(board);
        i = 10;
        System.out.println(i);

    }
    public void printBoard(char[][]board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+",");
            }
            System.out.println();
        }
    }
    private int[][] dis = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {

        int x= click[0];
        int y= click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }
        else{
            dfs(board,x,y);
        }
        return board;

    }
    //点击的是'E'/'M'才能继续往下计算
    public void dfs(char[][] board,int i,int j){
        if('E'!=board[i][j] && 'M'!=board[i][j])return;
        int sum =0;
        for (int[] xy:dis){
            if(next(board,i+xy[0],j+xy[1])==1)sum+=1;
        }
        if(sum==0) {
            board[i][j]='B';
            for (int[] xy:dis){
                if(next(board,i+xy[0],j+xy[1])==0)dfs(board,i+xy[0],j+xy[1]);
            }
        }
        else board[i][j]=(char)('0'+sum);
    }
    private int next(char[][] board,int i,int j){
        if(j>=0 && j<board[0].length && i>=0 && i< board.length){
            if(board[i][j] == 'M')return 1;
            else return 0;
        }
        return 2;
    }
}
