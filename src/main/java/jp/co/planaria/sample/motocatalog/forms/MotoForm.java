package jp.co.planaria.sample.motocatalog.forms;


import jp.co.planaria.sample.motocatalog.beans.Brand;
import lombok.Data;

@Data
/**
 * 更新画面の入力内容
 */
public class MotoForm {
    private int motoNo;
    private String motoName;
    private int  seatHeight;
    private int cylinder;
    private String cooling;
    private int price;
    private String comment;
    private Brand brand;
    private int version;
}
