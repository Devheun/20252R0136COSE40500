from collections import deque
import sys

N = int(input())
deq = deque()

for _ in range(N):
    cmd = sys.stdin.readline().rstrip()
    if len(cmd) > 1:
        first, back = map(int, cmd.split())
        if first == 1:
            deq.appendleft(back)
        else:
            deq.append(back)
    else:
        cmd = int(cmd)
        if cmd == 3:
            print(deq.popleft()) if len(deq) > 0 else print(-1)
        elif cmd == 4:
            print(deq.pop()) if len(deq) > 0 else print(-1)
        elif cmd == 5:
            print(len(deq))
        elif cmd == 6:
            print(1) if len(deq) == 0 else print(0)
        elif cmd == 7:
            print(deq[0]) if len(deq) > 0 else print(-1)
        elif cmd == 8:
            print(deq[len(deq)-1]) if len(deq) > 0 else print(-1)
            