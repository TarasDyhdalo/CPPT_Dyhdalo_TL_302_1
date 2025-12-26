from .plant import Plant

class Tree(Plant):
    def __init__(self, name: str, age: int, height: float, tree_type: str):
        super().__init__(name, age)
        self.height = height
        self.tree_type = tree_type

    def grow(self, years: int = 1):
        super().grow(years)
        growth_spurt = 0.5 * years
        self.height += growth_spurt
        print(f"Дерево виросло на {growth_spurt}м. Поточна висота: {self.height}м.")

    def get_info(self):
        base_info = super().get_info()
        return f"{base_info} | Тип: Дерево ({self.tree_type}), Висота: {self.height}м"