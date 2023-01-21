package bf.isge.gsn.rating.controller.web;

import bf.isge.gsn.rating.dto.CreateRatingDTO;
import bf.isge.gsn.rating.service.RatingService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RatingPageController {
    // rating list page
    private RatingService ratingService;

    public RatingPageController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/ratingList")
    public String ratingListPage(Model model) {
        model.addAttribute("ratings", ratingService.ratingList());
        return "ratingList";
    }

    @GetMapping("/addRating")
    public String createRatingPage(Model model) {
        CreateRatingDTO form = new CreateRatingDTO();
        form.setDescription("Non décrit");
        model.addAttribute("ratingForm", form);
        return "addRating";
    }

    @PostMapping("/addRating")
    public String createRatingForm(Model model, @ModelAttribute("ratingForm") CreateRatingDTO ratingForm) {
        if(Strings.isEmpty(ratingForm.getDenomination())) {
            model.addAttribute("errorMessage", "La dénomination est requise");
            return "addRating";
        }
        try {
            ratingService.createRating(ratingForm);
            return "redirect:/ratingList";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Une erreur est survenue lors de la sauvegarde: "+ e.getMessage());
            return "addRating";
        }
    }

}
