package leetcode51;

public class PowxN50 {
    public static void main(String[] args){
        PowxN50  p = new PowxN50();
        System.out.println(p.myPow(2.000,-2));
    }
    public double myPow(double x, int n) {
        if(n>=0)return pow(x,n);
        else{
            n=-n;
            double p = pow(x,n);
            return 1.0000/p;
        }
    }
    public double pow(double x, int n){
        if(n==0)return 1;
        if(n==1)return x;
        if(n==2)return x*x;
        double result = pow(x,n/2);
        if(n%2==0)return result*result;
        else return result*result*x;
    }
}
