operation = input();
total = 0;
count = 0;

for i in range(12):
    record = list(map(float, input().split(' ')));
    for j in range(12):
        if j > i:
            total += record[j];
            count += 1;

if operation == 'M':
    total /= count;
print("%.1lf" % total);
        