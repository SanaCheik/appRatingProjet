package bf.isge.gsn.rating.service;

import bf.isge.gsn.rating.dto.CreateRateDTO;
import bf.isge.gsn.rating.exception.RateNotExistException;
import bf.isge.gsn.rating.model.Rate;
import bf.isge.gsn.rating.model.Rating;
import bf.isge.gsn.rating.repository.RateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RateServiceJPAImpl implements RateService {
    private RateRepository rateRepository;
    private RatingService ratingService;

    public RateServiceJPAImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public Rate createRate(CreateRateDTO rateTDO) {
        Rate rate = new Rate();
        rate.setNote(rateTDO.getNote());
        rate.setComment(rateTDO.getComment());
        rate.setCritere(rateTDO.getCritere());

        return rateRepository.save(rate);
    }

    @Override
    public void deleteById(int id) {
        rateRepository.deleteById(id);
    }

    @Override
    public void updateRate(int id, CreateRateDTO rateDTO) throws RateNotExistException {
        if (!rateRepository.existsById(id)) {
            throw new RateNotExistException();
        }
        //Get rate to dataBase
        Rate rate = rateRepository.findById(id).orElse(null);

        //Update the 3 colum
        rate.setNote(rateDTO.getNote());
        rate.setComment(rateDTO.getComment());
        rate.setCritere(rateDTO.getCritere());

        rateRepository.save(rate);
    }

    @Override
    public List<Rate> rateList() {

        List<Rate> rateList = new ArrayList<>();
        for (Rate rate : rateRepository.findAll()) {
            rateList.add(rate);
        }
        return rateList;
    }

    @Override
    public Rate getById(int id) {
        return rateRepository.findById(id).orElse(null);
    }
}
