"""
두 수의 합으로 target을 맞췄을 때의 인덱스 리턴
1. 단순 루프 이용해서 해결
2. target - number 를 이용해 list에 in 여부를 통해 확인 (시간 복잡도 개선)
3. index, num 해시 테이블을 통한 서치 (가장 빠름)

https://leetcode.com/problems/two-sum/submissions/
"""

# 풀이 1번
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index_1 = 0
        
        while nums:
            number_1 = nums.pop(0)
            
            for index_2, number_2 in enumerate(nums):
                if number_1 + number_2 == target:
                    return [index_1, index_1 + index_2 + 1]
            
            index_1 += 1

# 풀이 2번
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index_1 = 0
        
        while nums:
            number_1 = nums.pop(0)
            find_num = target - number_1
            
            if find_num in nums:
                return [index_1, index_1 + nums.index(find_num) + 1]
            
            index_1 += 1

# 풀이 3번
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        my_dict = {}
        
        for index, number in enumerate(nums):
            my_dict[number] = index
            
        for index, number in enumerate(nums):
            if target - number in my_dict.keys() and index != my_dict[target - number]:
                return [index, my_dict[target - number]]