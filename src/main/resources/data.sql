INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt) VALUES
(1, 'YZF-R1', 850, 4, '水冷', 1500000, 'Yamahaの代表的なスポーツバイク', 1, 1, NOW()),
(2, 'CBR1000RR', 820, 4, '水冷', 1400000, 'Hondaの高性能スポーツバイク', 2, 1, NOW()),
(3, 'GSX-R1000', 810, 4, '水冷', 1300000, 'Suzukiの高出力バイク', 3, 1, NOW()),
(4, 'Ninja ZX-10R', 830, 4, '水冷', 1600000, 'Kawasakiのエクスペリエンスバイク', 4, 1, NOW()),
(5, 'V85 TT', 830, 2, '空冷', 1200000, 'moto guzziのアドベンチャーバイク', 5, 1, NOW()),
(6, 'MT-09', 820, 3, '水冷', 900000, 'Yamahaのネイキッドバイク', 1, 1, NOW()),
(7, 'CB650R', 810, 4, '水冷', 800000, 'Hondaのスタイリッシュなネイキッドバイク', 2, 1, NOW()),
(8, 'SV650', 785, 2, '水冷', 700000, 'Suzukiの人気の中型バイク', 3, 1, NOW()),
(9, 'Z900', 795, 4, '水冷', 850000, 'Kawasakiのパワフルなネイキッドバイク', 4, 1, NOW()),
(10, 'V7 III Stone', 770, 2, '空冷', 750000, 'moto guzziのクラシックなネイキッドバイク', 5, 1, NOW());

INSERT INTO m_brand (brand_id, brand_name) VALUES
(1, 'Yamaha'),
(2, 'Honda'),
(3, 'Suzuki'),
(4, 'Kawasaki'),
(5, 'moto guzzi');