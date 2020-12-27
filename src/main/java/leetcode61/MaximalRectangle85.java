package leetcode61;

public class MaximalRectangle85 {
    public static void main(String[] args) {
        MaximalRectangle85 p = new MaximalRectangle85();

        char[][] matrix ={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        System.out.println(p.maximalRectangle(matrix));

    }
    //查找最大矩形的面积
    //以每个ij为起点，flagi、flagj分别记录长宽是否还能扩张，每次扩张一格，遍历是否有效
    public int maximalRectangle(char[][] matrix){
        int length = matrix.length;
        int wide = matrix[0].length;
        int max = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < wide; j++) {
                if(matrix[i][j]=='1'){
                    //以i,j为顶点开始扩张

                }
            }
        }

        return max;
    }
    //以ij开头的最大面积
    private int maxIj(char[][] matrix){
        boolean flagi=true,flagj = true;

        while(flagi){
            while (flagj){

            }
        }
        return 0;
    }


    //int[i][j][k][l] 代表以ij开始以kl结束的矩形面积，无法成形则为0
    //int[i][j][k][l] 成形需要int[i][j][k-1][l-1]、int[i][l][k-1][l]、int[k][j][k][l-1] 同时成形
    //这个循环有问题：正在算以[i][j]开头的点 但是 int[i][l]开头的还没开始算。。。。
    public int maximalRectangle2(char[][] matrix) {
        int length = matrix.length;
        int wide = matrix[0].length;
        boolean[][][][] mal = new boolean[length][wide][length][wide];
        mal[0][0][0][0] = matrix[0][0]=='1';
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < wide; j++) {
                for (int k = 0; k < length; k++) {
                    if(k<i)continue;
                    boolean k1 = true,l1 = true, k1l1 = true;
                    for (int l = 0; l < wide; l++) {
                        if(l<j)continue;
                        if(matrix[k][l]=='1'){
                           // System.out.println("("+i+","+j+"),("+k+","+l+")="+mal[i][j][k][l]);
                            if(k>i){
                                if(mal[i][l][k-1][l])k1=true;
                                else k1 = false;
                            }
                            if(l>j){
                                if(mal[k][j][k][l-1])l1=true;
                                else l1= false;
                            }
                            if(k>i &&l>j){
                                if(mal[i][j][k-1][l-1])k1l1=true;
                                else k1l1 = false;
                            }

                            if(k1&&l1&&k1l1){
                                mal[i][j][k][l] =true;
                                int mul = (k-i+1)*(l-j+1);
                                max = mul>max?mul:max;
                            }
                            else mal[i][j][k][l] = false;
                        }
                        else mal[i][j][k][l] = false;
                    }
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < wide; j++) {
                for (int k = 0; k < length; k++) {
                    if(k<i)continue;
                    for (int l = 0; l < wide; l++) {
                        if(l<j)continue;
                        System.out.println("("+i+","+j+"),("+k+","+l+")="+mal[i][j][k][l]);
                    }
                }
            }
        }
        return max;
    }

}
