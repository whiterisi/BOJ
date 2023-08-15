import math
def solution(n, k):
    answer = 0
    mod = math.floor(n/10)
    bev = k-mod
    if bev<0:
        bev=0
    answer = n*12000 + bev*2000
    return answer