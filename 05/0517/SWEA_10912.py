t = int(input())

for i in range(t):
    l=[]
    c = 0
    ans = []
    s = list(input())
    s.sort()

    while len(s) != 0:
        if len(s) > 1:
            if s[0] == s[1]:
                del s[:2]
            else:
                ans.append(s[0])
                del s[0]
        elif len(s) == 1:
            ans.append(s[0])
            del s[0]
    if len(ans) == 0:
        print(f'#{i+1} Good')
    else:
        ans.sort()
        answer = ''.join(ans)
        print(f'#{i+1} {answer}')

