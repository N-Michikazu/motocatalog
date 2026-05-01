package jp.co.planaria.sample.motocatalog.services;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.planaria.sample.motocatalog.beans.Brand;
import jp.co.planaria.sample.motocatalog.beans.Motorcycle;
import jp.co.planaria.sample.motocatalog.beans.SearchForm;
import jp.co.planaria.sample.motocatalog.mappers.MotorcycleMapper;
import jp.co.planaria.sample.motocatalog.mappers.BrandMappers;

@Service
public class MotosService {
    @Autowired
    MessageSource messageSource;

    @Autowired
    MotorcycleMapper motorcycleMapper;

    @Autowired
    BrandMappers brandMapper;


    public List<Motorcycle> getMotos(SearchForm condition) {
        return motorcycleMapper.selectByCondition(condition);
    }

    public Motorcycle getMotos(int motoNo){
        return motorcycleMapper.selectByPK(motoNo);
    }

    public List<Brand> getBrands() {
        return brandMapper.selectAll();
    }
    /**
     * バイク情報保存
     * @param motorcycle バイク情報
     * @return　保存件数
     */

    public int save(Motorcycle motorcycle) {
        if (motorcycle.getMotoNo() == null) {
        //登録
            return this.add(motorcycle);
        } else {
        //更新
            return this.update(motorcycle);
        }
    }






        /**
     * バイク情報を更新する
     * @param moto バイク情報
     * @return 更新件数
     */
    @Transactional
    private int update(Motorcycle motorcycle) {
        int cnt = motorcycleMapper.update(motorcycle);
        //更新されなかった場合更新されたか削除されたため楽観的排他エラーとする
        if (cnt == 0){
            throw new OptimisticLockingFailureException(
                messageSource.getMessage("error.OptimisticLockingFailure", 
                null, Locale.JAPANESE));
        }
        //2件以上更新は想定外(SQLの不備の可能性)
        if (cnt >  1){
            throw new RuntimeException(
                messageSource.getMessage
                ("error.Runtime", 
                new String[] {"二件以上更新されました。"}, Locale.JAPANESE ));
        }
        return cnt;
    }

    
    /**
     * バイク情報を登録する
     * @param moto バイク情報
     * @return 登録件数
     */
    @Transactional
    private int add(Motorcycle motorcycle) {
        //新しいバイク番号を発行
        Integer motoNo = motorcycleMapper.selectNewMotoNo();
        motorcycle.setMotoNo(motoNo);
        //バイク情報を登録
        int cnt = motorcycleMapper.insert(motorcycle);
        //登録されなかった場合登録されたか削除されたため楽観的排他エラーとする
        if (cnt == 0){
            throw new RuntimeException(
                messageSource.getMessage("error.Runtime", 
                new String[] {"登録に失敗しました"}, Locale.JAPANESE ));
        }
        return cnt;
    }

    /**
     * バイク情報を削除する
     * @param moto バイク情報
     * @return 削除件数
     */
    @Transactional
    public int delete(Motorcycle motorcycle) {
        int cnt = motorcycleMapper.delete(motorcycle);
        //削除されなかった場合削除されたか削除されたため楽観的排他エラーとする
        if (cnt == 0){
            throw new OptimisticLockingFailureException(
                messageSource.getMessage("error.OptimisticLockingFailure", 
                null, Locale.JAPANESE));
        }
        //2件以上削除は想定外(SQLの不備の可能性)
        if (cnt >  1){
            throw new RuntimeException(
                messageSource.getMessage
                ("error.Runtime", 
                new String[] {"二件以上削除されました。"}, Locale.JAPANESE ));
        }
        return cnt;
    }

}