"""
다리 길이 만큼 0 리스트를 만들어 두고 한번에 무조건 한 칸씩만 이동하니까 반복문으로 왼쪽의 0을 뺴고
오른쪽에 트럭 무게를 넣어주는 식으로 풀이

트럭이 모두 버스에 올라가는 경우부터는 pop 할 수 없어서 오류 나는데, 때문에 try except로 묶어버림

https://programmers.co.kr/learn/courses/30/lessons/42583
"""

def solution(bridge_length, weight, truck_weights):
    bridge = [0] * bridge_length
    answer = 0
    
    while True:
        bridge.pop(0)
        try:
            if sum(bridge) + truck_weights[0] <= weight:
                bridge.append(truck_weights.pop(0))
            else:
                bridge.append(0)
        except:
            bridge.append(0)
        answer += 1

        if not truck_weights and sum(bridge) == 0:
            break
    
    return answer