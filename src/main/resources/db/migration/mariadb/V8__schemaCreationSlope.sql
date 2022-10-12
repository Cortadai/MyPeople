DROP TABLE IF EXISTS `providers`;
DROP TABLE IF EXISTS `SLOPE`;
DROP TABLE IF EXISTS `DEVICES`;
DROP TABLE IF EXISTS `DEVICE_GROUP`;
DROP TABLE IF EXISTS `AZIMUTH`;
DROP TABLE IF EXISTS `SITUATION_DESCRIP`;
DROP TABLE IF EXISTS `SIMPFD_SITUATIONS`;

CREATE TABLE `providers`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `name`        varchar(15) DEFAULT NULL,
    `sex`         varchar(20) DEFAULT NULL,
    `age`         int(6) DEFAULT NULL,
    `description` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE SLOPE
(
    COD_SLOPE INTEGER NOT NULL,
    MIN_SLOPE DOUBLE DEFAULT NULL,
    MAX_SLOPE DOUBLE DEFAULT NULL,
    ORIGIN    CHAR(1) NOT NULL,
    PRIMARY KEY (COD_SLOPE)
);

CREATE TABLE DEVICES
(
    COD_DEVICE       INTEGER      NOT NULL,
    DEV_BRAND        VARCHAR(150) NOT NULL,
    DEV_MODEL        VARCHAR(150) NOT NULL,
    DEV_TYPE         VARCHAR(150) NOT NULL,
    UNITARY_VALUE    DOUBLE       NOT NULL,
    UNITARY_VAL_DESC VARCHAR(150) NOT NULL,
    AUX_VALUE        DOUBLE       DEFAULT NULL,
    AUX_DESC         VARCHAR(150) DEFAULT NULL,
    WAR_YEARS        INTEGER      NOT NULL,
    INT_LITERAL      CHAR(31)     DEFAULT NULL,
    COD_TYPE_DEV     VARCHAR(75)  DEFAULT NULL,
    PRIMARY KEY (COD_DEVICE)
);

CREATE TABLE DEVICE_GROUP
(
    COD_DEV_GROUP INTEGER NOT NULL,
    COD_PANEL     INTEGER NOT NULL,
    NUM_PANEL     INTEGER NOT NULL,
    COD_INV       INTEGER NOT NULL,
    NUM_INV       INTEGER NOT NULL,
    COD_BATT      INTEGER DEFAULT NULL,
    NUM_BATT      INTEGER DEFAULT NULL,
    PRIMARY KEY (COD_DEV_GROUP),
    FOREIGN KEY (COD_BATT) REFERENCES DEVICES (COD_DEVICE),
    FOREIGN KEY (COD_INV) REFERENCES DEVICES (COD_DEVICE),
    FOREIGN KEY (COD_PANEL) REFERENCES DEVICES (COD_DEVICE)
);

CREATE TABLE AZIMUTH
(
    COD_AZIMUTH INTEGER NOT NULL,
    INI_POINT   DOUBLE  NOT NULL,
    END_POINT   DOUBLE  NOT NULL,
    PRIMARY KEY (COD_AZIMUTH)
);

CREATE TABLE SITUATION_DESCRIP
(
    COD_SIT_DESC    INTEGER      NOT NULL,
    SIT_DESCRIPTION VARCHAR(150) NOT NULL,
    PRIMARY KEY (COD_SIT_DESC)
);

CREATE TABLE SIMPFD_SITUATIONS
(
    COD_SLOPE    INTEGER NOT NULL,
    COD_AZIMUTH  INTEGER NOT NULL,
    COD_SIT_DESC INTEGER NOT NULL,
    PRIMARY KEY (COD_SLOPE, COD_AZIMUTH),
    FOREIGN KEY (COD_SLOPE) REFERENCES SLOPE (COD_SLOPE),
    FOREIGN KEY (COD_AZIMUTH) REFERENCES AZIMUTH (COD_AZIMUTH),
    FOREIGN KEY (COD_SIT_DESC) REFERENCES SITUATION_DESCRIP (COD_SIT_DESC)
);