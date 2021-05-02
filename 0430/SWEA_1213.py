import sys


for test in range(10):
    tc = int(input())
    a = input()
    b = input()
    cnt = 0
    for i in range(len(b)-len(a)+1):
        tmp = ''
        for j in range(len(a)):
            tmp += b[i+j]
        if tmp == a:
            cnt += 1
    print('#{}'.format(tc), cnt)

