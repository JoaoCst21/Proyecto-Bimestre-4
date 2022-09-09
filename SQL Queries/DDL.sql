CREATE
    DATABASE ElectronicBanking;

USE
    ElectronicBanking;

CREATE TABLE `Person`
(
    `idPerson`           INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `personName`         VARCHAR(50),
    `lastName`           VARCHAR(50),
    `direction`          VARCHAR(50),
    `phone`              INT,
    `user`               VARCHAR(50) NOT NULL,
    `dateCreation`       DATETIME,
    `password`           VARCHAR(50),
    `sexo`               VARCHAR(1),
    `Nacionality`        VARCHAR(50),
    `NumberDocumentType` VARCHAR(50),
    `id_DocumentType`    INT         NOT NULL,
    `id_PhoneCompany`    INT         NOT NULL
);

CREATE TABLE `DocumentType`
(
    `idDocumentType`   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nameDocumentType` VARCHAR(50) NOT NULL
);

CREATE TABLE `Account`
(
    `idAccount`     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `saldo`         DECIMAL,
    `id_Person`     INT NOT NULL,
    `id_currency`   INT NOT NULL,
    `type_Account`  INT NOT NULL,
    `state_Account` INT NOT NULL
);

CREATE TABLE `typeAccount`
(
    `idTypeAccount` INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nameAccount`   VARCHAR(50) NOT NULL
);

CREATE TABLE `Proveedor`
(
    `idProveedor`   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nameProveedor` VARCHAR(50),
    `typeService`   VARCHAR(50),
    `description`   VARCHAR(50),
    `id_Account`    INT NOT NULL
);

CREATE TABLE `StateAccount`
(
    `idStateAccount` INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `stateAccount`   VARCHAR(50) NOT NULL
);

CREATE TABLE `Transactions`
(
    `idTransactions`     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
    `idCompany`   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nameCompany` VARCHAR(50) NOT NULL
);

CREATE TABLE `Currency`
(
    `idCurrency`   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nameCurrency` VARCHAR(50) NOT NULL
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

# INSERT INTO Transactions(idTransactions, id_AccountReceiver, id_AccountGive, id_proveedor, identificacionPago,
#                          description, monto, dateTransaction)
# VALUES (1, NULL, NULL, NULL, 'hola', 'hola', 40, NOW());

# DROP DATABASE ElectronicBanking;

INSERT INTO phoneCompany (nameCompany)
VALUES ('Tigo'),
       ('Claro');

SELECT *
FROM phoneCompany;
