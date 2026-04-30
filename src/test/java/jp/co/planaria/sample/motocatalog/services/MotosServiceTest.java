package jp.co.planaria.sample.motocatalog.services;
import java.time.LocalDateTime;
// import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jp.co.planaria.sample.motocatalog.beans.Brand;
import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.beans.SearchForm;

// 2. classes属性で起動クラスを指定する
@SpringBootTest
public class MotosServiceTest{

    //処理の時間差でassertFailになるため分までを確認
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Autowired
    MotosService service;

    // @Test
    // void バイク情報を全件検索できる() {
    //     List<Motorcycle> motos = service.getMotos(new SearchConditon());
    //     assertThat(motos.size()).isEqualTo(10);
    //     //検索結果の各項目の確認
    //     Motorcycle moto = motos.get(0); //一件目
    //     assertThat(moto.getMotoNo()).isEqualTo(1);
    //     assertThat(moto.getMotoName()).isEqualTo("YZF-R1");
    //     assertThat(moto.getPrice()).isEqualTo(1500000);
    //     assertThat(moto.getBrand().getBrandName()).isEqualTo("YAMAHA");
    // }


    @DisplayName("バイク一覧取得 条件:ブランドID")
    @ParameterizedTest
    @CsvSource({"01, Honda", "02, Kawasaki", "03, Yamaha"})
    void test001(String brandId, String brandName){
        SearchForm condition = new SearchForm();
        condition.setBrandId(brandId); //Honda
        
        List<Motorcycle> motorcycles = service.getMotos(condition);//テスト対象
        assertThat(motorcycles.size()).isGreaterThanOrEqualTo(1);
        for (Motorcycle moto : motorcycles) {
            assertThat(moto.getBrand().getBrandName()).isEqualTo(brandName);
        }

    }


    @DisplayName("バイク一覧取得 条件:ブランドID該当なし")
    @Test
    void test002(){
        SearchForm condition = new SearchForm();
        condition.setBrandId("99"); //存在しないブランドID
        
        List<Motorcycle> motorcycles = service.getMotos(condition);//テスト対象
        assertThat(motorcycles.size()).isEqualTo(0);

    }

    @DisplayName("バイク一覧取得 条件:バイク名-完全一致")
    @ParameterizedTest
    @CsvSource({"Z900RS CAFE", "YZF-R1", "Rebel250"})
    void test003(String motoName){
        SearchForm condition = new SearchForm();
        condition.setKeyword(motoName); //Honda
        
        List<Motorcycle> motorcycles = service.getMotos(condition);//テスト対象
        assertThat(motorcycles.size()).isGreaterThanOrEqualTo(1);
        for (Motorcycle moto : motorcycles) {
            assertThat(moto.getMotoName()).isEqualTo(motoName);
        }

    }
    @DisplayName("バイク一覧取得 条件:バイク名-部分一致")
    @ParameterizedTest
    @CsvSource({"Z900RS CA, Z900RS CAFE", "F-R1, YZF-R1", "bel25, Rebel250"})
    void test004(String keyword, String motoName){
        SearchForm condition = new SearchForm();
        condition.setKeyword(keyword); //Honda
        
        List<Motorcycle> motorcycles = service.getMotos(condition);//テスト対象
        assertThat(motorcycles.size()).isGreaterThanOrEqualTo(1);
        for (Motorcycle moto : motorcycles) {
            assertThat(moto.getMotoName()).isEqualTo(motoName);
        }

    }
    @DisplayName("バイク一覧取得 条件:バイク名 該当なし")
    @Test
    void test005(){
        SearchForm condition = new SearchForm();
        condition.setKeyword("存在しないバイク名"); //Honda
        
        List<Motorcycle> motorcycles = service.getMotos(condition);//テスト対象
        assertThat(motorcycles.size()).isEqualTo(0);
        }


    @DisplayName("バイク一覧取得 条件:ブランドID,パイク名")
    @ParameterizedTest
    @CsvSource({"02 ,Z900RS, Z900RS", "03, R1, YZF-R1", "01, bel, Rebel"})
    void test006(String brandId, String keyword, String motoName){
        SearchForm condition = new SearchForm();
        condition.setBrandId(brandId);
        condition.setKeyword(keyword);
        
        List<Motorcycle> motorcycles = service.getMotos(condition);//テスト対象
        assertThat(motorcycles.size()).isGreaterThanOrEqualTo(1);
        for (Motorcycle moto : motorcycles) {
            assertThat(moto.getMotoName()).startsWith(motoName);
        }

    }

    @DisplayName("バイク一覧取得 条件: ブランドID, バイク名 該当なし")
    @ParameterizedTest
    @CsvSource({"01, Z900RS", "03, R99"})
    void test007(String brandId, String keyword){
        SearchForm condition = new SearchForm();
        condition.setBrandId(brandId);
        condition.setKeyword(keyword);
        
        List<Motorcycle> motorcycles = service.getMotos(condition);//テスト対象
        assertThat(motorcycles.size()).isEqualTo(0);
        }

    @DisplayName("バイク一覧取得 条件: なし 全件該当")
    @Test
    void test008(){
        SearchForm condition = new SearchForm();

        List<Motorcycle> motorcycles = service.getMotos(condition);//テスト対象
        assertThat(motorcycles.size()).isEqualTo(9);
        }

    @DisplayName("バイク一覧取得 条件: バイク番号")
    @ParameterizedTest
    @CsvSource({"1, GB350", "3, W800 CAFE"})
        void test009(int motoNo, String motoName){
        
        Motorcycle motorcycles = service.getMotos(motoNo);//テスト対象
        assertThat(motorcycles.getMotoName()).isEqualTo(motoName);
        }

    @DisplayName("バイク一覧取得 条件: バイク番号 全項目確認")
    @Test
    void test010(){

        Motorcycle motorcycles = service.getMotos(1);//テスト対象
        assertThat(motorcycles.getMotoNo()).isEqualTo(1);
        assertThat(motorcycles.getMotoName()).isEqualTo("GB350");
        assertThat(motorcycles.getSeatHeight()).isEqualTo(800);
        assertThat(motorcycles.getCylinder()).isEqualTo(1);
        assertThat(motorcycles.getCooling()).isEqualTo("空冷");
        assertThat(motorcycles.getPrice()).isEqualTo(550000);
        assertThat(motorcycles.getComment()).isEqualTo("Yamahaの代表的なスポーツバイク");
        assertThat(motorcycles.getBrand().getBrandId()).isEqualTo("01");
        assertThat(motorcycles.getVersion()).isEqualTo(1);
        // assertThat(motorcycles.getInsDt().format(dtFormatter)).isEqualTo(LocalDateTime.now().format(dtFormatter));
        assertThat(motorcycles.getUpdDt()).isNull();
        }

    @DisplayName("バイク一覧取得 条件: バイク番号 全項目確認")
    @Test
    @Transactional
    @Rollback
    void test011(){

        Motorcycle before = service.getMotos(1);
        before.setMotoName("motomoto");

        service.save(before);

        Motorcycle after = service.getMotos(1); // 変更後のバイク情報取得
        assertThat(after.getMotoName()).isEqualTo("motomoto");
        assertThat(after.getVersion()).isEqualTo(before.getVersion() + 1);

        
        }


    @DisplayName("バイク情報登録")
    @Test
    @Transactional
    @Rollback        
    void test012(){

        Motorcycle before = new Motorcycle();

        before.setMotoName("motomoto");
        before.setSeatHeight(10);
        before.setCylinder(9);
        before.setCooling("必殺");
        before.setPrice(1000);
        before.setComment("OK");
        before.setBrand(new Brand("01", "Honda"));
        
        service.save(before); //登録(保存)



        Motorcycle after = service.getMotos(10); // 変更後のバイク情報取得
        assertThat(after.getMotoNo()).isEqualTo(10);
        assertThat(after.getMotoName()).isEqualTo("motomoto");
        assertThat(after.getSeatHeight()).isEqualTo(10);
        assertThat(after.getCylinder()).isEqualTo(9);
        assertThat(after.getCooling()).isEqualTo("必殺");
        assertThat(after.getPrice()).isEqualTo(1000);
        assertThat(after.getComment()).isEqualTo("OK");
        assertThat(after.getBrand().getBrandId()).isEqualTo("01");
        assertThat(after.getVersion()).isEqualTo(1);
        assertThat(after.getInsDt().format(dtFormatter)).isEqualTo(LocalDateTime.now().format(dtFormatter));
        assertThat(after.getUpdDt()).isNull();

        
        }





}