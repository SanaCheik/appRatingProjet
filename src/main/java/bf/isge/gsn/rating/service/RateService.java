package bf.isge.gsn.rating.service;

import bf.isge.gsn.rating.dto.CreateRateDTO;
import bf.isge.gsn.rating.exception.RateNotExistException;
import bf.isge.gsn.rating.model.Rate;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RateService {

    Rate createRate (CreateRateDTO rate) ;
    void deleteById (int id);
    void updateRate(int id, CreateRateDTO rate) throws RateNotExistException;
    List <Rate> rateList();
    Rate getById(int id);

}
