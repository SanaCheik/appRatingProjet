package bf.isge.gsn.rating.service;

import bf.isge.gsn.rating.dto.CreateRatingDTO;
import bf.isge.gsn.rating.exception.RatingNotExistException;
import bf.isge.gsn.rating.model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    Rating createRating (CreateRatingDTO rating) ;
    void deleteById (int id);
    void updateRating(int id, CreateRatingDTO rating) throws RatingNotExistException;
    List <Rating> ratingList();
    Rating getById(int id);

}
