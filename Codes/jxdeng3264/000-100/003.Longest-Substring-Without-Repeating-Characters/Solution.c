int lengthOfLongestSubstring(char* s) {
    int n = strlen(s);
    if (0==n)
        return 0;
    if (1==n)
        return 1;
        
    int ret = 1;
    int arr[256] = {-1};
    memset(arr, -1, 256*sizeof(int));
    arr[s[0]] = 0;
    int i = 0;
    int j = 1;
    for (;i<n;)
    {
        if (j<n && arr[s[j]]==-1)
        {
            arr[s[j]] = j;
            ret = (ret > j-i+1)?ret:(j-i+1);
            j++;
            if (j==n)
                break;
        }
        else
        {
            int t = arr[s[j]];
            for (int k=i; k<=t; ++k)
                arr[s[k]] = -1;
            i = t + 1;
        } 
    }
     
    return ret;
}
