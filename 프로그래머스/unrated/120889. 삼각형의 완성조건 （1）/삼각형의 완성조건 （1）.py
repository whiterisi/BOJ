def solution(sides):
    maxNum = max(sides)
    sumNum = sum(sides)-maxNum
    answer = 2
    if maxNum < sumNum :
        answer = 1
    return answer