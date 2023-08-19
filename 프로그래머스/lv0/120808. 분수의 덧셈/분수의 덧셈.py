import math
def solution(numer1, denom1, numer2, denom2):
    answer = []
    child = numer1*denom2 + numer2*denom1
    parent = denom1*denom2
    
    cm = math.gcd(child, parent)
    answer.append(child/cm)
    answer.append(parent/cm)
    
    return answer