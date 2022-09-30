/**
 * @param {number} length
 */
const SnapshotArray = function (length) {
    this.arr = [];
    for (let i = 0; i < length; i++) {
        this.arr[i] = 0;
    }
    this.shot = {};
    this.snaps = [];
    this.snap_id = 0;
};

/**
 * @param {number} index
 * @param {number} val
 * @return {void}
 */
SnapshotArray.prototype.set = function (index, val) {
    this.arr[index] = val;
    this.shot[index] = val;
};

/**
 * @return {number}
 */
SnapshotArray.prototype.snap = function () {
    this.snaps[this.snap_id] = this.shot;
    this.shot = {};
    return this.snap_id++;
};

/**
 * @param {number} index
 * @param {number} snap_id
 * @return {number}
 */
SnapshotArray.prototype.get = function (index, snap_id) {
    if (snap_id < 0) {
        return 0;
    }
    let val = this.snaps[snap_id][index];
    return val === undefined ? this.get(index, --snap_id) : val;
};

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * var obj = new SnapshotArray(length)
 * obj.set(index,val)
 * var param_2 = obj.snap()
 * var param_3 = obj.get(index,snap_id)
 */

let a = new SnapshotArray(3);
a.set(0, 5);
a.snap();
a.set(0, 6)
console.log(a.get(0, 0))
