function nextPermtation(array) {
  let i = array.length - 2
  let firstSwapVariable = 0
  while (i >= 1) {
    if (array[array.length - 1] > array[i - 1]) {
      let temp = array[array.length - 1]
      array[array.length - 1] = array[i - 1]
      array[i - 1] = temp
      firstSwapVariable = i
      break
    }

    i--
  }

  let j = array.length - 2
  while (j > firstSwapVariable) {
    if (array[array.length - 1] < array[j - 1]) {
      j--
      continue
    }
    let temp = array[array.length - 1]
    array[array.length - 1] = array[j - 1]
    array[j - 1] = temp
  }

  return array
}

const array = [3, 1, 4, 5]
console.log(array)
console.log(nextPermtation(array))
