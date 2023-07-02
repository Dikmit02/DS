 class NthSquareRoot {
     public static void main(String[] args){
        System.out.println(SquareRoot_(8,3));
    } 

    public static String powerCalculate(int mid,int number,int nth_root) {
        int ans=1;
        for(int i=1;i<=nth_root;i++){
            ans=ans*mid;
            if(ans>number){
                return "I am High";
            }
        }
        if(ans==number) return "This is the anwser";
        return "Low";

    }

    public static int SquareRoot_(int number,int nth_root) {
        int low=1;
        int high=number;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(powerCalculate(mid,number,nth_root).equals("This is the anwser")){
                return mid;
            }else if(powerCalculate(mid,number,nth_root).equals("I am High")){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return -1;
    }
}
