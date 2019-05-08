def solution(n):
    if n <= 1:
        return n
    a = 0
    b = 1
    while n > 1:
        n = n - 1
        sum_ = a + b
        a = b
        b = sum_
    return b


assert solution(6) == 8
