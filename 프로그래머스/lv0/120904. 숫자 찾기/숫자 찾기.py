def solution(num, k):
    answer = -1 
    idx =0
    for i in str(num) :
        idx +=1 
        if i == str(k) :
            answer = idx
            break
    return answer