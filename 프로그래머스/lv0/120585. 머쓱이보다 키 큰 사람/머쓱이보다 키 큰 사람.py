def solution(array, height):
    array.append(height)
    res = sorted(array, reverse=True)
    return res.index(height)