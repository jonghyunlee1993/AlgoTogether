"""
회문 판별 문제
알파벳과 숫자 모두 허용

https://leetcode.com/problems/valid-palindrome/
"""

class Solution:
    def isPalindrome(self, s: str) -> bool:
        my_text = []
        
        for string in s.lower():
            if string.isalnum():
                my_text.append(string)
        
        if len(my_text) == 0:
            return True
        elif len(my_text) > 0 and my_text == my_text[::-1]:
            return True
        else:
            return False
        