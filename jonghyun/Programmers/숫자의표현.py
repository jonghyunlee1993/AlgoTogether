'''
프로그래머스 숫자의표현
https://programmers.co.kr/learn/courses/30/lessons/12924

1. 완전 탐색
2. numpy array 이용
'''

# 1. 완전 탐색 방법을 이용
def solution(n):
    answer = 1
    
    for i in range(1, n // 2 + 1):
        equation = 0
        for j in range(i, n + 1):
            equation += j
            
            if equation == n:
                answer += 1
                break
            elif equation > n:
                break
            
    return answer

# 2. numpy array를 이용한 풀이
# 라이브러리 로드 시간이 길어서 시간 제한 걸림
import numpy as np

def solution(n):
    equations = np.array([])
    
    start = n - 1
    for i in range(start, 0, -1):
        equations[equations < n] += i
        equations = np.append(equations, np.array([i]))
        
    return int(sum(equations == n) + 1)