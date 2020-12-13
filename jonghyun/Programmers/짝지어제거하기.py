'''
프로그래머스 짝지어 제거하기
https://programmers.co.kr/learn/courses/30/lessons/12973

1. 스택을 이용한 풀이
2. 재귀함수를 이용한 풀이 --> 시간 초과
'''

# 1. stack을 이용한 풀이
def solution(s):
    s = list(reversed(list(s)))
    stack = [s.pop()]
    
    while s :
        c = s.pop()
        
        if len(stack) == 0 or stack[-1] != c: 
            stack.append(c)
        else: 
            stack.pop()

    if not stack: 
        return 1
    else: 
        return 0

# 2. 재귀함수 이용한 풀이
def solution(s):
    answer = 1
    
    def find_pair(s):
        for i, char in enumerate(s[:-1]):
            if s[i+1]  == char:
                s_ = s[:i] + s[i+2:]
                return 1, s_
        return 0, s
    
    while answer == 1 and s:
        answer, s = find_pair(s)
    
    return answer