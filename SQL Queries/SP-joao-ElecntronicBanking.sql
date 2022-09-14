USE electronicbanking;

DELIMITER $$
CREATE PROCEDURE getAllTransactions_sp
()
BEGIN
    SELECT * FROM transactions;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAllAccounts_sp
()
BEGIN
    SELECT * FROM accountp;
END $$
DELIMITER ;