from package import Plant, Tree

def main():
    print("Створення базового класу (Рослина):")
    my_flower = Plant("Троянда", 1)
    print(my_flower.get_info())
    my_flower.grow()
    
    print("\nСтворення похідного класу (Дерево):")
    my_oak = Tree("Дуб", 50, 12.5, "Листяне")
    print(my_oak.get_info())
    
    print("\nПроцес росту дерева:")
    my_oak.grow(5)
    
    print("\nФінальна інформація:")
    print(my_oak.get_info())

if __name__ == "__main__":
    main()