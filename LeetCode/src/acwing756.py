n, m = map(int, input().split());
result = [[0 for j in range(m)] for i in range(n)];

direction = [[0, 1], [1, 0], [0, -1], [-1, 0]];


startx, starty, d = 0, 0, 0;
for i in range(1, n * m + 1):
    result[startx][starty] = i;
    newx = startx + direction[d][0];
    newy = starty + direction[d][1];
    if newx < 0 or newx >= n or newy < 0 or newy >= m or result[newx][newy] > 0:
        d = (d + 1) % 4;
        newx = startx + direction[d][0];
        newy = starty + direction[d][1];
    startx = newx;
    starty = newy;
for i in range(n):
    for j in range(m):
        print(result[i][j], end = ' ');
    print();



