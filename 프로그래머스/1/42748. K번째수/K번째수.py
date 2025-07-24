def solution(array, commands):
    answer = []
    
    for cmd in commands:
        start = cmd[0] - 1
        end = cmd[1]
        
        target = array[start: end]
        target.sort()
        
        answer.append(target[cmd[2] - 1])
    
    return answer