CREATE TABLE sales (
    id INT PRIMARY KEY,
    employee VARCHAR(50),
    department VARCHAR(50),
    amount DECIMAL(10,2),
    sale_date DATE
);

INSERT INTO sales VALUES
(1, 'Анна', 'IT', 1000, '2023-01-01'),
(2, 'Борис', 'IT', 1500, '2023-01-02'),
(3, 'Виктор', 'HR', 800,  '2023-01-01'),
(4, 'Галина', 'HR', 1200, '2023-01-03'),
(5, 'Дмитрий', 'IT', 900,  '2023-01-04'),
(6, 'Елена', 'HR', 1100, '2023-01-02');

--Нумерация по отделу
SELECT
    employee,
    department,
    amount,
    ROW_NUMBER() OVER (PARTITION BY department ORDER BY amount DESC) AS row_num
FROM sales
ORDER BY department, row_num;

--Топ-2 в каждом отделе
SELECT * FROM (
    SELECT
        employee,
        department,
        amount,
        ROW_NUMBER() OVER (PARTITION BY department ORDER BY amount DESC) AS rn
    FROM sales
) ranked
WHERE rn <= 2;

--Накопительный итог по дате
SELECT
    employee,
    sale_date,
    amount,
    SUM(amount) OVER (ORDER BY sale_date) AS running_total
FROM sales
ORDER BY sale_date;

--Сравнение с предыдущей строкой
SELECT
    employee,
    amount,
    LAG(amount) OVER (ORDER BY amount) AS prev_amount,
    amount - LAG(amount) OVER (ORDER BY amount) AS diff
FROM sales
ORDER BY amount;