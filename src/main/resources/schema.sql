DROP TABLE IF EXISTS m_motocycle;
CREATE TABLE m_motocycle (
    moto_no INT NOT NULL PRIMARY KEY COMMENT 'バイク番号',
    moto_name VARCHAR(100) COMMENT 'バイク名',
    seat_height INT COMMENT 'シート高',
    cylinder INT COMMENT 'シリンダー',
    cooling VARCHAR(20) COMMENT '冷却方式',
    price INT COMMENT '価格',
    comment VARCHAR(200) COMMENT 'コメント',
    brand_id VARCHAR(2) COMMENT 'ブランドID',
    version INT COMMENT 'バージョン',
    ins_dt DATETIME COMMENT '登録日時',
    upd_dt DATETIME COMMENT '更新日時'
) COMMENT 'モーターサイクルマスター';

DROP TABLE IF EXISTS m_brand;

CREATE TABLE m_brand(
    brand_id VARCHAR(2) NOT NULL PRIMARY KEY COMMENT 'ブランドID',
    brand_name VARCHAR(20) COMMENT 'ブランド名'
) COMMENT 'ブランドマスター';
