USE ElectronicBanking;
-- CALL STORED PROCEDURES

-- -----------------------------------
CALL enterPhoneCompany_sp('Tigo');
CALL enterPhoneCompany_sp('Claro');
-- -----------------------------------
CALL enterStateAccount_sp('Enabled');
CALL enterStateAccount_sp('Disabled');
CALL enterStateAccount_sp('Suspended');
CALL enterStateAccount_sp('Deleted');
-- -----------------------------------
CALL enterTypeAccount_sp('Monetary deposits');
CALL enterTypeAccount_sp('Savings deposit');
CALL enterTypeAccount_sp('Card of credit');
CALL enterTypeAccount_sp('Loan');
CALL enterTypeAccount_sp('Fondo de pensión');
-- ---------------------------------------------------------
CALL enterCurrency_sp('DOLAR');
CALL enterCurrency_sp('PESO ARGENTINO');
CALL enterCurrency_sp('PESO MEXICANO');
CALL enterCurrency_sp('EURO ');
CALL enterCurrency_sp('LIBRAS ');
SELECT *
FROM Currency;
-- -----------------------------------
CALL enterDocumentType_sp('passport');
CALL enterDocumentType_sp('DPI');
SELECT *
FROM phonecompany;
-- -----------------------------------
CALL enterPerson_sp('Paco', 'Hernandez', 'Zona 12, Villa nueva', 12365478, 'phernandez@gmail.com', '1234', NOW(), 'Man',
                    'Espaniol', 'A123456B789', 1, 1);
CALL enterPerson_sp('Adriana', 'Crystel', 'Zona 1, Plaza Barrios', 85265478, 'acrystel@gmail.com', 'hola1234', NOW(),
                    'Woman',
                    'Guatemalteca', '787854693524', 2, 2);
CALL enterPerson_sp('Joao', 'Castillo', 'Zona 10, Villa Herrera', 32145696, 'jcastillo@gmail.com', 'hi1234', NOW(),
                    'Man',
                    'Guatemalteco', '7896541232456', 2, 1);
CALL enterPerson_sp('David', 'Sandoval', 'Zona 11, Las charcas', 74125854, 'dsandoval@gmail.com', '12345', NOW(), 'Man',
                    'Guatemalteco', '123456789526', 2, 1);
CALL enterPerson_sp('Jose', 'Mario', 'Zona 9, Monte Maria', 96548527, 'jmario@gmail.com', 'hey123', NOW(), 'Man',
                    'Estado Unidense', 'BC56B789', 1, 2);
-- -----------------------------------
CALL enterAccount_sp(1000.00, 1, 5, 1, 1);
CALL enterAccount_sp(10000.00, 2, 1, 1, 1);
CALL enterAccount_sp(3000.00, NULL, 1, 1, 1);
CALL enterAccount_sp(2000.00, NULL, 1, 1, 1);
CALL enterAccount_sp(20000.00, NULL, 2, 1, 1);
-- -------------------------------------
CALL enterProvider_sp('Tigo', 'Servicio de internet y llamadas', 'Mensualidad Mes de Septiembre', 1);
CALL enterProvider_sp('Centro Tecnico Kinal', 'Colegio privado', 'Mensualidad Mes de Septiembre', 2);
CALL enterProvider_sp('Claro', 'Servicio de internet y llamadas', 'Mensualidad Mes de Septiembre', 3);
CALL enterProvider_sp('Uber eats', 'Servicio de comida a domicilio', 'Cobro de comida a domicilio', 4);
-- ---------------------------------------
CALL enterTransactions_sp(NULL, 1, 1, 'A123456B789', 'Mensualidad mes de septiembre', 1500.00, NOW());
CALL enterTransactions_sp(NULL, 2, 2, '787854693524', 'Mensualidad mes de septiembre', 300.00, NOW());
CALL enterTransactions_sp(NULL, 3, 3, '7896541232456', 'Mensualidad mes de septiembre', 450.00, NOW());
CALL enterTransactions_sp(NULL, 4, 3, '123456789526', 'Mensualidad mes de septiembre', 450.00, NOW());
CALL enterTransactions_sp(NULL, 5, 1, 'BC56B789', 'Mensualidad mes de septiembre', 1500.00, NOW());
-- -----------------------------------

SELECT *
FROM TypeAccount;
SELECT *
FROM Currency;
SELECT *
FROM StateAccount;
SELECT *
FROM Person;
SELECT *
FROM Provider;
SELECT *
FROM Transactions;
SELECT *
FROM PhoneCompany;
SELECT *
FROM DocumentType;
SELECT *
FROM AccountP;