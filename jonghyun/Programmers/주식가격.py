"""
가격이 떨어지지 않은 초를 리턴하는 문제
이중 for 문으로 해결

https://programmers.co.kr/learn/courses/30/lessons/42584
"""

def solution(prices):
    result = [0] * len(prices)
    
    for i in range(len(prices) - 1):
        for j in range(i, len(prices) - 1):
            if prices[i] > prices[j]:
                break
            else:
                result[i] += 1
    
    return result