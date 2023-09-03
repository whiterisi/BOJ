def solution(hp):    
    return hp // 5 + (hp % 5 // 3) + ((hp % 5) % 3)



def solution(hp):
    answer = 0
    for ant in [5, 3, 1]:
        d, hp = divmod(hp, ant)
        answer += d
    return answer
//divmod(num1,num2) # num1을 num2 로 나눈 몫과 나머지를 출력하는 함수



def solution(hp):
    answer = 0
    ant = [5,3,1]

    for item in ant:
        if hp == 0:
            break
        answer += hp//item
        hp = hp%item

    return answer

