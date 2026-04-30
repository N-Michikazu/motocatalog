package jp.co.planaria.sample.motocatalog.controllers;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Generated;
import jp.co.planaria.sample.motocatalog.beans.Brand;
import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.beans.SearchForm;
import jp.co.planaria.sample.motocatalog.services.MotosService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MotosController {

    @Autowired
    MotosService service;

    // private static final Logger log = LoggerFactory.getLogger(MotosController.class);

    @RequestMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }

    /**
     * 
     * 
     * @param searchForm 検索条件
     * @param model
     * @return
     */


    @GetMapping("/motos")
    public String motos(@Validated SearchForm searchForm, BindingResult result, Model model) {
        log.info("SearchForm: {}", searchForm);
        if (result.hasErrors()){
            //入力チェックエラーがある場合
            return "moto_list";
        }

        //ブランドリストを準備
        this.setBrands(model);

        List<Motorcycle> motorcycles = new ArrayList<>();
        motorcycles = service.getMotos(searchForm);

        model.addAttribute("motos", motorcycles);
        model.addAttribute("datetime", LocalDateTime.now());


        log.debug("motos: {}", motorcycles);

        return "moto_list";
    }


    /**
     * 検索条件をクリアする
     * @param searchForm　検索条件
     * @param model モデル
     * @return  
     */
    @GetMapping("/motos/reset")
    public String reset(SearchForm searchForm, Model model){

        this.setBrands(model);


        searchForm = new SearchForm();
        return "moto_list";
    }
    @GetMapping("/motos/{motoNo}")
    public String initUpdate(Model model){
           //ブランドリストを準備
        this.setBrands(model);
        return "moto";
        
    }
        
    /**
     * ブランドリストをモデルにセットする
     * @param model
     */

    private void setBrands(Model model) {
        List<Brand> brands = new ArrayList<>();
        brands = service.getBrands();
        model.addAttribute("brands", brands);
}


        // //ブランド
        // List<Brand> brands = new ArrayList<>();
        
        // brands.add(new Brand("01", "Honda"));
        // brands.add(new Brand("02", "Kawasaki"));
        // brands.add(new Brand("03", "YAMAHA"));
        // brands.add(new Brand("04", "SUZUKI"));  

}