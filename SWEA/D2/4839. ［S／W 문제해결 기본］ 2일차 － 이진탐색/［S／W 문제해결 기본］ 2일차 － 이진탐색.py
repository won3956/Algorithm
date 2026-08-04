T = int(input())

for test_case in range(1, T + 1):
    p, pa, pb = map(int, input().split())

    def binary(p, target):
        count = 1
        left, right = 1, p

        while left <= right:
            mid = (left + right) // 2
            count += 1

            if mid == target:
                return count
            elif mid > target:
                right = mid
            else:
                left = mid

        return count

    a = binary(p, pa)
    b = binary(p, pb)

    if a < b:
        print(f"#{test_case} A")
    elif a > b:
        print(f"#{test_case} B")
    else:
        print(f"#{test_case} 0")