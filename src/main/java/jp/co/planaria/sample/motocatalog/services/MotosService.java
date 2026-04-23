package jp.co.planaria.sample.motocatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.planaria.sample.motocatalog.beans.Brand;
import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.beans.SearchConditon;
import jp.co.planaria.sample.motocatalog.mappers.MotorcycleMapper;
import jp.co.planaria.sample.motocatalog.mappers.BrandMapper;

@Service
public class MotosService {
    
    @Autowired
    MotorcycleMapper motorcycleMapper;

    @Autowired
    BrandMapper brandMapper;


    public List<Motorcycle> getMotos(SearchConditon condition){
        return motorcycleMapper.selectByCondition(condition);
    }

    public List<Brand> getBrands() {
        return brandMapper.selectAll();
    }
}