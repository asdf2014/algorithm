def log_str(s):
    num=0
    for i,j in enumerate(s):
        m={}
        k=0
        for i1,j1 in enumerate(s[i:]):
            if j1 not in m:
                m[j1]=1
                k+=1
                if k>num:
                    num=k
            else:
                break
    return num




if __name__ == '__main__':
    print log_str('abcabcbb')