// 个人原始思路
// 第一次循环将每一位的结果存到数组中
// 第二次循环构造ListNode
let addTwoNumbers = function (l1, l2) {
    let count = 0;
    let cache = [];
    let flag = 0;
    while (l1 || l2 || flag) {
        let sum = (l1 && l1.val || 0);
        sum += (l2 && l2.val || 0);
        sum += flag;
        flag = Math.floor(sum / 10);
        cache[count] = sum % 10;
        count++;
        l1 = l1 && l1.next;
        l2 = l2 && l2.next;
    }
    let res = {};
    res.val = cache[0] || 0;
    let other = res;
    for (let i = 1; i < cache.length; i++) {
        let tmp = {val: cache[i]};
        other.next = tmp;
        other = tmp;
    }
    return res;
};


// 参考后的优化思路
// 构造一个前置节点，循环的同时将每一位的接天构造出来
let addTwoNumbers_1 = function (l1, l2) {
    let flag = 0;
    let pre = {val: 0};
    let cur = pre;
    while (l1 || l2 || flag) {
        let sum = (l1 && l1.val || 0);
        sum += (l2 && l2.val || 0);
        sum += flag;
        flag = Math.floor(sum / 10);
        cur.next = {val: sum % 10};
        cur = cur.next;
        l1 = l1 && l1.next;
        l2 = l2 && l2.next;
    }
    return pre.next;
};


let l1 = {val: 5};
let l2 = {val: 5};

console.log(JSON.stringify(addTwoNumbers(l1, l2)));
