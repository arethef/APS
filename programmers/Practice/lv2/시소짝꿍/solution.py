from collections import defaultdict
def solution(weights):
    answer = 0
    weights.sort()
    d = defaultdict(int)
    # 1:1 2:3 1:2 3:2 3:4 2:1 4:3
    # x x*(2/3) x*(1/2) x*(3/2) x*(3/4) x*2 x*(4/3)
    for w in weights:
        answer += d[w]+d[w*(2/3)]+d[w*(1/2)]+d[w*(3/2)]+d[w*(3/4)]+d[w*2]+d[w*(4/3)]
        d[w] += 1
    return answer