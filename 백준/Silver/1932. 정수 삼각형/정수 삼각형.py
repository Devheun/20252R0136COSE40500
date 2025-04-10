tree = []
n = int(input())
for _ in range(n):
    tree.append(list(map(int, input().split())))
 
for i in range(1, n):
    for j in range(i+1):
        if j == 0:
            tree[i][j] += tree[i-1][j]
        elif j == i:
            tree[i][j] += tree[i-1][j-1]
        else:
            tree[i][j] += max(tree[i-1][j-1], tree[i-1][j])

print(max(tree[n-1]))
    