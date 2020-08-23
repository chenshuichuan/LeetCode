package leetcode;

public class ReverseInteger7 {
    public static void main(String[] args){
        ReverseInteger7 p = new ReverseInteger7();

        System.out.println(p.reverse(2143847412));
    }
    public int reverse(int x) {
        int y = 0;
        int flag = 1;
        if(x<0){
            flag = -1;
            x=x*flag;
        }
        while (x>0){
            if((y*10)/10 != y)return 0;
            y = y*10 +(x%10);
            x = x/10;
        }
        return y*flag;
    }
    public int reverse2(int x) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(x));
        if(stringBuilder.charAt(0) =='-'){
            stringBuilder.deleteCharAt(0);
            stringBuilder.reverse();
            stringBuilder.insert(0,'-');
        }
        else stringBuilder.reverse();
        try{
            return Integer.parseInt(stringBuilder.toString());
        }catch (Exception e){

        }
        return 0;
    }
}
