CREATE MEMORY TABLE CONEXION(
    ID_CONEXION INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 0) NOT NULL PRIMARY KEY, 
    MODULO VARCHAR(50),
    BASE_DATOS VARCHAR(50),
    USUARIO VARCHAR(20), 
    CLAVE VARCHAR(20)
)

CREATE MEMORY TABLE PERFIL(
    ID_PERFIL INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 0) NOT NULL PRIMARY KEY, 
    NOMBRE VARCHAR(20)
)

CREATE MEMORY TABLE PERFIL_CONEXION(
    ID_PERFIL INTEGER,
    ID_CONEXION INTEGER,
    CONSTRAINT SYS_FK_388 FOREIGN KEY(ID_PERFIL) REFERENCES PERFIL(ID_PERFIL) ON DELETE SET NULL,
    CONSTRAINT SYS_FK_388 FOREIGN KEY(ID_CONEXION) REFERENCES CONEXION(ID_CONEXION) ON DELETE SET NULL
)

CREATE MEMORY TABLE PERFIL_USUARIO(
    ID_PERFIL INTEGER,
    ID_USUARIO INTEGER,
    CONSTRAINT SYS_FK_48 FOREIGN KEY(ID_PERFIL) REFERENCES PERFIL(ID_PERFIL) ON DELETE SET NULL,
    CONSTRAINT SYS_FK_74 FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID_USUARIO) ON DELETE SET NULL
)

CREATE MEMORY TABLE CONFIGURACION(
    HOST VARCHAR(20),
    PUERTO INTEGER
)

CREATE MEMORY TABLE USUARIO(
    ID_USUARIO INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 0) NOT NULL PRIMARY KEY, 
    USUARIO VARCHAR(20), 
    CLAVE VARCHAR(20)
)

INSERT INTO CONFIGURACION VALUES('localhost',1433)
INSERT INTO PERFIL VALUES(1,'administrador')
INSERT INTO PERFIL VALUES(2,'usuario')
INSERT INTO CONEXION VALUES(1,'GENERAL','Molemotor','omarjcm','omarjcm')
INSERT INTO CONEXION VALUES(2,'SAG','Molemotor','omarjcm','omarjcm')
