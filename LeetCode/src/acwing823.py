n = int(input());
path = [0 for i in range(n)];
used = [False for i in range(n)];

def dfs(index):
    if index == n:
        for i in range(n):
            print(path[i] + 1, end = ' ');
        print();
    for i in range(n):
        if not used[i]:
            path[index] = i;
            used[i] = True;
            dfs(index + 1);
            used[i] = False;

dfs(0);