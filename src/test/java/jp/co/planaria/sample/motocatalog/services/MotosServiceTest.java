package jp.co.planaria.sample.motocatalog.services;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.planaria.sample.motocatalog.beans.Motorcycle;

// 2. classes属性で起動クラスを指定する
@SpringBootTest
public class MotosServiceTest{

    @Autowired
    MotosService service;

    @Test
    void バイク情報を全件検索できる() {
        List<Motorcycle> motos = service.getMotos();
        assertThat(motos.size()).isEqualTo(10);
        //検索結果の各項目の確認
        Motorcycle moto = motos.get(0); //一件目
        assertThat(moto.getMotoNo()).isEqualTo(1);
        assertThat(moto.getMotoName()).isEqualTo("YZF-R1");
        assertThat(moto.getPrice()).isEqualTo(1500000);
        assertThat(moto.getBrand().getBrandName()).isEqualTo("YAMAHA");
    }

}