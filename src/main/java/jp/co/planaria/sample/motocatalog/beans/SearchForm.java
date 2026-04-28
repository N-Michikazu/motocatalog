package jp.co.planaria.sample.motocatalog.beans;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SearchForm {
    
//ブランドID
    private String brandId;
//キーワード
    @Size(min = 2, max = 10)
    private String keyword;
}
