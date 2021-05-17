import math
tc = int(input())
def pel(x):
    ans = True
    for s in range(len(x)//2):
        if x[s] == x[-(s+1)]:
            ans = True
        elif x[s] != x[-(s+1)]:
            ans = False
            return ans
    return ans

for i in range(tc):
    n, m = map(int, input().split())
    cnt = 0
    for j in range(n, m+1):
        tmp = str(math.sqrt(j))

        if tmp[tmp.index('.')+1:] == '0':
            j2 = int(float(tmp))

        else:
            continue
        if pel(str(j)) == True and pel(str(j2)) == True:

            cnt += 1
    print('#{} {}'.format(i+1, cnt))