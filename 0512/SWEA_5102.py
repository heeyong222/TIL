def makeGraph():
    graph = {key + 1: set() for key in range(V)}

    for _ in range(E):
        key, val = map(int, input().split())
        graph[key].add(val)
        graph[val].add(key)

    return graph


def BFS(s, g):
    global ans
    path.append(s)
    visited[s] = True

    while path:
        node = path.pop(0)

        for next_node in myGraph[node]:
            if not visited[next_node]:
                path.append(next_node)
                visited[next_node] = True
                path_len[next_node] = path_len[node] + 1

                if next_node == g:
                    ans = path_len[next_node]
                    return
    return


T = int(input())

for test_case in range(1, T+1):
    V, E = map(int, input().split())
    myGraph = makeGraph()
    S, G = map(int, input().split())

    path = []
    visited = [False] * (V+1)
    path_len = [0] * (V+1)
    ans = 0
    BFS(S, G)

    print('#{} {}'.format(test_case, ans))