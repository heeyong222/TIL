t = int(input())

for i in range(t):
    n = int(input())
    ans = 0
    l = [0]*10
    tmp = list(map(int, input()))
    print(tmp)
    for cnt in tmp:
        l[cnt] += 1
    print(l)
    max_score = max(l)
    for j in range(10):
        if l[j] == max_score:
            ans = j
    print("#"+str(i+1)+' '+str(ans)+' '+str(max_score))