package Array;

class MissingNumber {

  public static void main(String[] args) {}

  public static int missingNumber(int[] a, int N) {
    for (int i = 1; i <= N; i++) {
      int flag = 0;

      for (int j = 0; j < N - 1; j++) {
        if (a[j] == i) {
          flag = 1;
          break;
        }
      }

      if (flag == 0) return i;
    }

    return -1;
  }

  public static int missingNumber2(int[] a, int N) {
    int hash[] = new int[N + 1]; //hash array

    // storing the frequencies:
    for (int i = 0; i < N - 1; i++) hash[a[i]]++;

    //checking the freqencies for numbers 1 to N:
    for (int i = 1; i <= N; i++) {
      if (hash[i] == 0) {
        return i;
      }
    }

    // The following line will never execute.
    // It is just to avoid warnings.
    return -1;
  }

  public static int missingNumber3(int[] a, int N) {
    //Summation of first N numbers:
    int sum = (N * (N + 1)) / 2;

    //Summation of all array elements:
    int s2 = 0;
    for (int i = 0; i < N - 1; i++) {
      s2 += a[i];
    }

    int missingNum = sum - s2;
    return missingNum;
  }

  public static int missingNumber4(int[] a, int N) {
    int xor1 = 0, xor2 = 0;

    for (int i = 0; i < N - 1; i++) {
      xor2 = xor2 ^ a[i]; // XOR of array elements
      xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
    }
    xor1 = xor1 ^ N; //XOR up to [1...N]

    return (xor1 ^ xor2); // the missing number
  }
}
