-- DROP DATABASE ElectronicBanking;

CREATE
    DATABASE IF NOT EXISTS ElectronicBanking;
USE
    ElectronicBanking;

CREATE TABLE TypeAccount
(
    idTypeAccount INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameAccount   VARCHAR(50) NOT NULL
);

CREATE TABLE Currency
(
    idCurrency   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameCurrency VARCHAR(50) NOT NULL
);

CREATE TABLE DocumentType
(
    idDocumentType   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameDocumentType VARCHAR(50) NOT NULL
);

CREATE TABLE PhoneCompany
(
    idCompany   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameCompany VARCHAR(50) NOT NULL
);

CREATE TABLE StateAccount
(
    idStateAccount INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    stateAccount   VARCHAR(50) NOT NULL
);

CREATE TABLE Person
(
    idPerson           INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    personName         VARCHAR(50) NOT NULL,
    lastName           VARCHAR(50) NOT NULL,
    direction          VARCHAR(50) NOT NULL,
    phone              INT,
    userPerson         VARCHAR(50) NOT NULL,
    passwordPerson     VARCHAR(50) NOT NULL,
    dateCreation       DATETIME    NOT NULL,
    sexo               VARCHAR(50),
    nacionality        VARCHAR(50) NOT NULL,
    numberDocumentType VARCHAR(50),
    id_DocumentType    INT         NOT NULL,
    id_PhoneCompany    INT         NOT NULL,
    FOREIGN KEY (id_DocumentType) REFERENCES DocumentType (idDocumentType),
    FOREIGN KEY (id_PhoneCompany) REFERENCES PhoneCompany (idCompany)
);
CREATE TABLE AccountP
(
    idAccount     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    saldo         DECIMAL(10, 2),
    id_Person     INT,
    id_Currency   INT NOT NULL,
    type_Account  INT NOT NULL,
    state_Account INT NOT NULL,
    FOREIGN KEY (id_Person) REFERENCES Person (idPerson),
    FOREIGN KEY (id_Currency) REFERENCES Currency (idCurrency),
    FOREIGN KEY (type_Account) REFERENCES TypeAccount (idTypeAccount),
    FOREIGN KEY (state_Account) REFERENCES StateAccount (idStateAccount)
);

CREATE TABLE Provider
(
    idProvider   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nameProvider VARCHAR(50) NOT NULL,
    typeService  VARCHAR(50) NOT NULL,
    descriptionP VARCHAR(50) NOT NULL,
    _idAccount   INT         NOT NULL,

    FOREIGN KEY (_idAccount) REFERENCES AccountP (idAccount)
);



CREATE TABLE Transactions
(
    idTransaction      INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_AccountReceiver INT,
    id_AccountGive     INT,
    id_Provider        INT,
    paymentIdentifier  VARCHAR(50) NOT NULL,
    descriptionT       VARCHAR(50) NOT NULL,
    monto              DECIMAL(10, 2),
    dateTransaction    DATETIME,
    FOREIGN KEY (id_AccountReceiver) REFERENCES AccountP (idAccount),
    FOREIGN KEY (id_AccountGive) REFERENCES AccountP (idAccount),
    FOREIGN KEY (id_Provider) REFERENCES Provider (idProvider)
);

