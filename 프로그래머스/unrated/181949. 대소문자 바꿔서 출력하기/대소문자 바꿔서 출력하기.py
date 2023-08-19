str = input()

res = ''

for i in str :
    if i.isupper() :
        res+=i.lower()
    else :
        res+=i.upper()

print(res)
