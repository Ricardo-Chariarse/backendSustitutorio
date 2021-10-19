create table candidato(
                          nombre				varchar(50),
                          apellidos			varchar(50),
                          dni					varchar(10)
);
create table preguntas(
                          codigo_pregunta		numeric(9),
                          enunciado			varchar(100)
);
create table alternativa(
                            codigo_alternativa		numeric(9),
                            codigo_pregunta			numeric(9),
                            enunciado				varchar(100),
                            correcto				varchar(1)
);
create table respuesta(
                          dni 				varchar(12),
                          codigo_alternativa 	numeric(9)
);
create table examen(
    codigo_examen		numeric(9)
);
insert into preguntas (codigo_pregunta,enunciado) values (1,'¿que color del semaforo detiene los autos');
insert into preguntas (codigo_pregunta,enunciado) values (2,'¿que color del semaforo avisa la proxima detencion los autos');
insert into preguntas (codigo_pregunta,enunciado) values (3,'¿que color del semaforo hace que avancen los autos');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (1,1,'rojo','1');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (2,1,'verde','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (3,1,'azul','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (4,1,'amarillo','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (5,1,'plomo','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (1,3,'rojo','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (2,3,'verde','1');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (3,3,'azul','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (4,3,'amarillo','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (5,3,'plomo','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (1,2,'rojo','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (2,2,'verde','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (3,2,'azul','0');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (4,2,'amarillo','1');
insert into alternativa (codigo_alternativa,codigo_pregunta,enunciado,correcto)
values (5,2,'plomo','0');
select * from preguntas;
SELECT p.codigo_pregunta, p.enunciado pregunta_enunciado, a.codigo_alternativa, a.enunciado alternativa_enunciado, a.correcto
FROM preguntas p
         JOIN alternativa a
              ON (p.codigo_pregunta = a.codigo_pregunta)
ORDER BY p.codigo_pregunta, a.codigo_alternativa ;
