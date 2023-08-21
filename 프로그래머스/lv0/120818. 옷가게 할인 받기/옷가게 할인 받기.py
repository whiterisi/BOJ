import math
def solution(price):
    sale = 1
    if price >= 500000 :
        sale = 0.8
    elif price >= 300000 :
        sale = 0.9
    elif price >= 100000 :
        sale = 0.95
    return math.floor(price*sale)