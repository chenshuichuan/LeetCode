package leetcode61;

public class Candy135 {
    public static void main(String[] args) {
        //13,12,11,6,6
        int[][]ratingss= { {1,2,87,87,87,2,1},{29,51,87,87,72,12},{1,3,4,5,2},{1,2,3},{3,2,1,2}};
        Candy135 p = new Candy135();
        for (int[]ratings:ratingss) {
            System.out.println(p.candy(ratings));
        }
    }
    /**
     * 一次遍历，记录升序和降序的长度
     * 开始节点算作升序，算完降序长度之后，如果升序比降序短如：124321，顶点要算作降序那边的
     * */
    public int candy(int[] ratings){
        int inc=1;
        int dec=0;
        boolean isInc = true;
        int sum = 1;
        for (int i = 1; i <ratings.length; i++) {
            if(ratings[i-1]<=ratings[i]){
                if(isInc){
                    if(ratings[i-1]<ratings[i])inc++;
                    sum+=inc;
                }//下一个升序开始
                else {
                    if(inc<dec){
                        sum+=dec-inc+1;
                    }
                    inc = 1;
                    dec = 0;
                    isInc=true;
                }
            }
            else{
                isInc = false;
                dec++;
                sum+=dec;
            }
        }
        if(inc<dec){
            sum+=dec-inc+1;
        }
        return sum;
    }
    /**
     * 这要算出每个位置的糖果数量
     * 标记低谷---> 每次从低谷边缘扩散增加1个---> 直至填充完毕
     * */
    public int candy2(int[] ratings) {
        if(ratings.length<2)return ratings.length;

        int[] candys = new int[ratings.length];
        int n = ratings.length-1;
        //标记低谷
        if(ratings[0]<=ratings[1])candys[0]=1;
        if(ratings[n]<=ratings[n-1])candys[n]=1;
        for (int i = 1; i < n; i++) {
            if(ratings[i]<=ratings[i-1] && ratings[i]<=ratings[i+1])candys[i]=1;
            //如2,2,2三值相等，中间的位置给1
            //if(ratings[i]==ratings[i-1] && ratings[i]==ratings[i+1])candys[i]=1;
        }
        //从a=1开始扩散，每回合从某一个数扩散加一 a++
        int a = 1;
        //处理边缘
        //if(candys[0]==a && candys[1]==0)candys[1]=a+1;
        //if(candys[n]==a && candys[n-1]==0)candys[n-1]=a+1;
        while(true){
            boolean flag = true;
            for (int i = 0; i < ratings.length; i++) {
                if(candys[i]==a){
                    if(i>0&&ratings[i-1]>ratings[i]){
                        flag = false;
                        candys[i-1]=a+1;
                    }
                    if(i<n && ratings[i+1]>ratings[i]){
                        flag = false;
                        candys[i+1]=a+1;
                    }
                }
                if(candys[i]==0)flag = false;
            }
            //该回合没有扩散，说明填充完毕
            if(flag)break;
            a++;
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum+=candys[i];
            //System.out.print(candys[i]+",");
        }
        //System.out.println();
        return sum;
    }
}
