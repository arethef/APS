def solution(people, limit):
    answer = 0
    people.sort()
    h = 0
    t = len(people)-1
    while h<t:
        if people[h]+people[t]<=limit:
            h += 1
        t -=1
        answer += 1
    return answer if t!=h else answer+1