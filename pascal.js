function pascal(numRows) {
  var arr = []
  arr[0] = [1]
  for (let i = 1; i < numRows; i++) {
    arr.push(new Array(i + 1))
    for (let j = 0; j <= i; j++) {
      if (j == 0 || j == i) {
        arr[i][j] = 1
        continue
      }
      arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]
    }
  }
  return arr
}

console.log('pascal(6) ', pascal(6))
