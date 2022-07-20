package yanghgri.protectair.ProtectAirApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirController {
    @GetMapping("/air")
    public String air() {
        return "air";
    }
}
