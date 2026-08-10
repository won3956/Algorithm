T = int(input())

for test_case in range(1, T + 1):
    V, E = map(int, input().split())
    V += 1

    edges = []
    parent = list(range(V + 1))

    for _ in range(E):
        a, b, cost = map(int, input().split())
        edges.append((a, b, cost))

    edges.sort(key=lambda x: x[2])

    def find(a):
        if parent[a] == a:
            return a

        parent[a] = find(parent[a])
        return parent[a]

    def union(a, b):
        parent[a] = b

    result = 0
    count = 0

    for a, b, cost in edges:
        rootA = find(a)
        rootB = find(b)

        if rootA != rootB:
            count += 1
            result += cost
            union(rootA, rootB)

        if count == V - 1:
            break

    print("#{} {}".format(test_case, result))