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


DELIMITER $$
CREATE PROCEDURE getTransaction_sp
(IN _id INT)
BEGIN
    SELECT * FROM transactions WHERE idTransaction = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getAccount_sp
(IN _id INT)
BEGIN
    SELECT * FROM accountp WHERE idAccount = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getPerson_sp
(IN _id INT)
BEGIN
    SELECT * FROM person WHERE idPerson = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getProvider_sp
(IN _id INT)
BEGIN
    SELECT * FROM provider WHERE idProvider = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getStateAccount_sp
(IN _id INT)
BEGIN
    SELECT * FROM stateaccount WHERE idStateAccount = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getCurrency_sp
(IN _id INT)
BEGIN
    SELECT * FROM currency WHERE idCurrency = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getTypeAccount_sp
(IN _id INT)
BEGIN
    SELECT * FROM typeaccount WHERE idTypeAccount = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getPhoneCompany_sp
(IN _id INT)
BEGIN
    SELECT * FROM phonecompany WHERE idCompany = _id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getDocumentType_sp
(IN _id INT)
BEGIN
    SELECT * FROM documenttype WHERE idDocumentType = _id;
END $$
DELIMITER ;

