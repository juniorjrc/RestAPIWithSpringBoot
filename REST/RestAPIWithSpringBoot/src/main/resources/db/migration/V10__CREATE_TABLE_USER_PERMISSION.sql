IF object_id('tb_user_permission') is not null
    PRINT 'TABELA tb_user_permission JÁ EXISTENTE NO BANCO'
ELSE
    PRINT 'CRIANDO A TABELA tb_user_permission'
    CREATE TABLE tb_user_permission(
    	id_user_permission INT NOT NULL IDENTITY,
    	id_user INT NOT NULL,
    	id_permission INT NOT NULL,
    	PRIMARY KEY (id_user_permission),
    	CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES tb_user (id_user), 
    	CONSTRAINT fk_permission FOREIGN KEY (id_permission) REFERENCES tb_permission (id_permission)
    );