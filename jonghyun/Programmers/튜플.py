"""
프로그래머스 튜플
https://programmers.co.kr/learn/courses/30/lessons/64065?language=python3

list like로 주어지는 문자열을 ast 라이브러리의 literal_eval 함수를 이용하여 변환
"""

import ast

def solution(s):
    answer = []
    s = sorted(ast.literal_eval(s.replace("{", "[").replace("}", "]")), key=len)
    
    for ss in s:
        for c in ss:
            if c not in answer:
                answer.append(c)
                
    return answer