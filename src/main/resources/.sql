create database hibernate_program_transaction_manager;
create schema hibernate_program_transaction_manager;

CREATE TABLE hibernate_program_transaction_manager.trainer (
  id         bigserial PRIMARY KEY,
  name       VARCHAR(32),
  language   VARCHAR(16) NOT NULL,
  experience INTEGER     NOT NULL
);

CREATE TABLE hibernate_program_transaction_manager.trainee (
  id         bigserial PRIMARY KEY,
  name       VARCHAR(32) NOT NULL,
  trainer_id BIGINT REFERENCES hibernate_program_transaction_manager.trainer (id)
);
