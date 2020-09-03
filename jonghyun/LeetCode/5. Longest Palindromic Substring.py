"""
dynamic programming 방법으로 해결
중앙을 중심으로 sliding window

https://leetcode.com/problems/longest-palindromic-substring/submissions/
"""
class Solution:
    def longestPalindrome(self, s: str) -> str:
        def expand(left, right):
            while left >= 0 and right <= len(s) and s[left] == s[right - 1]:
                left -= 1
                right += 1
                
            return s[left + 1:right - 1]
        
        # 해당 없으면 바로 종료시켜 버림
        if len(s) < 2 or s == s[::-1]:
            return s
        
        result = ''
        
        # 짝수인 경우와 홀수인 경우를 모두 고려하기 위해서 max를 취함
        for i in range(len(s) - 1):
            result = max(result,
                        expand(i, i + 1),
                        expand(i, i + 2),
                        key = len)
            
        return result

# 시간 초과 에러
class Solution:
    def longestPalindrome(self, s: str) -> str:
        result = ""
        length = len(s) + 1
        
        for start_index in range(length):
            for sub_len in range(1, length):
                before_str = s[start_index:sub_len]
                reversed_str = before_str[::-1]
                
                if before_str == reversed_str and len(before_str) >= len(result):
                    result = before_str
        
        return result