package leetcode;

public class RepeatedSubstringPattern459 {
    public static void main(String[] args){
        RepeatedSubstringPattern459 p = new RepeatedSubstringPattern459();

        System.out.println(p.repeatedSubstringPattern("abababab"));
        System.out.println(p.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(p.repeatedSubstringPattern("aba"));
        System.out.println(p.repeatedSubstringPattern("ababab"));
        System.out.println(p.repeatedSubstringPattern("ab"));
        String stre = "abcd";
        //stre.indexOf()
    }
    public boolean repeatedSubstringPattern(String s) {
        int j = s.length();
        if(j<2)return false;

        for (int i = 0; i < j/2; i++) {
            if(j%(i+1)!=0)continue;
            String str = s.substring(0,i+1);
            int k = i+1;
            for (; k < j; ) {
                if (s.substring(k,k+i+1).equals(str))k=k+i+1;
                else break;

            }
            if(k>=j)return true;
        }
        return false;
    }
    public boolean repeatedSubstringPattern1(String s) {
        int j = s.length();
        if(j<2)return false;

        for (int i = 0; i < j/2; i++) {
            StringBuilder stringBuilder = new StringBuilder(s.substring(i+1,j));
            stringBuilder.append(s.substring(0,i+1));
            if(stringBuilder.toString().equals(s))return true;
        }
        return false;
    }
}
