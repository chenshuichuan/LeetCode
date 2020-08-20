package leetcode;

public class Minesweeper529 {
    public static void main(String[] args){
        Minesweeper529 minesweeper529 = new Minesweeper529();

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
    public char[][] updateBoard(char[][] board, int[] click) {
        char[][]behind =  getBoardAll( board);
        int x= click[0];
        int y= click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }else if (behind[x][y] != '0'){
            board[x][y]= behind[x][y];
        }
        else{
            board[x][y] = 'B';
            dfs(behind,board,x,y);
        }
        return board;

    }
    public void dfs(char[][] behind,char[][] board,int i,int j){
        if(j-1>=0){
            next(behind,board,i,j-1);
        }
        if(j+1<board[0].length){
            next(behind,board,i,j+1);
        }
        if(i-1>=0 ){
            next(behind,board,i-1,j);
        }
        if(i+1<board.length ){
            next(behind,board,i+1,j);
        }

        if(i-1>=0 && j-1>=0){
            next(behind,board,i-1,j-1);
        }
        if(i-1>=0 && j+1<board[0].length){
            next(behind,board,i-1,j+1);
        }
        if(i+1<board.length && j-1>=0){
            next(behind,board,i+1,j-1);
        }
        if(i+1<board.length && j+1<board[0].length){
            next(behind,board,i+1,j+1);
        }
    }
    private void next(char[][]behind,char[][] board,int i,int j){
        if(board[i][j] == 'B')return;
        if(behind[i][j] !='0')board[i][j] = behind[i][j];
        else{
            board[i][j] = 'B';
            dfs(behind,board,i,j);
        }
    }
    public char[][] getBoardAll(char[][] board) {

        char[][] behind = new char[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                behind[i][j] = '0';
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'M'){
                    behind[i][j] = 'M';
                }
                else if (board[i][j] == 'E'){
                    if(i-1>=0 && j-1>=0){
                        if(board[i-1][j-1]=='M')behind[i][j] +=1;
                    }
                    if(i-1>=0 && j+1<board[0].length){
                        if(board[i-1][j+1]=='M')behind[i][j] +=1;
                    }
                    if(i+1<board.length && j-1>=0){
                        if(board[i+1][j-1]=='M')behind[i][j] +=1;
                    }
                    if(i+1<board.length && j+1<board[0].length){
                        if(board[i+1][j+1]=='M')behind[i][j] +=1;
                    }

                    if(j-1>=0){
                        if(board[i][j-1]=='M')behind[i][j] +=1;
                    }
                    if(j+1<board[0].length){
                        if(board[i][j+1]=='M')behind[i][j] +=1;
                    }
                    if(i-1>=0 ){
                        if(board[i-1][j]=='M')behind[i][j] +=1;
                    }
                    if(i+1<board.length ){
                        if(board[i+1][j]=='M')behind[i][j] +=1;
                    }
                }
                else behind[i][j] = board[i][j];
            }
        }
        return behind;

    }
}
//[
//        ["B","B","B","B","B","B","1","E"],
//        ["B","1","1","1","B","B","1","M"],
//        ["1","2","M","1","B","B","1","1"],
//        ["M","2","1","1","B","B","B","B"],
//        ["1","1","B","B","B","B","B","B"],
//        ["B","B","B","B","B","B","B","B"],
//        ["B","1","2","2","1","B","B","B"],
//        ["B","1","M","M","1","B","B","B"]]
// B,B,B,B,B,B,1,E,
// B,1,1,1,B,B,1,M,
// E,E,M,1,B,B,1,E,
// M,2,1,1,B,B,B,B,
// 1,1,B,B,B,B,B,B,
// B,B,B,B,B,B,B,B,
// B,1,2,2,1,B,B,B,
// B,1,M,M,1,B,B,B,