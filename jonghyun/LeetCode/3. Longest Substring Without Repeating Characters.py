"""
중복 없이 가장 긴 문자열의 길이를 찾는 문제.

시간 초과 이슈가 있음...!

https://leetcode.com/problems/longest-substring-without-repeating-characters/
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        from collections import Counter
        
        answer = 0

        if not s:
            return answer
        elif len(s) == 1:
            return 1
        
        for start_index, start_char in enumerate(s):
            end_index = start_index + 1
            
            while end_index <= len(s):
                substr = s[start_index:end_index]
                
                if sum([v == 1 for v in Counter(substr).values()]) == len(substr):
                    answer = max(answer, len(substr))
                    
                end_index += 1
        
        return answer

