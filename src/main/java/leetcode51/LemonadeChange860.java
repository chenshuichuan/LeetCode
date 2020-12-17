package leetcode51;

public class LemonadeChange860 {
    public static void main(String[]args){
        LemonadeChange860 p = new LemonadeChange860();

        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};

        System.out.println(p.lemonadeChange(bills));
    }
    public boolean lemonadeChange(int[] bills) {
        int[] ch = {0,0,0};

        for (int i = 0; i < bills.length; i++) {
            //收钱
            ch[bills[i]/10]++;
            //找钱
            if(!change(ch,bills[i]-5)){
              return false;
            }
        }
        return true;
    }
    private boolean change(int[]ch,int money){
        if(money==15){
            if(ch[1]>0&&ch[0]>0){
                ch[1]--;
                ch[0]--;
            }
            else if(ch[0]>=3)ch[0]-=3;
            else return false;
        }
        if(money==10){
            if(ch[1]>0){
                ch[1]--;
            }else if(ch[0]>=2){
                ch[0]-=2;
            }else return false;
        }
        if(money==5){
            if(ch[0]>0)ch[0]--;
            else return false;
        }
        return true;
    }
}
