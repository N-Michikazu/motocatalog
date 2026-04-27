INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES
(1, 'GB350', 800, 1, '空冷', 550000, 'Yamahaの代表的なスポーツバイク', '01', 1, NOW(), null),
(2, 'Z900RS', 800, 4, '水冷', 1260000, 'Hondaの高性能スポーツバイク', '02', 1, NOW(), null),
(3, 'W800 CAFE', 790, 2, '水冷', 1100000, 'Suzukiの高出力バイク', '02', 1, NOW(), null),
(4, 'YZF-R1', 100, 4, '水冷', 1500000, 'Kawasakiのエクスペリエンスバイク', '03', 1, NOW(), null),
(5, 'Rebel250', 690, 1, '水冷', 599500, 'moto guzziのアドベンチャーバイク', '01', 1, NOW(), null),
(6, 'Rebel500', 690, 2, '水冷', 799700, 'Yamahaのネイキッドバイク', '01', 1, NOW(), null),
(7, 'SR400 Final Edition', 790, 1, '空冷', 605000, 'Hondaのスタイリッシュなネイキッドバイク', '03', 1, NOW(), null),
(8, 'Z900RS CAFE', 820, 4, '水冷', 1290000, 'Suzukiの人気の中型バイク', '02', 1, NOW(), null),
(9, 'V7 III Racer 10th ANNIVERSARY', 770, 2, '空冷', 1375000, 'Kawasakiのパワフルなネイキッドバイク', '05', 1, NOW(), null);

INSERT INTO m_brand (brand_id, brand_name) VALUES
('01', 'Honda'),
('02', 'Kawasaki'),
('03', 'Yamaha'),
('04', 'Suzuki'),
('05', 'moto guzzi');