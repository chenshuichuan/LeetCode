package leetcode25;

public class DivideTwoIntegers29 {
    public static void main(String[]args){
        DivideTwoIntegers29 p = new DivideTwoIntegers29();
        System.out.println(p.divide(10,3));
        System.out.println(p.divide(7,-3));
        System.out.println(p.divide(-2147483648,-1));
        System.out.println(p.divide(-2147483648,1));
        System.out.println(p.divide(-2147483648,2));
        System.out.println(p.divide(1100540749,-1090366779));
    }
    public int divide(int dividend, int divisor) {

        if(dividend==0)return 0;
        //都转成负数处理
        int flag =1;
        if(dividend<0&&divisor>0){
            divisor = -divisor;
            flag = -1;
        }
        if(divisor<0&&dividend>0){
            dividend = -dividend;
            flag = -1;
        }
        if(dividend>0 &&divisor>0){
            dividend = -dividend;
            divisor = -divisor;
        }
        int x = btv(dividend,divisor);
        if(x==Integer.MIN_VALUE&&flag==1)
            return Integer.MAX_VALUE;

        return flag*x;
    }
    private int btv(int a, int b){
        if(a>b)return 0;
        int x = 1;
        int tb = b;
        int ta = a;
        while (tb+tb>=ta){
            ta = ta-tb-tb;
            if(ta>0)break;
            tb = tb+tb;
            x= x+x;
        }
        return x+btv(a-tb,b);
    }



    public int divide2(int dividend, int divisor) {

        if(dividend==0)return 0;
        //都转成负数处理
        int flag =1;
        if(dividend<0&&divisor>0){
            divisor = -divisor;
            flag = -1;
        }
        if(divisor<0&&dividend>0){
            dividend = -dividend;
            flag = -1;
        }
        if(dividend>0 &&divisor>0){
            dividend = -dividend;
            divisor = -divisor;
        }
        int x = 0;
        while (dividend<=divisor){
            dividend-=divisor;
            x++;
        }
        if(x==Integer.MIN_VALUE&&flag==1)
            return Integer.MAX_VALUE;

        return flag*x;
    }
}
