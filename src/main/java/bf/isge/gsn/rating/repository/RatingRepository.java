package bf.isge.gsn.rating.repository;

import bf.isge.gsn.rating.model.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating,Integer> {
}
