CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 12000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 9000, SYSDATE);
INSERT INTO Accounts VALUES (3, 3, 'Savings', 15000, SYSDATE);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));
COMMIT;

--scenario 1--
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc_rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest applied to Account ID: ' || acc_rec.AccountID);
    END LOOP;
    COMMIT;
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
select*from Accounts;

--scenario 2--
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_name IN VARCHAR2,
    bonus_pct IN NUMBER
) IS
BEGIN
    FOR emp_rec IN (
        SELECT EmployeeID FROM Employees WHERE Department = dept_name
    ) LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * bonus_pct / 100)
        WHERE EmployeeID = emp_rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || emp_rec.EmployeeID);
    END LOOP;
    COMMIT;
END;
/
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/
select*from Employees;

--scenario 3--
CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acct IN NUMBER,
    to_acct IN NUMBER,
    amount IN NUMBER
) IS
    from_balance NUMBER;
BEGIN
    
    SELECT Balance INTO from_balance
    FROM Accounts
    WHERE AccountID = from_acct
    FOR UPDATE;

    IF from_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

   
    UPDATE Accounts
    SET Balance = Balance - amount,
        LastModified = SYSDATE
    WHERE AccountID = from_acct;

   
    UPDATE Accounts
    SET Balance = Balance + amount,
        LastModified = SYSDATE
    WHERE AccountID = to_acct;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || amount || ' from Account ' || from_acct || ' to Account ' || to_acct);

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error during transfer: ' || SQLERRM);
END;
/
BEGIN
    TransferFunds(1, 2, 500);
END;
/

select*from Accounts;