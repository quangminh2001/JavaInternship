CREATE TABLE account
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    status   INT NULL,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

CREATE TABLE horse
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    name   VARCHAR(255) NULL,
    foaled date NULL,
    CONSTRAINT pk_horse PRIMARY KEY (id)
);

CREATE TABLE horseaccount
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    archive   INT NULL,
    accountid BIGINT NOT NULL,
    horseid   BIGINT NOT NULL,
    CONSTRAINT pk_horseaccount PRIMARY KEY (id)
);

CREATE TABLE trainer
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255) NULL,
    accountid BIGINT NOT NULL,
    CONSTRAINT pk_trainer PRIMARY KEY (id)
);

ALTER TABLE horseaccount
    ADD CONSTRAINT FK_HORSEACCOUNT_ON_ACCOUNTID FOREIGN KEY (accountid) REFERENCES account (id);

ALTER TABLE horseaccount
    ADD CONSTRAINT FK_HORSEACCOUNT_ON_HORSEID FOREIGN KEY (horseid) REFERENCES horse (id);

ALTER TABLE trainer
    ADD CONSTRAINT FK_TRAINER_ON_ACCOUNTID FOREIGN KEY (accountid) REFERENCES account (id);