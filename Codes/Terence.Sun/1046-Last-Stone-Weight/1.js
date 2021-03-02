/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function(stones) {

    let count = 0;

    const check = (s) => {

        if (count >= s.length - 1) {
            return s;
        }

        let store = [];
        for (let i = 0; i < s.length; i ++) {
            store.push({
                index: i,
                value: s[i],
            });
        }

        store.sort((a, b) => {
            return b.value - a.value;
        });

        let tmp = s[store[0].index] - s[store[1].index];


        if (tmp === 0) {
            s[store[0].index] = -1;
            s[store[1].index] = -1;
            count += 2;
        } else {
            s[store[0].index] = s[store[0].index] - s[store[1].index];
            s[store[1].index] = -1;
            count ++;
        }

        return check(s);
    }

    let ret = check(stones);

    let tmp = [];

    for (let item of ret) {
        if (item !== -1) {
            tmp.push(item);
        }
    }

    if (tmp.length === 0) {
        return 0;
    } else {
        return tmp[0];
    }
};
