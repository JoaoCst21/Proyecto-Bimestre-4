USE ElectronicBanking;

DELIMITER $$
CREATE PROCEDURE sp_enterPhoneCompany
(IN _nameCompany VARCHAR(50))
BEGIN
    START TRANSACTION;
    INSERT INTO PhoneCompany (PhoneCompany.nameCompany)
    VALUES (_nameCompany);
    COMMIT;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_queryPhoneCompany
()
BEGIN
    SELECT * FROM phonecompany;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_updatePhoneCompany
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
CREATE PROCEDURE sp_deletePhoneCompany
(IN _idCompany INT)
BEGIN
    START TRANSACTION;
    DELETE FROM PhoneCompany WHERE PhoneCompany.idCompany = _idCompany;
    COMMIT;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE sp_searchPhoneCompany
(IN _idCompany INT)
BEGIN
    SELECT idCompany, nameCompany
    FROM PhoneCompany
    WHERE PhoneCompany.idCompany = _idCompany;
END$$
DELIMITER ;
