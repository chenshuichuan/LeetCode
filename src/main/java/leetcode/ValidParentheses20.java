package leetcode;

public class ValidParentheses20 {
    public static void main(String[] args){
        System.out.println(new ValidParentheses20().isValid(""));

    }
    public boolean isValid(String s) {
        //if(s.length()==0)return true;
        int i = 0;
        StringBuilder sBuilder = new StringBuilder();
        while(i<s.length()){

            char curr = s.charAt(i);
            if(curr==')'||curr=='}'||curr==']'){//检查
                if(sBuilder.length()<=0)return false;
                char pre = sBuilder.charAt(sBuilder.length()-1);
                if(getAnother(curr)==pre){
                    sBuilder.deleteCharAt(sBuilder.length()-1);
                }
                else return false;
            }
            else if(curr=='('||curr=='{'||curr=='['){
                sBuilder.append(curr);
            }
            else return false;
            i++;
        }
        if(sBuilder.length()>0)return false;
        return true;
    }
    public char getAnother(char curr){
        switch (curr){
            case ')':return '(';
            case '}':return '{';
            case ']':return '[';
            default:return '0';
        }
    }
}
