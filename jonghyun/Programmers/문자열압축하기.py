"""
프로그래머스 문자열 압축하기
https://programmers.co.kr/learn/courses/30/lessons/60057

이중 for loop을 이용해서 풀이
"""

def solution(s):
    s_length = []
    result = ""
    
    if len(s) == 1:
        return 1
    
    for cut in range(1, len(s) // 2 + 1):
        pattern = s[:cut]
        count = 1
        
        for i in range(cut, len(s), cut):
            if s[i:i + cut] == pattern:
                count += 1 
            else:
                if count == 1:
                    count = ""
                
                result += str(count) + pattern
                pattern = s[i:i + cut]
                count = 1
        
        if count == 1:
            count = ""
            
        result += str(count) + pattern
        s_length.append(len(result))
        result = ""
        
    return min(s_length)