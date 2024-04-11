## Introduction
This program generates a department report based on data retrieved from CSV files. It creates objects to handle the retrieval of data and converts it into domain objects according to a given class diagram.

## Files
### CSV Files
- `dep.csv`: Contains department information including department code, department name, and location.
- `deptemp.csv`: Contains employee salaries per department, with columns for department code, employee number, and salary.
- `emp.csv`: Contains employee details such as employee number, last name, first name, and job title.

## Execution Sequence
1. Read data from `dep.csv` to create department objects.
2. Read data from `deptemp.csv` to calculate department total salary and associate employees with departments.
3. Read data from `emp.csv` to create employee objects and associate them with their respective departments.

## Sample Report
Department code: IT
Department name: Information Tech
Department total salary: 126,000.00
---------------------Details -------------------------
EmpNo Employee Name Salary
E123 Maxwell, John 30,000.00
E125 Ortiz, Manuel 51,000.00
E124 Delos Reyes, Ernesto 45,000.00

(Reports for HR and Finance departments follow the same format.)

## Instructions
- Do not alter the composition of domain objects.
- Use correct naming conventions for variables and objects.
- Utilize HashMap to handle data.
- Use `department.setDepTotalSalary()` to update department objects with total salary.

## Submission
Submit the GitHub repository link provided in NEUVLE.
