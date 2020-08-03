### 前言
最近在LeetCode上刷到了这样一道题：

<div>
    <img src="../images/KMP/1.jpg" width=70%>
</div>

题目乍一看，很显然，遍历暴力破解两重循环可以轻松AC（其实一开始想的是KMP算法，但是太难了，记不起来了呜呜呜），心想：难怪难度是简单级别~

于是真的就首先尝试了最快写出来的暴力破解，提交结果只击败了27.65%的用户

<div>
    <img src="../images/KMP/2.png" width=70%>
    <img src="../images/KMP/3.jpg" width=70%>
</div>

当然做题嘛，暴力后就要好好反思一下代码有什么改进空间没有，于是就开始对着屏幕前的代码疯狂自言自语中。

### 算法优化

在暴力破解中，主要的思路如下:

<div>
    <img src="../images/KMP/4.png" width=90%>
    <img src="../images/KMP/5.png" width=70%>
    <img src="../images/KMP/6.png" width=70%>
    <img src="../images/KMP/7.png" width=70%>
    <img src="../images/KMP/8.png" width=70%>
    <img src="../images/KMP/9.png" width=70%>
    <img src="../images/KMP/10.png" width=70%>
    <img src="../images/KMP/11.png" width=70%>
    <img src="../images/KMP/12.png" width=70%>
    <img src="../images/KMP/13.png" width=70%>
    <img src="../images/KMP/14.png" width=70%>
    <img src="../images/KMP/15.png" width=70%>
    <img src="../images/KMP/16.png" width=70%>
    <img src="../images/KMP/17.png" width=70%>
    <img src="../images/KMP/18.png" width=70%>
    <img src="../images/KMP/19.png" width=70%>
    <img src="../images/KMP/20.png" width=90%>
</div>

在这过程中，我们可以发现一个很严重的问题，同时也是暴力破解的精髓所在，也就是在第一轮匹配失败过后，needle_cur重新赋值为1的同时haystack_cur也重新赋值为1。

<div>
    <img src="../images/KMP/10.png" width=70%>
    <img src="../images/KMP/11.png" width=70%>
</div>

但是经历了刚才第一轮字符串匹配的我们**的肉眼以及记忆**会发现，下图中红框的部分的内容已经是一样的了，下一回合直接略过这部分从第五个字符开始匹配不香吗？

<div>
    <img src="../images/KMP/21.png" width=70%>
    <img src="../images/KMP/16.png" width=70%>
</div>

或许能不能让代码也像我们一样拥有记忆呢？这时候！一个了不得的思路从脑中浮现。上图中的haystack和needle两个红框的部分其实等同于下图中needle的两个红框！

<div>
    <img src="../images/KMP/22.png" width=70%>
</div>

这时候就可以发现，这两个红框是needle字符串目前已经匹配成功的字符串`ababab`的前缀和后缀，同时也是`ababab`前缀集合{"a","ab","aba","abab","ababa"}以及后缀集合{"babab","abab","bab","ab","a"}`的交集`{"a","ab","abab"}中的最长字符串`abab`!

因此，如果我们能够在匹配失败的时候，通过已知的当前needle已匹配子串的前缀集合和后缀集合的交集的最长字符串，就可以不用比较这部分（最长字符串）的内容，这将大大降低算法的时间复杂度！

为了让代码拥有“记忆”，我们需要提前让代码获取一个表，这个表即为**部分匹配表**(Partial Match Table, PMT)，PMT表中的值即为needle字符串的前缀集合与后缀集合的交集中最长元素的长度。

如下图所示，对于`aba`，它的前缀集合为{"a", "ab"}，后缀集合为{"ba", "a"}。两个集合的交集为{"a"}，那么长度最长的元素就是字符串`a`了，长度为1，所以对于`aba`而言，它在PMT表中对应的值就是1。再比如，对于字符串`ababa`，它的前缀集合为{"a", "ab", "aba", "abab"}，它的后缀集合为{"baba", "aba", "ba", "a"}， 两个集合的交集为{"a", "aba"}，其中最长的元素为`aba`，长度为3。

<div>
    <img src="../images/KMP/23.png" width=70%>
</div>

那么，当遇到下图的这种情况的时候，我们就可以使用PMT加速字符串的查找了。我们发现如果是在 needle_cur 位 失配，那么影响 needle_cur 指针回溯的位置的其实是第 needle_cur −1 位的 PMT 值。
                                        
<div>
    <img src="../images/KMP/10.png" width=70%>
</div>

所以为了编程的方便， 我们不直接使用PMT数组，而是将PMT数组向后偏移一位。我们把新得到的这个数组称为**next数组**。其中要注意的一个技巧是，在把PMT进行向右偏移时，第0位的值，我们将其设成了-1，这只是为了编程的方便，并没有其他的意义。next数组如下表所示。

<div>
    <img src="../images/KMP/24.png" width=70%>
</div>

求解next数组的具体Java程序如下：

<div>
    <img src="../images/KMP/25.png" width=70%>
</div>

图解说明：

<div>
    <img src="../images/KMP/26.png" width=70%>
    <img src="../images/KMP/27.png" width=70%>
    <img src="../images/KMP/28.png" width=70%>
    <img src="../images/KMP/29.png" width=70%>
    <img src="../images/KMP/30.png" width=70%>
    <img src="../images/KMP/31.png" width=70%>
    <img src="../images/KMP/32.png" width=70%>
    <img src="../images/KMP/33.png" width=70%>
    <img src="../images/KMP/34.png" width=70%>
    <img src="../images/KMP/35.png" width=70%>
</div>

下面给出根据next数组进行字符串匹配加速的字符串匹配Java源码:

<div>
    <img src="../images/KMP/36.png" width=70%>
</div>

### KMP(Knuth-Morris-Pratt)字符串匹配算法

没错！上述的优化过程即为KMP字符串匹配算法的核心过程！其中haystack叫做主串，needle叫做模式串。

最初的暴力破解算法即为BF算法(Brute-Force，最基本的字符串匹配算法)。

#### 主要思想

在匹配过程中发生失配时，并不简单的从主串下一个字符开始又一次匹配，而是依据一些匹配过程中得到的信息跳过不必要的匹配，从而达到一个较高的匹配效率。

#### 算法复杂度

对于长度为 n 的主串 haystack 和长度为 m 的模式串 needle，KMP算法的时间复杂度为O(n+m)。

#### BF算法与KMP算法对比

BF算法在字符重复概率不大的情况下，时间复杂度也不是很大，一般为O（Plen+Tlen）。但是一旦出现如下情况，时间复杂度便会很高，如：子串为“111111110”，而主串为 “111111111111111111111111110” ，由于子串的前8个字符全部为‘1’，而主串的的前面一大堆字符也都为1，这样每轮比较都在子串的最后一个字符处出现不等，因此每轮比较都是在子串的最后一个字符进行匹配前回溯，这种情况便是此算法比较时出现的最坏情况。因此该算法在最坏情况下的时间复杂度为O（Plen*Tlen），另外该算法的空间复杂度为O（1）。

BF算法的时间复杂度之所以大，是由于索引指针的回溯引起的，针对以上不足，便有了KMP算法。KMP算法可以在O（Plen+Tlen）的时间数量级上完成串的模式匹配操作。其改进之处在于：每一趟比较重出现字符不等时，不需要回溯索引指针i，而是利用已经得到的部分匹配的结果将子串向右滑动尽可能远的距离，继续进行比较。它的时间复杂度为O（Plen+Tlen），空间复杂度为O（Plen），这从后面的代码中可以看出。