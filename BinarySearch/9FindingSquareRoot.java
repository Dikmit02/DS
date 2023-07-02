class FindingSquareRoot{

    public static void main(String[] args){
        System.out.println(SquareRoot_(36));
    } 

    public static int SquareRoot_(int target) {
        int low=1;
        int high=target;
        int ans=1; //(min ans can be 1)
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid*mid <=target){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;
    }
}