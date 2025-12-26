import math
import struct
import csv

def compute_y(x):
    if abs(x) < 1e-15:
        return None
    if abs(math.cos(x)) < 1e-12:
        return None
    return math.tan(x) / (3.0 * x)

def generate_values(start, end, step):
    if step <= 0:
        raise ValueError("Крок повинен бути додатнім числом.")
    vals = []
    x = start
    if start <= end:
        while x <= end + 1e-12:
            vals.append((x, compute_y(x)))
            x += step
    else:
        while x >= end - 1e-12:
            vals.append((x, compute_y(x)))
            x -= step
    return vals

def write_text(filename, data):
    with open(filename, 'w', newline='', encoding='utf-8') as f:
        writer = csv.writer(f)
        writer.writerow(['x', 'y'])
        for x, y in data:
            if y is None:
                writer.writerow([f"{x:.12g}", "nan"])
            else:
                writer.writerow([f"{x:.12g}", f"{y:.12g}"])

def read_text(filename):
    results = []
    with open(filename, 'r', newline='', encoding='utf-8') as f:
        reader = csv.reader(f)
        next(reader, None)
        for row in reader:
            x = float(row[0])
            y = None if row[1] == "nan" else float(row[1])
            results.append((x, y))
    return results

def write_binary(filename, data):
    with open(filename, 'wb') as f:
        f.write(struct.pack('I', len(data)))
        for x, y in data:
            yf = math.nan if y is None else float(y)
            f.write(struct.pack('dd', float(x), yf))

def read_binary(filename):
    results = []
    with open(filename, 'rb') as f:
        header = f.read(4)
        if len(header) < 4:
            return results
        count = struct.unpack('I', header)[0]
        for _ in range(count):
            chunk = f.read(16)
            if len(chunk) < 16:
                break
            x, y = struct.unpack('dd', chunk)
            if math.isnan(y) or math.isinf(y):
                y = None
            results.append((x, y))
    return results

def format_print(data):
    print(f"{'x':>15} | {'y':>15}")
    print("-" * 33)
    for x, y in data:
        ys = "nan" if y is None else f"{y:.8g}"
        print(f"{x:15.8g} | {ys:15}")

def main():
    try:
        start = float(input("start: ").strip())
        end = float(input("end: ").strip())
        step = float(input("step: ").strip())
    except:
        print("Невірний формат")
        return

    try:
        data = generate_values(start, end, step)
    except Exception as ex:
        print(ex)
        return

    text_file = "text_output.csv"
    bin_file = "bin_output.bin"

    write_text(text_file, data)
    write_binary(bin_file, data)

    print("\nТекстовий файл:")
    format_print(read_text(text_file))

    print("\nБінарний файл:")
    format_print(read_binary(bin_file))

if __name__ == "__main__":
    main()
