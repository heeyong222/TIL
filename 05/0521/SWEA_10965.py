import math
tc = int(input())

for tc in range(tc):
    n = int(input())
    m = 1
    if n == 1:
        print('#{} 1'.format(tc+1))
    else:
        while 1:
            tmp = n*m
            a = str(math.sqrt(tmp))
            if a[a.index('.')+1:] == '0':
                print('#{} {}'.format(tc+1, m))
                break;
            else:
                m += 1