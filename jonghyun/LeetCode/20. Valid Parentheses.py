"""
올바른 괄호 여부 판단
stack method 활용

https://leetcode.com/problems/valid-parentheses/submissions/
"""

# 깔끔
class Solution:
    def isValid(self, s: str) -> bool:
        result = []
        
        table = {
            ")": "(",
            "]": "[",
            "}": "{"
        }
        
        for char in s:
            if char not in table:
                result.append(char)
            elif not result or table[char] != result.pop():
                return False

        return len(result) == 0

# 지저분
class Solution:
    def isValid(self, s: str) -> bool:
        result = []
        
        table = {
            ")": "(",
            "]": "[",
            "}": "{"
        }
        
        for char in s:
            try:
                if char not in table:
                    result.append(char)
                elif table[char] != result.pop():
                    return False
            except:
                return False
        
        if result:
            return False
        else:
            return True