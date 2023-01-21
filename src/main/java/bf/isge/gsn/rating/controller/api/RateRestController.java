package bf.isge.gsn.rating.controller.api;

import bf.isge.gsn.rating.dto.CreateRateDTO;
import bf.isge.gsn.rating.exception.RateNotExistException;
import bf.isge.gsn.rating.model.Rate;
import bf.isge.gsn.rating.service.RateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rate")
public class RateRestController {
    private RateService rateService;

    public RateRestController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping
    public Rate createRate(@RequestBody CreateRateDTO rate){
        return rateService.createRate(rate);
    }

    @GetMapping
    public List<Rate> rateList(){
        return rateService.rateList();
    }
    @GetMapping("/{id}")
    public Rate getRate(@PathVariable int id){
        return rateService.getById(id);
    }
    @PutMapping("/{id}")
    public void updateRate(@PathVariable int id, @RequestBody CreateRateDTO rate) throws RateNotExistException {
        rateService.updateRate(id, rate);

    }
    @DeleteMapping("/{id}")
    public void deleteRate(@PathVariable int id){
        rateService.deleteById(id);
    }

}
