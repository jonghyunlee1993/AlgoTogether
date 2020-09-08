"""
최소에 사서 최대에 파는 단순한 문제
시간 복잡도를 줄여야 함

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
"""

# 효율성 개선
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_price = sys.maxsize

        for price in prices:
            min_price = min(min_price, price)
            profit    = max(profit, price - min_price)
            
        return profit

# 시간 초과
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        result = 0
        while prices:
            buying_price = prices.pop(0)
            
            for selling_price in prices:
                benefit = selling_price - buying_price
                
                if benefit > result:
                    result = benefit
                    
        return result