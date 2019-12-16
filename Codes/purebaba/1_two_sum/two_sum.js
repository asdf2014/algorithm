// https://leetcode.com/problems/two-sum/

let twoSum = function (nums, target) {
    let map = {};
    for (let i = 0; i < nums.length; i++) {
        let p = target - nums[i];
        let j = map[p];
        if (j !== undefined && j !== i) {
            return [j, i]
        }
        map[nums[i]] = i;
    }
    return []
};
