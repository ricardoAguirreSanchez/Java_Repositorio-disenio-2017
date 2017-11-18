USE dds_utn;

INSERT INTO usuario (id, nombre, apellido, mail, password)
VALUES
    (1, 'Juan', 'Perez', 'perez@gmail.com', 'pass123'),
    (2, 'Marcos', 'Garcia', 'garcia@gmail.com', 'contra455'),
    (3, 'Maria', 'Victoria', 'victoria@gmail.com', 'acceso678'),
    (4, 'Diego', 'Milito', 'milito@gmail.com', 'milito22'),
    (5, 'Bill', 'Gates', 'gates@gmail.com', 'billybilly'),
    (6, 'Pepe', 'Prueba', 'pepe@gmail.com', 'pepito'),
    (7, 'admin', 'admin', 'admin','admin');

INSERT INTO empresa (id, nombre, capital_contable, total_pasivo, fecha_creacion)
VALUES
    (1, 'Sony', 10000, 50000, '2004-05-15'),
    (2, 'Samsung', 50000, 500000, '2016-12-12'),
    (3, 'IBM', 20000, 60000, '1980-03-03'),
    (4, 'Axxion', 910000, 150000, '2016-05-19'),
    (5, 'Microsoft', 10000100, 100000, '1995-02-18'),
    (6, 'Apple', 100000, 50000, '1998-04-30');

INSERT INTO cuenta (id, tipo_cuenta, empresa_id)
VALUES
    (1, 'SSDD', 1),
    (2, 'Darwin', 1),
    (3, 'SSDD', 2),
    (4, 'Darwin', 2),
    (5, 'STD', 2),
    (6, 'STD', 3),
    (7, 'SSDD', 4),
    (8, 'Darwin', 5),
    (9, 'STD', 5),
    (10, 'STD', 6),
    (11, 'Darwin', 6),
    (12, 'SSDD', 5),
    (13, 'STD', 1),
    (14, 'SSDD', 6);

INSERT INTO cuenta_valores (id, cost, gross_booking, profit, roi, fecha_fin, fecha_inicio, cuenta_id)
VALUES
    (1, 120, 12100, 32, 1.3, '2017-09-12', '2017-07-04', 1),
    (2, 120, 1200, 312350, 1.5, '2017-10-12', '2017-08-04', 1),
    (3, 1230, 1200, 32, 1.2, '2017-11-12', '2017-09-04', 1),
    (4, 120, 1200, 3540, 1.2, '2017-12-12', '2017-10-04', 1),
    (5, 123, 1200, 3150, 1.2, '2018-01-12', '2017-11-04', 1),
    (6, 23, 1200, 3520, 1.5, '2018-02-12', '2017-12-04', 1),
    (7, 323, 1200, 250, 1.2, '2018-03-12', '2017-12-04', 2),
    (8, 120, 12040, 3570, 1.2, '2018-04-12', '2017-11-04', 3),
    (9, 123, 1200, 3510, 1.2, '2017-09-13', '2017-12-04', 3),
    (10, 120, 1200, 250, 1.2, '2017-09-14', '2017-06-04', 4),
    (11, 53, 1200, 250, 1.2, '2017-09-15', '2017-03-04', 4),
    (12, 120, 12030, 3550, 1.2, '2017-09-16', '2017-07-04', 4),
    (13, 120, 12020, 3750, 1.2, '2017-09-17', '2017-05-04', 4),
    (14, 120, 1200, 250, 1.2, '2017-09-18', '2017-01-04', 5),
    (15, 120, 12020, 3550, 1.5, '2017-09-19', '2017-02-04', 5),
    (16, 123, 1200, 3530, 1.2, '2017-09-20', '2017-06-04', 4),
    (17, 120, 11200, 31250, 1.2, '2017-09-21', '2017-06-05', 5),
    (18, 120, 1200, 350, 1.2, '2017-09-22', '2017-06-06', 5),
    (19, 32, 1200, 350, 1.5, '2017-09-23', '2017-06-08', 5),
    (20, 120, 1200, 350, 1.2, '2017-09-24', '2017-06-04', 5),
    (21, 120, 12004, 3450, 1.5, '2017-09-25', '2017-06-12', 5),
    (22, 120, 1200, 350, 1.2, '2017-09-26', '2017-06-04', 5),
    (23, 120, 1200, 3250, 1.5, '2017-09-27', '2017-06-10', 6),
    (24, 89, 12005, 3540, 1.2, '2017-09-28', '2017-06-04', 6),
    (25, 120, 1200, 250, 1.2, '2017-09-29', '2017-06-04', 7),
    (26, 32, 12010, 350, 1.2, '2017-09-30', '2017-06-03', 7),
    (27, 123, 1200, 350, 1.2, '2017-10-01', '2017-06-04', 8),
    (28, 56, 1202, 3504, 1.2, '2017-10-02', '2017-06-04', 8),
    (29, 6543, 1200, 250, 1.2, '2017-10-03', '2017-06-15', 8),
    (30, 120, 1200, 350, 1.2, '2017-10-04', '2017-06-04', 8),
    (31, 120, 112400, 350, 1.5, '2017-10-05', '2017-06-04', 9),
    (32, 120, 1200, 250, 1.2, '2017-10-06', '2017-06-17', 9),
    (33, 120, 12030, 350, 1.2, '2017-10-07', '2017-06-04', 10),
    (34, 489, 1200, 350, 1.2, '2017-10-08', '2017-06-04', 10),
    (35, 489, 12020, 350, 1.2, '2017-10-09', '2017-06-04', 11),
    (36, 120, 1200, 350, 1.5, '2017-10-10', '2017-06-19', 11),
    (37, 120, 31200, 250, 1.2, '2017-10-11', '2017-06-04', 11),
    (38, 984, 21200, 250, 1.2, '2017-10-12', '2017-06-04', 12),
    (39, 120, 31200, 350, 1.2, '2017-10-13', '2017-06-04', 12),
    (40, 287, 1200, 250, 1.2, '2017-10-14', '2017-06-04', 13),
    (41, 489, 1200, 250, 1.2, '2017-10-15', '2017-06-04', 14),
    (42, 120, 15200, 250, 1.2, '2017-10-16', '2017-06-04', 14);


INSERT INTO indicador (id, nombre, expresion, usuario_id)
VALUES
    (1, 'Calculo del doble de ROI NICO PRUEBA', 'ROI * 2', 1),
    (2, 'Calculo del ROI', 'GROSS_BOOKING * 0.5 + 15',2),
    (3, 'Calculo de Profit', 'GROSS_BOOKING - COST', 3),
    (4, 'Calculo de Cost', 'COST * 1.5', 4),
    (5, 'Calculo de Profit', 'GROSS_BOOKING - COST', 5),
	(6, 'Calculo de ROI', 'GROSS_BOOKING * 0.5 + 15', 1),
    (7, 'Calculo de Profit', 'GROSS_BOOKING - COST', 2),
    (8, 'Calculo de Cost', 'COST * 1.5', 3),
    (9, 'Calculo de Profit', 'GROSS_BOOKING - COST', 4),
    (10, 'Calculo de Cost', 'COST * 1.5', 5),
    (11, 'Calculo de Cost', 'COST * 1.5', 1);


INSERT INTO metodologia (id, nombre, usuario_id)
VALUES
    (1, "Warrent Buffet", 1),
    (2, "Warrent Buffet",2),
    (10, "Warrent Buffet", 3),
    (11, "Warrent Buffet", 4);


INSERT INTO metodologia_condiciones (Metodologia_id, condiciones)
VALUES
    (1, "Maximizar ROE,Minimizar dueda,Margenes consistentemente crecientes,Longevidad"),
    (2, "Maximizar ROE,Minimizar dueda,Margenes consistentemente crecientes,Longevidad"),
    (10, "Maximizar ROE,Minimizar dueda,Margenes consistentemente crecientes,Longevidad"),
    (11, "Maximizar ROE,Minimizar dueda,Margenes consistentemente crecientes,Longevidad");