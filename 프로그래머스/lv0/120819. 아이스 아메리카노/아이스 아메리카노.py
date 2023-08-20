import math
def solution(money):
    answer = [0,0]
    cnt = math.floor(money/5500)
    answer[0] = cnt
    answer[1] = money - cnt*5500
    return answer