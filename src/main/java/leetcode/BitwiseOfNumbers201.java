package leetcode;

public class BitwiseOfNumbers201 {
    public static void main(String[] args){
        BitwiseOfNumbers201 p = new BitwiseOfNumbers201();

        System.out.println();
        int m =1;
        int n =8;
        for (int i = m; i <= n; i++) {
            System.out.println(toBinary(i,8));
        }

        System.out.println(p.rangeBitwiseAnd(100,102));
    }
    public static String toBinary(int num, int digits) {
        int value = 1 << digits | num;
        String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
        return  bs.substring(1);
    }

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}
