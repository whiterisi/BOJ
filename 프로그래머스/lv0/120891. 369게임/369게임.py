def solution(order):
    answer = 0
    clap = ['3','6','9']
    for i in str(order) :
        if i in clap :
            answer+=1
    return answer