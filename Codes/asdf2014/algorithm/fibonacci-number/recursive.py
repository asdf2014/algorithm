def solution(n):
    if n <= 1:
        return n
    else:
        return solution(n - 1) + solution(n - 2)


assert solution(6) == 8
