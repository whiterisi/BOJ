def solution(n):
    answer = 0
    for i in range(n, 0, -1) :
        if n%i==0 :
            answer+=1
    return answer