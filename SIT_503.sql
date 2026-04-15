use instaSIT;

create table employee(
    emp_id int,
    emp_name varchar(50),
    dept varchar(20),
    salary int,
    join_date date
);

insert into employee values
(1, 'AAA', 'IT', 50000, '2021-01-10'),
(2, 'BBB', 'IT', 60000, '2020-03-15'),
(3, 'CCC', 'IT', 60000, '2022-07-01'),
(4, 'DDD', 'HR', 40000, '2019-05-21'),
(5, 'EEE', 'HR', 45000, '2021-11-11'),
(6, 'FFF', 'HR', 45000, '2020-02-18'),
(7, 'GGG', 'Sales', 55000, '2021-08-08'),
(8, 'HHH', 'Sales', 55000, '2022-04-04'),
(9, 'III', 'Sales', 60000, '2020-12-12'),
(10, 'JJJ', 'Sales', 60000, '2019-06-06'),
(11, 'KKK', 'Finance', 65000, '2018-09-09'),
(12, 'LLL', 'Finance', 62000, '2021-10-10'),
(13, 'MMM', 'Finance', 62000, '2022-02-02'),
(14, 'NNN', 'IT', 52000, '2023-01-01'),
(15, 'OOO', 'HR', 15000, '2022-09-09');

-- Basic Syntax
-- window_function(expression) over (partition by column order by column)

-- Q1) Assign row number by salary (highest first)
select emp_name, salary, row_number() over (order by salary desc) as rn from employee;

-- Q2) Row number within each department
select emp_name, dept, row_number() over (partition by dept order by emp_id) as rn from employee;

-- Q3) 
select emp_id, emp_name, join_date, row_number() over (order by join_date) as join_order from employee;

-- Moderate Level

-- Q4) Get latest joined employee in each department
select * from (select *, row_number () over (partition by dept order by join_date desc) rn from employee) X where rn=1;

-- Q5) Get top 2 employees by salary per department
select * from (select *, row_number() over (partition by dept order by salary desc) as rn from employee) X where rn <= 2;

-- Q6) Remove duplicates salaries inside department
select * from (select *, row_number() over (partition by dept, salary order by emp_id) as rn from employee) X where rn = 1;

-- Q7) Find first hired employee per department
select * from (select *, row_number() over (partition by dept order by join_date) as rn from employee) X where rn = 1;

-- Q8) Get 3rd highest salary in each department
select * from (select *, row_number() over (partition by dept order by salary desc) as rn from employee) X where rn = 3;

-- Q9) Identify employees who joined after the 2nd joiner in department
select * from (select *, row_number() over (partition by dept order by join_date) as rn from employee) X where rn > 2;


-- RANK() functions

-- Basic level
-- Q1) Rank employees by salary
select emp_name, salary, Rank() over (order by salary desc) as rnk from employee;

-- Q2) Department wise salary rank
select emp_name, dept, Rank() over (partition by dept order by salary desc) as rnk from employee;

-- Q3) Join date rank
select emp_id, emp_name, join_date, Rank() over (order by join_date) as join_order from employee;