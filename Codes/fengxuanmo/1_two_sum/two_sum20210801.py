#! coding:utf-8
def two_sum(l, target):
    if l is None:
        return False
    else:
        m = {}
        for i, j in enumerate(l):
            if j in m:
                return [m[j], i]
            else:
                m[target - j] = i


if __name__ == "__main__":
    print(two_sum([1, 2, 3, 3, 4, 4, 4, 9], 10))
