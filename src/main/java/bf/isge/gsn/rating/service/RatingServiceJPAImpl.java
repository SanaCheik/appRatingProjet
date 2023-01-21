package bf.isge.gsn.rating.service;

import bf.isge.gsn.rating.dto.CreateRatingDTO;
import bf.isge.gsn.rating.exception.RatingNotExistException;
import bf.isge.gsn.rating.model.Rating;
import bf.isge.gsn.rating.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceJPAImpl implements RatingService {
    private RatingRepository ratingRepository;

    public RatingServiceJPAImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(CreateRatingDTO ratingTDO) {
        Rating rate = new Rating();
        rate.setDescription(ratingTDO.getDescription());
        rate.setDenomination(ratingTDO.getDenomination());

        return ratingRepository.save(rate);
    }

    @Override
    public void deleteById(int id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public void updateRating(int id, CreateRatingDTO ratingDTO) throws RatingNotExistException {
        if (!ratingRepository.existsById(id)) {
            throw new RatingNotExistException();
        }
        //Get rating to dataBase
        Rating rating = ratingRepository.findById(id).orElse(null);

        //Update the two colum
        rating.setDescription(ratingDTO.getDescription());
        rating.setDenomination(ratingDTO.getDenomination());

        ratingRepository.save(rating);
    }

    @Override
    public List<Rating> ratingList() {

        List<Rating> ratingList = new ArrayList<>();
        for (Rating rating : ratingRepository.findAll()) {
            ratingList.add(rating);
        }
        return ratingList;
    }

    @Override
    public Rating getById(int id) {
        return ratingRepository.findById(id).orElse(null);
    }
}
