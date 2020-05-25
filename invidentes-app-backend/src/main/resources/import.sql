/*INTERT ROLERS*/
INSERT INTO db_invidentes.roles (id, nombre) values (1, 'Administrador');
INSERT INTO db_invidentes.roles (id, nombre) values (2, 'Colaborador');
INSERT INTO db_invidentes.roles (id, nombre) values (3, 'Usuario');
/*INTERT USUARIOS*/
insert into db_invidentes.usuarios (id,nombre, apellido, contrasena,fecha_creacion,correo,estado_colaborador, usuario, rol_id)
 values(1,'Aguirre Arias', 'Pedro','$2a$10$7uDwlC5ThBJEOqmHiLvkzezjr25lbXn9alQyO1Nc9.An9x0Ubz.yG', 
 sysdate(),'admin@invidentes.com', 'ACTIVO', 'admin', 1);
 
/*INTERT NORMATIVIDAD*/
/*INSERT INTO normatividad (contenido, descripcion, tipo, titulo) values (?, ?, ?, ?)*/