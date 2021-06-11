

tc = int(input())

dx = [1,0]
dy = [0,1]

def go(x,y,a):
    #print('시작')
    a += l[x][y]
    #print(x,y,a)
    if x == n-1 and y == n-1:
        #print('마지막도착')
        answer.append(a)
        return

    elif x+1 <= n-1 and y+1 <= n-1:
        #print('< <')
        go(x+1,y,a)
        go(x,y+1,a)
    elif x == n - 1 and y + 1 < n - 1:
        #print('= <')
        go(x, y + 1, a)
    elif x+1 <= n-1 and y == n-1:
        #print('< =')
        go(x+1,y,a)
    elif x <= n-1 and y+1 <= n-1:
        #print('< =')
        go(x,y+1,a)



for t in range(tc):
    n = int(input())
    l = []
    answer = []
    for _ in range(n):
        l.append(list(map(int, input().split())))
    go(0,0,0)
    print('#{} {}'.format(t+1,min(answer)))