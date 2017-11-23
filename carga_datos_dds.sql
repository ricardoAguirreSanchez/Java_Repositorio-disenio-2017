USE dds_utn;

INSERT INTO usuario (id, nombre, apellido, mail, password)
VALUES
    (1, 'admin', 'admin', 'admin','admin'),
    (2, 'root', 'root', 'root', 'root');

INSERT INTO empresa (id, nombre, capital_contable, total_pasivo, fecha_creacion, usuario_id)
VALUES
    (1, 'Empresa-1', 10000, 50000, '2004-05-15', 1),
    (2, 'Empresa-2', 50000, 500000, '2016-12-12', 1),
    (3, 'Empresa-3', 20000, 60000, '1980-03-03', 1),
    (4, 'Empresa-4', 910000, 150000, '2016-05-19', 2),
    (5, 'Empresa-5', 10000100, 100000, '1995-02-18', 2),
    (6, 'Empresa-6', 100000, 50000, '1998-04-30', 2);

INSERT INTO cuenta (id, tipo_cuenta, empresa_id)
VALUES
    (1, 'Cuenta-1-Empresa-1', 1),
    (2, 'Cuenta-2-Empresa-1', 1),
    (3, 'Cuenta-3-Empresa-2', 2),
    (4, 'Cuenta-4-Empresa-2', 2),
    (5, 'Cuenta-5-Empresa-3', 3),
    (6, 'Cuenta-6-Empresa-3', 3),
    (7, 'Cuenta-7-Empresa-4', 4),
    (8, 'Cuenta-8-Empresa-4', 4),
    (9, 'Cuenta-9-Empresa-5', 5),
    (10, 'Cuenta-10-Empresa-5', 5),
    (11, 'Cuenta-11-Empresa-6', 6),
    (12, 'Cuenta-12-Empresa-6', 6);

INSERT INTO cuenta_valores (id, cost, gross_booking, profit, roi, fecha_fin, fecha_inicio, cuenta_id)
VALUES
    (1, 120, 12100, 32, 1.3, '2017-09-12', '2017-07-04', 1),
    (2, 120, 1200, 312350, 1.5, '2017-10-12', '2017-08-04', 1),
    (3, 1230, 1200, 32, 1.2, '2017-11-12', '2017-09-04', 1),
    (4, 120, 1200, 3540, 1.2, '2017-12-12', '2017-10-04', 2),
    (5, 123, 1200, 3150, 1.2, '2018-01-12', '2017-11-04', 2),
    (6, 23, 1200, 3520, 1.5, '2018-02-12', '2017-12-04', 2),
    (7, 323, 1200, 250, 1.2, '2018-03-12', '2017-12-04', 3),
    (8, 120, 12040, 3570, 1.2, '2018-04-12', '2017-11-04', 3),
    (9, 123, 1200, 3510, 1.2, '2017-09-13', '2017-12-04', 3),
    (10, 120, 1200, 250, 1.2, '2017-09-14', '2017-06-04', 4),
    (11, 53, 1200, 250, 1.2, '2017-09-15', '2017-03-04', 4),
    (12, 120, 12030, 3550, 1.2, '2017-09-16', '2017-07-04', 4),
    (13, 120, 12020, 3750, 1.2, '2017-09-17', '2017-05-04', 5),
    (14, 120, 1200, 250, 1.2, '2017-09-18', '2017-01-04', 5),
    (15, 120, 12020, 3550, 1.5, '2017-09-19', '2017-02-04', 5),
    (16, 123, 1200, 3530, 1.2, '2017-09-20', '2017-06-04', 6),
    (17, 120, 11200, 31250, 1.2, '2017-09-21', '2017-06-05', 6),
    (18, 120, 1200, 350, 1.2, '2017-09-22', '2017-06-06', 6),
    (19, 32, 1200, 350, 1.5, '2017-09-23', '2017-06-08', 7),
    (20, 120, 1200, 350, 1.2, '2017-09-24', '2017-06-04', 7),
    (21, 120, 12004, 3450, 1.5, '2017-09-25', '2017-06-12', 7),
    (22, 120, 1200, 350, 1.2, '2017-09-26', '2017-06-04', 8),
    (23, 120, 1200, 3250, 1.5, '2017-09-27', '2017-06-10', 8),
    (24, 89, 12005, 3540, 1.2, '2017-09-28', '2017-06-04', 8),
    (25, 120, 1200, 250, 1.2, '2017-09-29', '2017-06-04', 9),
    (26, 32, 12010, 350, 1.2, '2017-09-30', '2017-06-03', 9),
    (27, 123, 1200, 350, 1.2, '2017-10-01', '2017-06-04', 9),
    (28, 56, 1202, 3504, 1.2, '2017-10-02', '2017-06-04', 10),
    (29, 6543, 1200, 250, 1.2, '2017-10-03', '2017-06-15', 10),
    (30, 120, 1200, 350, 1.2, '2017-10-04', '2017-06-04', 10),
    (31, 120, 112400, 350, 1.5, '2017-10-05', '2017-06-04', 11),
    (32, 120, 1200, 250, 1.2, '2017-10-06', '2017-06-17', 11),
    (33, 120, 12030, 350, 1.2, '2017-10-07', '2017-06-04', 11),
    (34, 489, 1200, 350, 1.2, '2017-10-08', '2017-06-04', 12),
    (35, 489, 12020, 350, 1.2, '2017-10-09', '2017-06-04', 12),
    (36, 120, 1200, 350, 1.5, '2017-10-10', '2017-06-19', 12);

INSERT INTO indicador (id, nombre, expresion, usuario_id)
VALUES
    (1, 'Calculo del doble de ROI NICO PRUEBA', 'ROI * 2', 1),
    (2, 'Calculo del ROI', 'GROSS_BOOKING * 0.5 + 15', 1),
    (3, 'Calculo de Profit', 'GROSS_BOOKING - COST', 1),
    (4, 'Calculo del doble de ROI NICO PRUEBA', 'ROI * 2', 2),
    (5, 'Calculo del ROI', 'GROSS_BOOKING * 0.5 + 15',2),
    (6, 'Calculo de Profit', 'GROSS_BOOKING - COST', 2);

INSERT INTO metodologia (id, nombre, usuario_id)
VALUES
    (1, "Warrent Buffet", 1),
    (2, "Warrent Buffet",2);


INSERT INTO metodologia_condiciones (Metodologia_id, condiciones)
VALUES
    (1, "Maximizar ROE,Minimizar dueda,Margenes consistentemente crecientes,Longevidad"),
    (2, "Maximizar ROE,Minimizar dueda,Margenes consistentemente crecientes,Longevidad"),
    (10, "Maximizar ROE,Minimizar dueda,Margenes consistentemente crecientes,Longevidad"),
    (11, "Maximizar ROE,Minimizar dueda,Margenes consistentemente crecientes,Longevidad");

INSERT INTO regla (id, regla)
VALUES
    (1, 'Maximizar ROE'),
    (2, 'Minimizar deuda'),
    (3, 'Margenes de ganancia'),
    (4, 'Longevidad'),
    (5, 'Maximo total pasivo'),
    (6, 'Maxima cantidad de cuentas'),
    (7, 'Menor capital contable');
