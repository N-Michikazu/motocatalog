package jp.co.planaria.sample.motocatalog.forms;


import jp.co.planaria.sample.motocatalog.beans.Brand;
import lombok.Data;

@Data
/**
 * 更新画面の入力内容
 */
public class MotoForm {
    private Integer motoNo;
    private String motoName;
    private Integer  seatHeight;
    private Integer cylinder;
    private String cooling;
    private Integer price;
    private String comment;
    private Brand brand;
    private Integer version;
}
