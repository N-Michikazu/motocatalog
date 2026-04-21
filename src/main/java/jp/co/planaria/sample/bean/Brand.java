package jp.co.planaria.sample.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
バイクメーカー（ブランド） */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    private String brandId;
    private String brandName;
}
