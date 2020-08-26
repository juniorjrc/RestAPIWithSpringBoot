IF object_id('tb_book') is not null
    PRINT 'TABELA TB_BOOK JÁ EXISTENTE NO BANCO'
ELSE
    PRINT 'CRIANDO A TABELA TB_BOOK'
    CREATE TABLE "tb_book" (
		"id" INT IDENTITY NOT NULL,
		"name" VARCHAR(100) NOT NULL,
		"description" VARCHAR(255) DEFAULT NULL,
		PRIMARY KEY ("id")
	);