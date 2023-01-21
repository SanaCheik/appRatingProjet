package bf.isge.gsn.rating.controller.web;

import bf.isge.gsn.rating.dto.CreateRateDTO;
import bf.isge.gsn.rating.service.RateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.EmptyStackException;

@Controller
public class RatePageController {
    // rating list page
    private RateService rateService;

    public RatePageController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("/rateList")
    public String rateListPage(Model model) {
        model.addAttribute("rates", rateService.rateList());
        return "rateList";
    }

    @GetMapping("/addRate")
    public String createRatePage(Model model) {
        CreateRateDTO form = new CreateRateDTO();
        form.setComment("Pas de commentaire");
        model.addAttribute("rateForm", form);
        return "addRate";
    }

    @PostMapping("/addRate")
    public String createRateForm(Model model, @ModelAttribute("rateForm") CreateRateDTO rateForm) {
        if(rateForm.getNote() > 6 ) {
            model.addAttribute("errorMessage", "La note est requise");
            return "addRating";
        }
        try {
            rateService.createRate(rateForm);
            return "redirect:/rateList";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Une erreur est survenue lors de la sauvegarde: "+ e.getMessage());
            return "addRate";
        }
    }

}
