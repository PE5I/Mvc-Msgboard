/* development sql script */
DROP DATABASE IF EXISTS msgboarddb;
DROP USER IF EXISTS `msgboard-admin`@`%`;
DROP USER IF EXISTS `msgboard-user`@`%`;

CREATE DATABASE IF NOT EXISTS msgboarddb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `msgboard-admin`@`%` IDENTIFIED WITH mysql_native_password BY 'adminpassword';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
    CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `msgboarddb`.* TO `msgboard-admin`@`%`;

CREATE USER IF NOT EXISTS `msgboard-user`@`%` IDENTIFIED WITH mysql_native_password BY 'userpassword';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `msgboarddb`.* TO `msgboard-user`@`%`;
