# https://leetcode.com/problems/valid-parentheses/

# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
#
# An input string is valid if:
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
#
# Note that an empty string is also considered valid.
#
# Example 1:
# Input: "()"
# Output: true
#
# Example 2:
# Input: "()[]{}"
# Output: true
#
# Example 3:
# Input: "(]"
# Output: false
#
# Example 4:
# Input: "([)]"
# Output: false
#
# Example 5:
# Input: "{[]}"
# Output: true
#
# Related Topics String Stack

revert_pairs = {")": "(", "]": "[", "}": "{"}


def valid_parentheses(s: str) -> bool:
    if len(s) == 0 or len(s) % 2 == 1:
        return False
    stack = []
    for c in s:
        if c in revert_pairs.values():
            stack.append(c)
        elif c in revert_pairs:
            if len(stack) == 0 or stack.pop() is not revert_pairs[c]:
                return False
        else:
            return False
    return len(stack) == 0


# normal
assert valid_parentheses("()")
assert valid_parentheses("()[]{}")
assert not valid_parentheses("(]")
assert not valid_parentheses("([)]")
assert valid_parentheses("{[]}")
assert not valid_parentheses("((")
assert not valid_parentheses("){")
# abnormal
assert not valid_parentheses("")
assert not valid_parentheses("  ")
assert not valid_parentheses("(?")
assert not valid_parentheses("())")
