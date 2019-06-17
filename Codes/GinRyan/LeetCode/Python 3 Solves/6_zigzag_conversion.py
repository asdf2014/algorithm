"""
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);

示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

"""
思考：
按照范例来看，当使用L E E T C O D E I S H I R I N G并且显示为4行时，每个字母所在的位置为
L    E    E    T    C    O    D    E    I    S    H    I    R    I    N    G 
(0,0)(1,0)(2,0)(3,0)(2,1)(1,2)(0,3)(1,3)(2,3)(3,3)(2,4)(1,5)(0,6)(1,6)(2,6)(3,6)

我们探索一下
假设zigzag有n行m列，原字符串长度为L且已知，原始序列索引为i，输出序列索引为j，分组序数索引
为g，而n已知;

我们可以给点阵分组。

每个形似
L     
E   O 
E C   
T     

为一组，我们来分析一下各个已知条件：
每组字母数量为2*(n-1)，每组占用列数（组列数）为n-1。因此最多有 L/2*(n-1) + 1 组，
但是事实上，如果 L mod 2*(n-1)=0 时，是 L/2*(n-1)。
那么列数最大是 
    
    m = (n-1)(L/2*(n-1) + 1)     当 L mod 2*(n-1) > 0
    m = (n-1)(L/2*(n-1))         当 L mod 2*(n-1) = 0

虽然暂时不知道怎么用，我们回过来看每个字母所在的点。

我们发现了规律，我们可以为每个字母映射一个点的坐标，如一开始写的每个字母对应的坐标。
原数组中，可以分成两种情况：
1、i在(2(n-1),3(n-1))区间中，坐标(row,col)的row是从0递增到n-1的，而col则都是不变的，
g为分组序数，col为 g*(n-1) ；
2、i不在上面的区间中，i的区间为，坐标(row,col)符合 row+col=g*(n-1)。

因此我们继续将上面的示例原字符串进行分类：
|L    E    E    T    |C    O    |D    E    I    S    |H    I    |R    I    N    G    |
|(0,0)(1,0)(2,0)(3,0)|(2,1)(1,2)|(0,3)(1,3)(2,3)(3,3)|(2,4)(1,5)|(0,6)(1,6)(2,6)(3,6)|

如此一来问题就简单多了。接下来应该考虑如何取行。
怎么快速的读写取决于怎么存储和查找数据。
上面的点阵是一个n*m的点阵，并不是每一项都有数据元素，因此可以看成是一个稀疏矩阵。
解决了这个稀疏矩阵的存储问题，那么这个题也就迎刃而解了。

这样看上面的字符串对应位置：
raw:|LEET|CO|DEIS|HI|RING|
row:|0123|21|0123|21|0123|
col:|0000|12|3333|45|6666|


这样看规律更直观，解法更明显，并且这两个对比起来观察更加明显，
再多改一改，少几根线，去掉列：
raw:|LEETCO|DEISHI|RING|
row:|012321|012321|0123|

规律更加明显了，然后再去掉几条线：
raw:|LEETCODEISHIRING|
row:|0123210123210123|
num:|0123456789......|

L     D     R
E   O E   I I
E C   I H   N
T     S     G

行数的变化是先递增再递减的， 方向变化的条件是触到0或n-1时变化
递增1还是-1，每次只要变化递增值的符号就可以了。

此时我们现在要考虑的是存储的问题。我们考虑使用一个哈希映射表来保存
和更新第i行上的字母序列。这个过程是O(1)的，一次循环下来就是O(n)的。
在循环遍历原始字符串s时，会按照规律为每一个字母计算它的所在行数，然
后拼接并更新第i行在哈希映射表中的字符串，这时候直接拼接并更新即可。
比如第0行会每次更新为L->LD->LDR，第1行会每次更新为E->EO->EOE...

最后一个循环按数字增加的顺序拼接哈希表中的保存字符串，这个循环的
T(n) = L/2*(n-1) + 1 是 O(1/n)的，最后会得到O(n) + O(1/n)
也会得到较快的速度。


"""


class Solution:
    def convert(self, s: str, numRows: int) -> str:
        transformed = ""
        r = 0
        sign = 1
        bucket = {}
        for item in range(len(s)):
            if r not in bucket:
                bucket[r] = ""
            bucket[r] += s[item]
            r += sign
            if r == 0 or r == numRows - 1:
                sign = -sign
        for index in range(len(bucket)):
            transformed += bucket[index]
        return transformed


zigzag = "LEETCODEISHIRING"
print(Solution().convert(zigzag, 3))
print(Solution().convert(zigzag, 4))


zigzag = "ABC"
print(Solution().convert(zigzag, 1))
print(Solution().convert(zigzag, 2))
