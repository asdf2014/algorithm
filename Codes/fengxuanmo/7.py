def reverse(x):
    x= x if x > 0 else x*-1
    x = long(str(x)[::-1])
    return 0 if x > (2 ** 31 - 1) or x < -2 ** 31 else x

if __name__ == '__main__':
    assert reverse(-923) == --329
