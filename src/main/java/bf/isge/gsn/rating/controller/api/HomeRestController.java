package bf.isge.gsn.rating.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeRestController {

    @GetMapping
    public String welcome(){
        return  "Welcome on rating rest api!";
    }
}
