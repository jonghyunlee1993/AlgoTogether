"""
스택/큐 개념 연습 
index와 value를 같이 관리하는 큐를 만들어서 루프 돌리기
-> 향후 지정된 인덱스와 관계 비교시 유용하게 쓰일 듯

https://programmers.co.kr/learn/courses/30/lessons/42587
"""
def solution(priorities, location):
    answer = 0
    queue = [[index, value] for index, value in enumerate(priorities)]
    
    while queue:
        docu = queue.pop(0)
        
        if sum([x[1] > docu[1] for x in queue]):
            queue.append(docu)
        else:
            answer += 1
            
            if docu[0] == location:
                break
                
    return answer