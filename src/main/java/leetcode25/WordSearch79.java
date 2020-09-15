package leetcode25;

public class WordSearch79 {
    public static void main(String[] args) {
        WordSearch79 p = new WordSearch79();
        char[][]board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}};
        System.out.println(p.exist(board,"AABCD"));
    }
    private int[][]visited;
    private boolean exist = false;
    public boolean exist(char[][] board, String word) {
        visited = new int[board.length][board[0].length];
        char[] c =  word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    next(board,c,0,i,j);
                    if(exist)return true;
                }
            }
        }
        return false;
    }
    private void next(char[][] board, char[] word,int index,int i,int j){
        if(exist)return;
        if(visited[i][j]==1 ||board[i][j] != word[index])return;
        if(index == word.length-1){
            exist = true;
            return;
        }
        visited[i][j] = 1;
        index ++;
        if(i-1>=0 )next(board,word,index,i-1,j);
        if(i+1<board.length )next(board,word,index,i+1,j);
        if(j-1>=0 )next(board,word,index,i,j-1);
        if(j+1<board[0].length )next(board,word,index,i,j+1);
        visited[i][j] = 0;
    }
}
