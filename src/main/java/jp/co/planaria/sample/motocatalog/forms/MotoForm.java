package jp.co.planaria.sample.motocatalog.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jp.co.planaria.sample.motocatalog.beans.Brand;
import lombok.Data;

@Data
/**
 * 更新画面の入力内容
 */
public class MotoForm {
    private Integer motoNo;
    @NotBlank
    @Size(min = 1,max = 50)
    private String motoName;
    @Min(0)
    @Max(1000)
    private Integer seatHeight;
    @Max(4)
    @Min(1)
    private Integer cylinder;
    @Size(max = 10)
    private String cooling;
    @Min(100000)
    private Integer price;
    @Size(max = 200)
    private String comment;
    @Valid
    private Brand brand;
    private Integer version;
}
