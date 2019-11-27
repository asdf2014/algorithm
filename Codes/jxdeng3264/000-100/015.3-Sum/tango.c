/**
 * Return an array of arrays of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */

int cmp(const void *a, const void *b)
{
    return (*(int*)a - *(int *)b);
}

int** threeSum(int* nums, int numsSize, int* returnSize) {
    if (numsSize < 3) return NULL;
    qsort(nums, numsSize, sizeof(int), cmp);
    *returnSize = 0;
    int i,j,k,m,L,R;
    int ts = 0;
    int has = 0;
    int **ret = (int**)malloc(sizeof(int*) * (numsSize * (numsSize-1) * (numsSize-2)) / 6);
    for (i = 0; i < numsSize-2 && nums[i] <= 0; ++i) {
        for (j = i + 1; j < numsSize-1 ; ++j) {
            ts = 0 - nums[i] - nums[j];
            if (ts < 0)
                continue;
            L = j + 1;
            R = numsSize - 1;
            while (L <= R) {
                m = L + (R-L)/2;
                if (nums[m] == ts) {
                    has = 0;
                    for (k=0; k < *returnSize; ++k) {
                        if (ret[k][0] > nums[i])  break;
                        if (ret[k][0] == nums[i] && ret[k][1] == nums[j] && ret[k][2] == nums[m])
                        {
                            has = 1;
                            break;
                        }
                    }
                    
                    if (has == 0) {
                        ret[*returnSize] = (int *)malloc(sizeof(int)*3);
                        ret[*returnSize][0] = nums[i];
                        ret[*returnSize][1] = nums[j];
                        ret[*returnSize][2] = nums[m];
                        *returnSize += 1;
                    }
                    break;
                }
                else if (nums[m] < ts){
                    L = m + 1;
                }
                else {
                    R = m -1;
                }
            }
        }
    }

    if (*returnSize == 0) return NULL;
    
    return ret;
}