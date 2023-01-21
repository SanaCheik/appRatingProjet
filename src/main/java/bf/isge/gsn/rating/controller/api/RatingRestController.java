package bf.isge.gsn.rating.controller.api;

import bf.isge.gsn.rating.dto.CreateRatingDTO;
import bf.isge.gsn.rating.exception.RatingNotExistException;
import bf.isge.gsn.rating.model.Rating;
import bf.isge.gsn.rating.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingRestController {

        private RatingService ratingService;

        public RatingRestController(RatingService ratingService) {
            this.ratingService = ratingService;
        }

        @PostMapping
        public Rating createRating(@RequestBody CreateRatingDTO rating){
            return ratingService.createRating(rating);
        }

        @GetMapping
        public List<Rating> ratingList(){
            return ratingService.ratingList();
        }
        @GetMapping("/{id}")
        public Rating getRating(@PathVariable int id){
            return ratingService.getById(id);
        }
        @PutMapping("/{id}")
        public void updateRating(@PathVariable int id, @RequestBody CreateRatingDTO rating) throws RatingNotExistException {
            ratingService.updateRating(id, rating);

        }
        @DeleteMapping("/{id}")
        public void deleteRating(@PathVariable int id){
            ratingService.deleteById(id);
        }

}
