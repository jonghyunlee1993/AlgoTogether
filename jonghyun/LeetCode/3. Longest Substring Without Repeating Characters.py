"""
중복 없이 가장 긴 문자열의 길이를 찾는 문제.
지금 걸린 테스트 케이스는 " " 인데, 이는 Counter 객체가 공백은 문자열로 취급하지 않기 때문임.

https://leetcode.com/problems/longest-substring-without-repeating-characters/
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        from collections import Counter
        
        answer = 0
        
        if not s:
            return answer
        
        for start_index, start_char in enumerate(s):
            for end_index, end_char in enumerate(s[start_index:]):
                        
                substr = s[start_index:start_index + end_index]
                print(substr)
                
                if sum([v == 1 for v in Counter(substr).values()]) == len(substr):
                    answer = max(answer, len(substr))
        
        return answer
