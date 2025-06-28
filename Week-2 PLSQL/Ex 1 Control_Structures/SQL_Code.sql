CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP VARCHAR2(5)
);

INSERT INTO Customers VALUES (1, 'Thanuja', TO_DATE('1955-01-10', 'YYYY-MM-DD'), 12000, SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (2, 'Darsani', TO_DATE('1985-06-20', 'YYYY-MM-DD'), 9000, SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (3, 'Karthika', TO_DATE('1940-03-25', 'YYYY-MM-DD'), 15000, SYSDATE, 'FALSE');

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Loans VALUES (101, 1, 5000, 5.5, SYSDATE, SYSDATE + 20);
INSERT INTO Loans VALUES (102, 2, 3000, 6.0, SYSDATE, SYSDATE + 90);
INSERT INTO Loans VALUES (103, 3, 7000, 4.5, SYSDATE, SYSDATE + 10);

COMMIT;
--scenario 1--
BEGIN
    FOR rec IN (
        SELECT l.LoanID
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('1% discount applied to Loan ID: ' || rec.LoanID);
    END LOOP;
    COMMIT;
END;

select*from Loans;

--scenario 2--
BEGIN
    FOR cust_rec IN (
        SELECT CustomerID FROM Customers WHERE Balance > 10000 AND NVL(IsVIP, 'FALSE') != 'TRUE'
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = cust_rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('VIP status granted to Customer ID: ' || cust_rec.CustomerID);
    END LOOP;
    COMMIT;
END;
select*from customers;

--scenario 3--
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' for ' || rec.Name ||
                             ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
select*from Loans;