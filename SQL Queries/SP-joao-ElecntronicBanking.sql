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

DELIMITER $$
CREATE PROCEDURE getAllPersons_sp
()
BEGIN
    SELECT * FROM person;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAllProviders_sp
()
BEGIN
    SELECT * FROM provider;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAllStateAccounts_sp
()
BEGIN
    SELECT * FROM stateaccount;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAllCurrencies_sp
()
BEGIN
    SELECT * FROM currency;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAllTypeAccounts_sp
()
BEGIN
    SELECT * FROM typeaccount;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAllPhoneCompanies_sp
()
BEGIN
    SELECT * FROM phonecompany;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAllDocumentTypes_sp
()
BEGIN
    SELECT * FROM documenttype;
END $$
DELIMITER ;

