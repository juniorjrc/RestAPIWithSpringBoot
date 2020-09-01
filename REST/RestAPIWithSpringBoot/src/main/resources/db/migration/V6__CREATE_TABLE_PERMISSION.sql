IF object_id('tb_permission') is not null
    PRINT 'TABELA tb_permission JÁ EXISTENTE NO BANCO'
ELSE
    PRINT 'CRIANDO A TABELA tb_permission'
    CREATE TABLE "tb_permission"(
    	"id_permission" INT NOT NULL IDENTITY,
    	"description" VARCHAR(255) DEFAULT NULL,
    	PRIMARY KEY("id_permission")
    );