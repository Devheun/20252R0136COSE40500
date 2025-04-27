from collections import deque

def solution(bridge_length, weight, truck_weights):
    truck_weights = deque(truck_weights)
    bridge = deque([0] * bridge_length)
    time = 0
    cur_weight = 0
    
    while truck_weights:
        time += 1
        cur_weight -= bridge.popleft()
        
        if cur_weight + truck_weights[0] <= weight: # 트럭이 더 올라갈 수 있을 때
            cur_weight += truck_weights[0]
            bridge.append(truck_weights.popleft())
        else: # 트럭이 더 올라갈 수 없을 때
            bridge.append(0)
    
    return time + bridge_length
                
                
                
        