package yanghgri.worldclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yanghgri.worldclock.service.WorldClockService;

import java.util.Map;

@RestController
public class WorldClockController {
    private final WorldClockService worldClockService;

    @Autowired
    public WorldClockController(WorldClockService worldClockService) {
        this.worldClockService = worldClockService;
    }


    @GetMapping("show")
    public Map<String, String> show() {
        return worldClockService.show();
    }
}