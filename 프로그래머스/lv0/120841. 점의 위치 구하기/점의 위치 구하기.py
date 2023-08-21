def solution(dot):
    inX = dot[0]
    inY = dot[1]
    answer = 3
    if inX>0 and inY>0 :
        answer = 1
    elif inX>0 and inY<0 :
        answer = 4
    elif inX<0 and inY >0 :
        answer = 2
    return answer