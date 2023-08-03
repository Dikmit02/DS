function burstBallon(arr) {
  let i = 0,
    n = arr.length
  let count = 0

  while (i < n - 2) {
    let j = i + 1

    while (j < n - 1) {
      let countSofar = 0
      if (arr[i][0] < arr[j][0]) {
        if (arr[i][1] > arr[j][1]) {
          count += countSofar + 1
          j++
          continue
        }

        if (arr[i][1] < arr[j][1]) {
          i++
          count += countSofar + 1
          break
        }
      }
    }
  }

  return count
}

console.log(
  burstBallon([
    [1, 6],
    [2, 8],
    [7, 12],
    [10, 16],
  ]),
)
