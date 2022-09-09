CREATE
    DATABASE ElectronicBanking;

USE
    ElectronicBanking;

CREATE TABLE `Person`
(
    `idPerson`           INT PRIMARY KEY,
    `personName`         VARCHAR(50),
    `lastName`           VARCHAR(50),
    `direction`          VARCHAR(50),
    `phone`              INT,
    `user`               VARCHAR(50),
    `dateCreation`       DATETIME,
    `password`           VARCHAR(50),
    `sexo`               VARCHAR(1),
    `Nacionality`        VARCHAR(50),
    `NumberDocumentType` VARCHAR(50),
    `id_DocumentType`    INT,
    `id_PhoneCompany`    INT
);

CREATE TABLE `DocumentType`
(
    `idDocumentType`   INT PRIMARY KEY,
    `nameDocumentType` VARCHAR(50)
);

CREATE TABLE `Account`
(
    `idAccount`     INT PRIMARY KEY,
    `saldo`         DECIMAL,
    `id_Person`     INT,
    `id_currency`   INT,
    `type_Account`  INT,
    `state_Account` INT
);

CREATE TABLE `typeAccount`
(
    `idTypeAccount` INT PRIMARY KEY,
    `nameAccount`   VARCHAR(50)
);

CREATE TABLE `Proveedor`
(
    `idProveedor`   INT PRIMARY KEY,
    `nameProveedor` VARCHAR(50),
    `typeService`   VARCHAR(50),
    `description`   VARCHAR(50),
    `id_Account`    INT
);

CREATE TABLE `StateAccount`
(
    `idStateAccount` INT PRIMARY KEY,
    `stateAccount`   VARCHAR(50)
);

CREATE TABLE `Transactions`
(
    `idTransactions`     INT PRIMARY KEY,
    `id_AccountReceiver` INT,
    `id_AccountGive`     INT,
    `id_proveedor`       INT,
    `identificacionPago` VARCHAR(50),
    `description`        VARCHAR(50),
    `monto`              DECIMAL,
    `dateTransaction`    DATETIME
);

CREATE TABLE `phoneCompany`
(
    `idCompany`   INT PRIMARY KEY,
    `nameCompany` VARCHAR(50)
);

CREATE TABLE `Currency`
(
    `idCurrency`   INT PRIMARY KEY,
    `nameCurrency` VARCHAR(50)
);

ALTER TABLE `Person`
    ADD FOREIGN KEY (`id_DocumentType`) REFERENCES `DocumentType` (`idDocumentType`);

ALTER TABLE `Person`
    ADD FOREIGN KEY (`id_PhoneCompany`) REFERENCES `phoneCompany` (`idCompany`);

ALTER TABLE `Account`
    ADD FOREIGN KEY (`id_Person`) REFERENCES `Person` (`idPerson`);

ALTER TABLE `Account`
    ADD FOREIGN KEY (`id_currency`) REFERENCES `Currency` (`idCurrency`);

ALTER TABLE `Account`
    ADD FOREIGN KEY (`type_Account`) REFERENCES `typeAccount` (`idTypeAccount`);

ALTER TABLE `Account`
    ADD FOREIGN KEY (`state_Account`) REFERENCES `StateAccount` (`idStateAccount`);

ALTER TABLE `Proveedor`
    ADD FOREIGN KEY (`id_Account`) REFERENCES `Account` (`idAccount`);

ALTER TABLE `Transactions`
    ADD FOREIGN KEY (`id_AccountReceiver`) REFERENCES `Account` (`idAccount`);

ALTER TABLE `Transactions`
    ADD FOREIGN KEY (`id_AccountGive`) REFERENCES `Account` (`idAccount`);

ALTER TABLE `Transactions`
    ADD FOREIGN KEY (`id_proveedor`) REFERENCES `Proveedor` (`idProveedor`);

INSERT INTO Transactions(idTransactions, id_AccountReceiver, id_AccountGive, id_proveedor, identificacionPago,
                         description, monto, dateTransaction)
VALUES (1, NULL, NULL, NULL, 'hola', 'hola', 40, NOW());