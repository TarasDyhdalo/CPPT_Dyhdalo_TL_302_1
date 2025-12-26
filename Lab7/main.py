def make_jagged(n, fill_char):
    jagged = []
    for r in range(n):
        jagged.append([fill_char] * (n - r))
    return jagged

def print_matrix(jagged, n):
    for row in jagged:
        print(' '.join(row) + ' ' * (n - len(row)))

def main():
    try:
        n = int(input("Введіть розмір n: ").strip())
        if n <= 0:
            print("Розмір має бути додатнім")
            return
    except:
        print("Невірний формат")
        return

    fill = input("Введіть символ: ")
    if len(fill) != 1:
        print("Потрібен один символ")
        return   

    jagged = make_jagged(n, fill)
    print_matrix(jagged, n)

if __name__ == "__main__":
    main()
