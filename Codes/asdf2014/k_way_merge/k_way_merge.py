from collections import deque
from heapq import heappop, heappush


def k_way_merge(*args):
    if args is None or len(args) == 0:
        return []

    arr = []
    res = []
    for arg in args:
        if len(arg) == 0:
            continue
        arg = deque(arg)
        heappush(arr, (arg.popleft(), arg))

    while len(arr) > 0:
        index, arg = heappop(arr)
        res.append(index)
        if len(arg) > 0:
            heappush(arr, (arg.popleft(), arg))

    return res


merged = k_way_merge()
assert [] == merged

merged = k_way_merge([])
assert [] == merged

merged = k_way_merge([0, 2, 4])
assert [0, 2, 4] == merged

merged = k_way_merge([], [0, 2, 4])
assert [0, 2, 4] == merged

merged = k_way_merge([0, 2, 4], [1, 3, 5], [2, 3, 4])
assert [0, 1, 2, 2, 3, 3, 4, 4, 5] == merged
