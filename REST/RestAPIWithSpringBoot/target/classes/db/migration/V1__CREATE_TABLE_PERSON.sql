IF object_id('tb_person') is not null
    PRINT 'TABELA TB_PERSON JÁ EXISTENTE NO BANCO'
ELSE
    PRINT 'CRIANDO A TABELA TB_PERSON'
	CREATE TABLE "tb_person" (
		"id_person" INT IDENTITY NOT NULL,
		"address" VARCHAR(250) NOT NULL ,
		"first_name" VARCHAR(30) NOT NULL ,
		"gender" VARCHAR(1) NOT NULL ,
		"last_name" VARCHAR(30) NOT NULL ,
		"phone_number" VARCHAR(14) NULL ,
		PRIMARY KEY ("id_person")
	);