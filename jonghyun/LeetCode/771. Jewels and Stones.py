"""
전체 돌 중 보석의 개수 카운트하기

1. 해시 테이블을 이용한 풀이
2. Counter를 이용한 풀이
3. list comprehension을 이용한 풀이

https://leetcode.com/problems/jewels-and-stones/
"""

# 1. hash table을 이용한 풀이
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        freq = {}
        
        for s in S:
            if s not in freq:
                freq[s] = 1
            else:
                freq[s] += 1
                
        answer = 0
        for j in J:
            try:
                answer += freq[j]
            except:
                pass
            
        return answer
        
# 2. Counter를 이용한 풀이
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:        
        freq = collections.Counter(S)
        
        answer = 0
        for j in J:
            if j in freq:
                answer += freq[j]
                
        return answer

# 3. list comprehension 이용
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:        
        return sum(s in J for s in S)
