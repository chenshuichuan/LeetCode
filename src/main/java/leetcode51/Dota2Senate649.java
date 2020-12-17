package leetcode51;

public class Dota2Senate649 {
    public static void main(String[] args){
        Dota2Senate649  p = new Dota2Senate649();
        System.out.println(p.predictPartyVictory("RDD"));
    }
    public String predictPartyVictory(String senate) {
        int r = 0;
        int d = 0;
        while(true){

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < senate.length(); i++) {
                char c = senate.charAt(i);
                if(c=='R'){
                    if(d>0)d--;
                    else {
                        str.append(c);
                        r++;
                    }
                }
                else {
                    if(r>0)r--;
                    else  {
                        str.append(c);
                        d++;
                    }
                }
            }
            if(str.length()==senate.length()){
                return str.charAt(0)=='R'?"Radiant":"Dire";
            }
            senate = str.toString();
        }
    }
}
