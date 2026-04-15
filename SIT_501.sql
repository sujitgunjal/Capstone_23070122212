
CREATE DATABASE employeeData;

use employeeData;
-- Create Department table
CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50) NOT NULL
);

-- Create Project table
CREATE TABLE Project (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    dept_id INT NOT NULL,
    FOREIGN KEY (dept_id) REFERENCES Department(dept_id)
);

-- Create Employee table
CREATE TABLE Employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(50) NOT NULL,
    manager_id INT,
    dept_id INT NOT NULL,
    FOREIGN KEY (dept_id) REFERENCES Department(dept_id)
);

-- Insert Department data
INSERT INTO Department (dept_id, dept_name) VALUES
(201, 'HR'),
(202, 'Finance'),
(203, 'Operation'),
(204, 'Sales'),
(205, 'IT');

-- Insert Project data
INSERT INTO Project (project_id, project_name, dept_id) VALUES
(301, 'Hiring', 201),
(302, 'Event', 201),
(303, 'Audit', 202),
(304, 'Urban', 203),
(305, 'Semi-Urban', 203),
(306, 'Social Meida', 204),
(307, 'Advertisement', 204),
(308, 'Frontend (FE)', 205),
(309, 'Backend (BE)', 205),
(310, 'Data Science (DS)', 205);

-- Insert Employee data
INSERT INTO Employee (employee_id, employee_name, manager_id, dept_id) VALUES
(401, 'AAA', 501, 201),
(402, 'BBB', 502, 201),
(403, 'CCC', 504, 201),
(404, 'DDD', 501, 202),
(405, 'EEE', 503, 202),
(406, 'FFF', 504, 202),
(407, 'GGG', 505, 202),
(408, 'HHH', 501, 203),
(409, 'III', 502, 203),
(410, 'JJJ', 501, 203),
(411, 'KKK', 506, 203),
(412, 'LLL', 506, 203),
(413, 'MMM', 501, 204),
(414, 'NNN', 503, 204),
(415, 'OOO', 504, 204),
(416, 'PPP', 505, 204),
(417, 'QQQ', 501, 205),
(418, 'RRR', 506, 205),
(419, 'SSS', 502, 205),
(420, 'TTT', 505, 205);