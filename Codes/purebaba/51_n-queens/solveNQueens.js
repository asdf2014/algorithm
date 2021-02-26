// 时间复杂度O(n!)
// 参考题解
// 使用回朔法找到所有的解

let solveNQueens = function (n) {
    let res = [];
    backtrack(res, [], n, 0)
    return res
};

let backtrack = function (res, l = [], n, r, columns = [], d1 = [], d2 = []) {
    if (r === n) {
        if (l.length === n) {
            res.push(buildResult(l))
        }
        return;
    }
    for (let i = 0; i < n; i++) {
        if (columns.includes(i)) {
            continue;
        }
        if (d1.includes(r + i)) {
            continue;
        }
        if (d2.includes(r - i)) {
            continue
        }
        let line = [].concat(l);
        let _columns = [].concat(columns);
        let _d1 = [].concat(d1);
        let _d2 = [].concat(d2);


        line[r] = i;
        _columns.push(i);
        _d1.push(r + i);
        _d2.push(r - i);
        backtrack(res, line, n, r + 1, _columns, _d1, _d2)
    }
}

let buildResult = function (arr) {
    let n = arr.length;
    let res = [];
    for (let i = 0; i < n; i++) {
        let index = arr[i];
        let lineStr = ''
        for (let j = 0; j < n; j++) {
            if (index === j) {
                lineStr += 'Q';
            } else {
                lineStr += '.';
            }
        }
        res.push(lineStr)
    }
    return res;
}


// result: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
console.log(solveNQueens(4))
