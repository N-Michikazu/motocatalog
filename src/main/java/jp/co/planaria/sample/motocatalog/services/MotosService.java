package jp.co.planaria.sample.motocatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.mappers.MotorcycleMapper;

@Service
public class MotosService {
    
    @Autowired
    MotorcycleMapper motorcycleMapper;


    public List<Motorcycle> getMotos(){
        return motorcycleMapper.selectAll();
    }
}
