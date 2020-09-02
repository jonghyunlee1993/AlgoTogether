"""
default dict를 이용한 anagram 찾기

- defaultdict는 value를 list로 받는 등의 설정이 가능한데, 이 성질을 이용
- 또한 anagram은 정렬하면 동일하다는 성격이 있기 때문에 이를 키값으로 이용


https://leetcode.com/problems/group-anagrams/submissions/
"""

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = collections.defaultdict(list)
        
        for word in strs:
            anagrams[''.join(sorted(word))].append(word)
        
        return anagrams.values()