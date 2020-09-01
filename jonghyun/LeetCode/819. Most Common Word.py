"""
최빈 단어 찾기

https://leetcode.com/problems/most-common-word/submissions/

"""

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        import re
        from collections import Counter
        
        # 정규 표현식으로 구두점 모두 제거 
        paragraph = re.sub(r'[^\w\s]', ' ', paragraph).lower().split()
        
        # 카운트 자료형을 dictionary로 바꾸어서 정렬함
        count = dict(Counter(paragraph))
        count = sorted(count.items(), key=(lambda x: x[1]), reverse=True)
        
        # ban 단어 필터링
        for word in count:
            if word[0] not in banned:
                return word[0]