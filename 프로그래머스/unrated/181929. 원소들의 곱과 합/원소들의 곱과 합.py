def solution(num_list):
    answer = 0
    multi = 1
    square = 0
    for num in num_list :
        multi *= num
        square += num
    if multi < square*square:
        answer = 1
    else:
        answer = 0
    return answer