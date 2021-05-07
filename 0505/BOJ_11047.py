n, k = map(int, input().split())
l = []
cnt = 0
for i in range(n):
    l.append(int(input()))

l.reverse()
for i in l:
    if(i > k):
        continue
    else:
        if((k % i) < k):
            cnt = cnt + (k//i)
            k = k % i

print(cnt)

