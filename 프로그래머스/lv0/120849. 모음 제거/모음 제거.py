def solution(my_string):
    answer = ''
    ded = 'aeiou'
    for i in my_string :
        if i in ded :
            answer+=''
        else :
            answer+= i        
    return answer