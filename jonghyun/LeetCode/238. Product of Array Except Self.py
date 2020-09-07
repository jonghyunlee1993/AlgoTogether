"""
자기 자신을 제외한 나머지 수들의 곱

https://leetcode.com/problems/product-of-array-except-self/submissions/
"""

# 자기 자신을 제외한 왼쪽의 곱을 먼저 시행하고 이후에 오른쪽 곱을 시행
# out에 append를 먼저 하고, out[j]에 p를 곱하는 것은 자기 자신의 곱을 하나씩 lag 하는 효과 
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        out = []
        p = 1
        
        for i in range(len(nums)):
            out.append(p)
            p = p * nums[i]
            
        p = 1
        for j in range(len(nums) - 1, 0 - 1, -1):
            out[j] = out[j] * p
            p = p * nums[j]
            
        return out

# 시간 초과
from numpy import prod

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        result = [1] * len(nums)
        
        for index, num in enumerate(nums):
            result[index] = prod(nums[:index] + nums[index + 1:])
            
        return result

# 시간 초과
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = []
        
        for index_1, num_1 in enumerate(nums):
            element_product = 1
            
            for index_2, num_2 in enumerate(nums):
                if index_1 == index_2:
                    pass
                else:
                    element_product *= num_2
        
            result.append(element_product)
        
        return result