IF object_id('tb_user') is not null
    PRINT 'TABELA tb_user JÁ EXISTENTE NO BANCO'
ELSE
    PRINT 'CRIANDO A TABELA tb_user'
    CREATE TABLE "tb_user"(
		"id_user" INT NOT NULL IDENTITY,
		"user_name" VARCHAR(100) NOT NULL UNIQUE,
		"full_name" VARCHAR(255) DEFAULT NULL,
		"password" VARCHAR(255) DEFAULT NULL,
		"account_non_expired" BIT DEFAULT 1,
		"account_non_locked" BIT DEFAULT 1,
		"credentials_non_expired" BIT DEFAULT 1,
		"enabled" BIT DEFAULT 1,
		PRIMARY KEY ("id_user")		
    );