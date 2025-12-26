class Plant:
    def __init__(self, name: str, age: int):
        self.name = name
        self.age = age

    def grow(self, years: int = 1):
        self.age += years
        print(f"Рослина '{self.name}' підросла. Вік: {self.age} р.")

    def get_info(self):
        return f"Рослина: {self.name}, Вік: {self.age} р."
