from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

N = int(input())
card = list(map(int,input().split()))
M = int(input())
num = list(map(int,input().split()))

card.sort()

def count_by_range(card, left_value, right_value):
    right_index = bisect_right(card, right_value)
    left_index = bisect_left(card, left_value)
    return right_index - left_index

for i in num:
    print(count_by_range(card, i, i))