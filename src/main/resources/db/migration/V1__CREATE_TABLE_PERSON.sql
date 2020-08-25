CREATE TABLE IF NOT EXISTS "tb_person" (
	"id_person" BIGINT NOT NULL,
	"address" VARCHAR(250) NOT NULL COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	"first_name" VARCHAR(30) NOT NULL COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	"gender" VARCHAR(1) NOT NULL COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	"last_name" VARCHAR(30) NOT NULL COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	"phone_number" VARCHAR(14) NULL DEFAULT NULL COLLATE 'SQL_Latin1_General_CP1_CI_AS',
	PRIMARY KEY ("id_person")
);