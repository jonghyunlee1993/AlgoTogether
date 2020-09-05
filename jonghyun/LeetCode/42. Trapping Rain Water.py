"""
빗물 받기
왼쪽, 오른쪽 포인터를 이용해서 중앙으로 오면서 max값 보다 작으면 볼륨 하나씩 추가하게끔

https://leetcode.com/problems/trapping-rain-water/submissions/
"""

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        water = 0
        left, right = 0, len(height) - 1 
        left_max, right_max = height[left], height[right]
        
        
        while left < right:
            left_max  = max(height[left], left_max)
            right_max = max(height[right], right_max)
            
            if left_max <= right_max:
                water += left_max - height[left]
                left += 1
            else:
                water += right_max - height[right]
                right -= 1

        return water