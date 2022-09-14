USE ElectronicBanking;


DELIMITER $$
CREATE PROCEDURE enterPhoneCompany_sp
(IN _nameCompany VARCHAR(50))
BEGIN
    START TRANSACTION;
    INSERT INTO PhoneCompany (PhoneCompany.nameCompany)
    VALUES (_nameCompany);
    COMMIT;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updatePhoneCompany_sp
(IN _nameCompany VARCHAR(50), IN _idCompany INT)
BEGIN
    START TRANSACTION;
    UPDATE PhoneCompany
    SET PhoneCompany.nameCompany = _nameCompany
    WHERE PhoneCompany.idCompany = _idCompany;
    COMMIT;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deletePhoneCompany_sp
(IN _idCompany INT)
BEGIN
    START TRANSACTION;
    DELETE FROM PhoneCompany WHERE PhoneCompany.idCompany = _idCompany;
    COMMIT;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE searchPhoneCompany_sp
(IN _idCompany INT)
BEGIN
    SELECT idCompany, nameCompany
    FROM PhoneCompany
    WHERE PhoneCompany.idCompany = _idCompany
    UNION
    SELECT NULL, NULL
    FROM dual
    WHERE NOT EXISTS
        (SELECT idCompany, nameCompany
         FROM PhoneCompany
         WHERE idCompany = _idCompany);
END$$
DELIMITER ;

-- STORED PROCEDURE PERSON
DELIMITER $$
CREATE PROCEDURE enterPerson_sp
(IN person_Name VARCHAR(50), IN last_Name VARCHAR(50), IN _direction VARCHAR(50), IN _phone INT,
 IN user_Person VARCHAR(50), password_Person VARCHAR(50), IN date_Creation DATETIME,
 IN _sexo VARCHAR(50), IN _nacionality VARCHAR(50), IN _numberDocumentType VARCHAR(50),
 IN _id_DocumentType INT, IN _id_PhoneCompany INT)
BEGIN
    START TRANSACTION;
    INSERT INTO Person (personName, lastName, direction, phone, userPerson, passwordPerson, dateCreation, sexo,
                        nacionality,
                        numberDocumentType, id_DocumentType, id_PhoneCompany)
    VALUES (person_Name, last_Name, _direction, _phone, user_Person, password_Person, date_Creation, _sexo,
            _nacionality,
            _numberDocumentType, _id_DocumentType, _id_PhoneCompany);
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updatePerson_sp
(IN person_Name VARCHAR(50), IN last_Name VARCHAR(50), IN _direction VARCHAR(50), IN _phone INT,
 IN user_Person VARCHAR(50), password_Person VARCHAR(50), IN date_Creation DATETIME,
 IN _sexo VARCHAR(50), IN _nacionality VARCHAR(50), IN _numberDocumentType VARCHAR(50),
 IN _id_DocumentType INT, IN _id_PhoneCompany INT, IN _idPerson INT)
BEGIN
    START TRANSACTION;
    UPDATE Person
    SET Person.personName         = person_Name,
        Person.lastName           = last_Name,
        Person.direction          = _direction,
        Person.phone              = _phone,
        Person.userPerson         = user_Person,
        Person.passwordPerson     = password_Person,
        Person.sexo               = _sexo,
        Person.nacionality        = _nacionality,
        Person.numberDocumentType = _numberDocumentType,
        Person.id_DocumentType    = _id_DocumentType,
        Person.id_PhoneCompany    = _id_PhoneCompany
    WHERE Person.idPerson = _idPerson;
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deletePerson_sp
(IN _idPerson INT)
BEGIN
    START TRANSACTION;
    DELETE FROM Person WHERE Person.idPerson = _idPerson;
    COMMIT;
END $$
DELIMITER ;

-- STORED PROCEDURE ACCOUNTP

DELIMITER $$
CREATE PROCEDURE enterAccount_sp
(IN _saldo DECIMAL(10, 2), IN _id_Person INT, IN _id_Currency INT, IN _type_Account INT,
 IN _state_Account INT)
BEGIN
    START TRANSACTION;
    INSERT INTO AccountP (saldo, id_Person, id_Currency, type_Account, state_Account)
    VALUES (_saldo, _id_Person, _id_Currency, _type_Account, _state_Account);
    COMMIT;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE updateAccount_sp
(IN _saldo DECIMAL(10, 2), IN _id_Person INT, IN _id_Currency INT, IN _type_Account INT,
 IN _state_Account INT, IN _idAccount INT)
BEGIN
    START TRANSACTION;
    UPDATE AccountP
    SET AccountP.saldo         = _saldo,
        AccountP.id_Person     = _id_Person,
        AccountP.id_Currency   = _id_Currency,
        AccountP.type_Account  = _type_Account,
        AccountP.state_Account = _state_Account
    WHERE AccountP.idAccount = _idAccount;
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deleteAccount_sp
(IN _idAccount INT)
BEGIN
    START TRANSACTION;
    DELETE FROM AccountP WHERE AccountP.idAccount = _idAccount;
    COMMIT;
END $$
DELIMITER ;

-- STORED PROCEDURE Currency

DELIMITER $$
CREATE PROCEDURE enterCurrency_sp
(IN _nameCurrency VARCHAR(50))
BEGIN
    START TRANSACTION;
    INSERT INTO Currency (nameCurrency)
    VALUES (_nameCurrency);
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateCurrency_sp
(IN _nameCurrency VARCHAR(50), IN _idCurrency INT)
BEGIN
    START TRANSACTION;
    UPDATE Currency
    SET Currency.nameCurrency = _nameCurrency
    WHERE Currency.idCurrency = _idCurrency;
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deleteCurrency_sp
(IN _idCurrency INT)
BEGIN
    START TRANSACTION;
    DELETE FROM Currency WHERE Currency.idCurrency = _idCurrency;
    COMMIT;
END $$
DELIMITER ;

-- STORED PROCEDURE DOCUMENT TYPE

DELIMITER $$
CREATE PROCEDURE enterDocumentType_sp
(IN _nameDocumentType VARCHAR(50))
BEGIN
    START TRANSACTION;
    INSERT INTO DocumentType (nameDocumentType)
    VALUES (_nameDocumentType);
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateDocumentType_sp
(IN _nameDocumentType VARCHAR(50), IN _idDocumentType INT)
BEGIN
    START TRANSACTION;
    UPDATE DocumentType
    SET DocumentType.nameDocumentType = _nameDocumentType
    WHERE DocumentType.idDocumentType = _idDocumentType;
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deleteDocumentType_sp
(IN _idDocumentType INT)
BEGIN
    START TRANSACTION;
    DELETE FROM DocumentType WHERE DocumentType.idDocumentType = _idDocumentType;
    COMMIT;
END $$
DELIMITER ;

-- STORED PROCEDURE PROVIDER

DELIMITER $$
CREATE PROCEDURE enterProvider_sp
(IN _nameProvider VARCHAR(50), IN _typeServide VARCHAR(50), IN _descriptionP VARCHAR(50), IN __idAccount INT)
BEGIN
    START TRANSACTION;
    INSERT INTO Provider (nameProvider, typeService, descriptionP, _idAccount)
    VALUES (_nameProvider, _typeServide, _descriptionP, __idAccount);
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateProvider_sp
(IN _nameProvider VARCHAR(50), IN _typeServide VARCHAR(50), IN _descriptionP VARCHAR(50), IN __idAccount INT,
 IN _id_Provider INT)
BEGIN
    START TRANSACTION;
    UPDATE Provider
    SET Provider.nameProvider = _nameProvider,
        Provider.typeService  = _typeServide,
        Provider.descriptionP = _descriptionP,
        Provider._idAccount   = __idAccount
    WHERE Provider.idProvider = _id_Provider;
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deleteProvider_sp
(IN id_Provider INT)
BEGIN
    START TRANSACTION;
    DELETE FROM Provider WHERE Provider.idProvider = id_Provider;
    COMMIT;
END $$
DELIMITER ;

-- STORED PROCEDURE STATE ACCOUNT 

DELIMITER $$
CREATE PROCEDURE enterStateAccount_sp
(IN _stateAccount VARCHAR(50))
BEGIN
    START TRANSACTION;
    INSERT INTO StateAccount (stateAccount)
    VALUES (_stateAccount);
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateStateAccount_sp
(IN _stateAccount VARCHAR(50), IN _idStateAccount INT)
BEGIN
    START TRANSACTION;
    UPDATE StateAccount
    SET StateAccount.stateAccount = _stateAccount
    WHERE StateAccount.idStateAccount = _idStateAccount;
    COMMIT;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE deleteStateAccount_sp
(IN _idStateAccount INT)
BEGIN
    START TRANSACTION;
    DELETE FROM StateAccount WHERE StateAccount.idStateAccount = _idStateAccount;
    COMMIT;
END $$
DELIMITER ;

-- STORED PROCEDURE TRANSACTIONS

DELIMITER $$
CREATE PROCEDURE enterTransactions_sp
(IN _idAccountReceiver INT, IN _idAccountGive INT, IN _idProvider INT,
 IN _paymentIdentifier VARCHAR(50), IN _descriptionT VARCHAR(50),
 IN _monto DECIMAL(10, 2), IN _dateTransactions DATETIME)
BEGIN
    START TRANSACTION;
    INSERT INTO Transactions (id_AccountReceiver, id_AccountGive, id_Provider, paymentIdentifier, descriptionT, monto,
                              dateTransaction)
    VALUES (_idAccountReceiver, _idAccountGive, _idProvider, _paymentIdentifier, _descriptionT, _monto,
            _dateTransactions);
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateTransactions_sp
(IN _idAccountReceiver INT, IN _idAccountGive INT, IN _idProvider INT,
 IN _paymentIdentifier VARCHAR(50), IN _descriptionT VARCHAR(50),
 IN _monto DECIMAL(10, 2), IN _dateTransactions DATETIME, IN _idTransaction INT)
BEGIN
    START TRANSACTION;
    UPDATE Transactions
    SET Transactions.id_AccountReceiver = _idAccountReceiver,
        Transactions.id_AccountGive     = _idAccountGive,
        Transactions.id_Provider        = _idProvider,
        Transactions.paymentIdentifier  = _paymentIdentifier,
        Transactions.descriptionT       = _descriptionT,
        Transactions.monto              = _monto,
        Transactions.dateTransaction    = _dateTransactions
    WHERE Transactions.idTransaction = _idTransaction;
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deleteTransaction_sp
(IN _idTransaction INT)
BEGIN
    START TRANSACTION;
    DELETE FROM Transactions WHERE Transactions.idTransaction = _idTransaction;
    COMMIT;
END $$
DELIMITER ;

-- STORED PROCEDURE TYPE ACCOUNT

DELIMITER $$
CREATE PROCEDURE enterTypeAccount_sp
(IN _nameAccount VARCHAR(50))
BEGIN
    START TRANSACTION;
    INSERT INTO TypeAccount (nameAccount)
    VALUES (_nameAccount);
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateTypeAccount_sp
(IN _nameAccount VARCHAR(50), IN _idTypeAccount INT)
BEGIN
    START TRANSACTION;
    UPDATE TypeAccount
    SET TypeAccount.nameAccount = _nameAccount
    WHERE TypeAccount.idTypeAccount = _idTypeAccount;
    COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE deleteTypeAccount_sp
(IN _idTypeAccount INT)
BEGIN
    START TRANSACTION;
    DELETE
    FROM TypeAccount
    WHERE TypeAccount.idTypeAccount = _idTypeAccount;
    COMMIT;
END $$
DELIMITER ;



