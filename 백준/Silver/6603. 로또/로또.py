import sys

def lotto(start, idx):
    if idx == 6:
        print(' '.join(map(str, lottery)))
        return

    for i in range(start, k):
        lottery[idx] = s[i]
        lotto(i + 1, idx + 1)

input_lines = sys.stdin.read().strip().split('\n')

for line in input_lines:
    if line == '0':
        break
    parts = list(map(int, line.strip().split()))
    k = parts[0]
    s = parts[1:]
    lottery = [0] * 6
    lotto(0, 0)
    print()
