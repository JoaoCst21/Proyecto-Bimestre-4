USE ElectronicBanking;

/*
En las vistas
a. Realizar una vista para cada tabla usando alias (AS) al crear las vistas y usar INNER
JOINS (Si corresponde)
b. Crear una vista llamada “vistaPagosMayoresA_1000”, donde crearan una vista de cuentas
que hicieron alguna gestión (deposito, pago de servicios i/o remesa) con saldo mayor a
1,000.
*/
-- ------------------------------------------
CREATE VIEW person_vw AS
SELECT CONCAT(p.personName, ' ', p.lastName) AS 'Complet Name', p.direction AS 'Direction', p.phone AS 'Phone',
			  DATE_FORMAT(p.dateCreation, '%d/%m/%y') AS 'Date Creation', p.nacionality AS 'Nacionality',
              d.nameDocumentType AS 'Document Type', pc.nameCompany AS 'Phone Company'
FROM Person AS p
INNER JOIN DocumentType AS d ON p.id_DocumentType = d.idDocumentType
INNER JOIN PhoneCompany AS pc ON p.id_PhoneCompany = pc.idCompany;

-- ------------------------------------------
CREATE VIEW documentType_vw AS
SELECT dt.nameDocumentType 'Name Document' 
FROM DocumentType AS dt;

-- ------------------------------------------
CREATE VIEW currency_vw AS
SELECT c.nameCurrency 'Name Currency' 
FROM Currency AS c;

-- ------------------------------------------
CREATE VIEW phoneCompany_vw AS
SELECT pc.nameCompany 'Name Company' 
FROM PhoneCompany AS pc;

-- ------------------------------------------
CREATE VIEW stateAccount_vw AS
SELECT sa.stateAccount 'State Account' 
FROM StateAccount AS sa;

-- ------------------------------------------
CREATE VIEW typeAccount_vw AS
SELECT ta.nameAccount 'Account Type' 
FROM TypeAccount AS ta;

-- ------------------------------------------
CREATE VIEW account_vw AS
SELECT ap.idAccount AS 'ID Account', ap.saldo AS 'Saldo', CONCAT(p.personName, ' ', p.lastName) AS 'Name Person',
	   p.phone AS 'Phone', c.nameCurrency AS 'Name Currency', t.nameAccount AS 'Account Type', s.stateAccount
       AS 'Account Status' 
FROM AccountP AS ap
INNER JOIN Person AS p ON ap.id_Person = p.idPerson
INNER JOIN Currency AS c ON ap.id_Currency = c.idCurrency
INNER JOIN TypeAccount AS t ON ap.type_Account = t.idTypeAccount
INNER JOIN StateAccount AS s ON ap.state_Account = s.idStateAccount;
-- ------------------------------------------
CREATE VIEW provider_vw AS
SELECT p.nameProvider 'Name Provider', p.typeService AS 'Service type', p.descriptionP AS 'Description' 
FROM Provider AS p;

-- ------------------------------------------
CREATE VIEW transactions_vw AS
SELECT	t.paymentIdentifier AS 'Payment Identifier', t.descriptionT AS 'Description Transaction', t.monto AS 'Amount',
		t.dateTransaction AS 'Date Transaction', t.id_AccountReceiver AS 'Account Receiver', t.id_AccountGive AS
        'Account Giver', p.nameProvider AS 'Name Provider', p.descriptionP AS 'Description'
FROM Transactions AS t
/*INNER JOIN AccountP AS ar ON t.id_AccountReceiver = ar.idAccount
INNER JOIN AccountP AS ag ON t.id_AccountGive = ag.idAccount*/
INNER JOIN Provider AS p ON t.id_Provider = p.idProvider;


CREATE VIEW higherTo_1000Payments AS
SELECT	t.paymentIdentifier AS 'Payment Identifier', t.descriptionT AS 'Description Transaction', t.monto AS 'Amount',
		t.dateTransaction AS 'Date Transaction', t.id_AccountGive AS
        'Account Giver', p.nameProvider AS 'Name Provider', p.descriptionP AS 'Description'
FROM Transactions AS t
INNER JOIN Provider AS p ON t.id_Provider = p.idProvider		
WHERE t.monto > 1000.00;
-- ------------------------------------------
SELECT * FROM transactions_vw;
SELECT * FROM provider_vw;
SELECT * FROM account_vw;
SELECT * FROM typeAccount_vw;
SELECT * FROM stateAccount_vw;
SELECT * FROM phoneCompany_vw;
SELECT * FROM currency_vw;
SELECT * FROM documentType_vw;
SELECT * FROM person_vw;

-- 
SELECT * FROM higherTo_1000Payments;