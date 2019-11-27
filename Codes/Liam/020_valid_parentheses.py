#执行用时 : 16 ms
#内存消耗 : 12.2 MB

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # https://camo.githubusercontent.com/e5742427c638cd8ca08d56cda1c9c0ab9484a114/68747470733a2f2f626c6f672d313235373132363534392e636f732e61702d6775616e677a686f752e6d7971636c6f75642e636f6d2f626c6f672f78753535752e676966
        # 如果当前字符为左半边括号时，则将其压入栈中
        # 如果遇到右半边括号时，分类讨论：
        # 1）如栈不为空且为对应的左半边括号，则取出栈顶元素，继续循环
        # 2）若此时栈为空，则直接返回false
        # 3）若不为对应的左半边括号，反之返回false
        stack = []
        for i in range(len(s)):
            # 左边括号 入栈
            if( s[i] == '(' or s[i] == '{' or s[i] == '['):
                stack.append(s[i])
            else:
                if len(stack) == 0:
                    return False
                # 1)
                top_stack = stack.pop()
                if ( s[i] == ')' ):
                    match_tmp = '('
                elif ( s[i] == ']' ):
                    match_tmp = '['
                else:
                    match_tmp = '{'
                # 3)
                if top_stack != match_tmp:
                    return False
        # 若循环完毕 栈未空 返回false
        if len(stack) != 0:
            return False
        
        return True
