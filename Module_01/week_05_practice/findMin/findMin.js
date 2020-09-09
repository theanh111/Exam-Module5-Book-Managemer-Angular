let arr = [-1, 4, 5, 2, -19, -7];

function findMinValue(arr) {
    let nums = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            nums.push(arr[i]);
        }
    }
    let max = nums[0];
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > max) {
            // let temp;
            // temp = nums[i];
            // nums[i] = max;
            // max = temp;

            max = nums[i];
        }
    }
    return max;
}

findMinValue(arr);
document.write(findMinValue(arr));