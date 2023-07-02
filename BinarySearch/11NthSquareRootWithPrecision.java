 class NthSquareRootWithPrecision {
     public static void main(String[] args){
        System.out.println(SquareRoot_(3,2));
    } 

    public static String powerCalculate(double mid,int number,int nth_root) {
        double ans=1.0;
        for(int i=1;i<=nth_root;i++){
            ans=ans*mid;
            if(ans>number){
            return "I am High";
            }
        }
        if(ans==number) return "This is the anwser";
        return "Low";

    }

    public static double SquareRoot_(int number,int nth_root) {
        double low=1;
        double high=number;
        double eps=1e-6;
        while((high-low)>eps){
            double mid=low+(high-low)/2.0;
            String nn=powerCalculate(mid,number,nth_root);
            if(nn.equals("I am High")){
                high=mid;
            }else{
                low=mid;
            }
        }

        return low;
    }
}
