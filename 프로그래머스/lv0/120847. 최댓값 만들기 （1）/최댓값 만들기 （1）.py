def solution(numbers):
    firMax = max(numbers)
    numbers.remove(firMax)
    secMax = max(numbers)
    return firMax*secMax