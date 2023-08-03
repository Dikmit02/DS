package Array;

class findMaxConsecutiveOnes {

  public static void main(String[] args) {
    int nums[] = { 1, 1, 0, 1, 1, 1 };
    int ans = findMaxConsecutiveOnes_(nums);
    System.out.println("The maximum  consecutive 1's are " + ans);
  }

  static int findMaxConsecutiveOnes_(int nums[]) {
    int maxCount = 0;
    int currentCount = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        currentCount += 1;
        maxCount = Math.max(maxCount, currentCount);
      } else {
        currentCount = 0;
      }
    }
    return maxCount;
  }
}
