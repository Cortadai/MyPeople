
INSERT INTO shareholders (shareholder_id, first_name, last_name, email) VALUES (1, 'Monica', 'Canovas', 'can@mail.com');
INSERT INTO shareholders (shareholder_id, first_name, last_name, email) VALUES (2, 'Augusto', 'Armas', 'armas@mail.com');
INSERT INTO shareholders (shareholder_id, first_name, last_name, email) VALUES (3, 'Diego', 'Espinosa', 'esp@mail.com');
INSERT INTO shareholders (shareholder_id, first_name, last_name, email) VALUES (4, 'Eva', 'Blanco', 'blanco@mail.com');

INSERT INTO stockshares (stockshare_id, num_total, stock_type, shareholder_id) VALUES (1, 100, 'telefonicas', 1);
INSERT INTO stockshares (stockshare_id, num_total, stock_type, shareholder_id) VALUES (2, 200, 'deportivas', 1);
INSERT INTO stockshares (stockshare_id, num_total, stock_type, shareholder_id) VALUES (3, 500, 'criptodivisas', 2);
INSERT INTO stockshares (stockshare_id, num_total, stock_type, shareholder_id) VALUES (4, 150, 'tecnologicas', 3);
INSERT INTO stockshares (stockshare_id, num_total, stock_type, shareholder_id) VALUES (5, 20, 'musicales', 4);
INSERT INTO stockshares (stockshare_id, num_total, stock_type, shareholder_id) VALUES (6, 280, 'farmaceuticas', 4);

INSERT INTO sales (sale_id, min_price, quantity, publication_date, expiration_date, status, stockshare_id) VALUES (1, 25, 25, '2022-08-23', '2022-09-23', 'ACTIVE', 1);
INSERT INTO sales (sale_id, min_price, quantity, publication_date, expiration_date, status, stockshare_id) VALUES (2, 250, 400, '2022-05-01', '2022-08-08', 'ACTIVE', 3);
INSERT INTO sales (sale_id, min_price, quantity, publication_date, expiration_date, status, stockshare_id) VALUES (3, 100, 20, '2022-08-02', '2022-09-02', 'ACTIVE', 5);
INSERT INTO sales (sale_id, min_price, quantity, publication_date, expiration_date, status, stockshare_id) VALUES (4, 800, 100, '2022-08-10', '2022-08-06', 'ACTIVE', 6);

INSERT INTO offers (offer_id, price, initial_date, final_date, status, sale_id, shareholder_id) VALUES (1, 30, '2022-08-24', '2022-08-30', 'ACTIVE', 1, 4);
INSERT INTO offers (offer_id, price, initial_date, final_date, status, sale_id, shareholder_id) VALUES (2, 150, '2022-08-26', null, 'ACTIVE', 3, 3);
INSERT INTO offers (offer_id, price, initial_date, final_date, status, sale_id, shareholder_id) VALUES (3, 1500, '2022-08-27', '2022-08-30', 'ACTIVE', 4, 1);
INSERT INTO offers (offer_id, price, initial_date, final_date, status, sale_id, shareholder_id) VALUES (4, 250, '2022-08-28', '2022-08-30', 'ACTIVE', 2, 1);
INSERT INTO offers (offer_id, price, initial_date, final_date, status, sale_id, shareholder_id) VALUES (9, 20, '2022-08-29', '2022-08-30', 'ACTIVE', 1, 2);

