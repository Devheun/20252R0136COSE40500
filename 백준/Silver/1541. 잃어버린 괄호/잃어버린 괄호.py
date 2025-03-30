sentence = list(input().split("-"))
tmp = list()

for i in sentence:
    sum = 0
    a = list(i.split("+"))
    for j in a:
        sum += int(j)
    tmp.append(sum)
    

ans = tmp[0]

for j in range(1, len(tmp)):
    ans -= tmp[j]

print(ans)