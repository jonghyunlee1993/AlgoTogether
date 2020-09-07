"""
pair의 개념이 헛갈렸으나, 왼쪽에 오는 수가 작은 수일 수 밖에 없도록 정렬한 후, 해당 값을 더하기

https://leetcode.com/problems/array-partition-i/
"""

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        return sum(sorted(nums)[::2])