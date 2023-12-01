package pl.whattoeat.whattoeat_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.whattoeat.whattoeat_spring.model.MatchPercent;

@RestController
public class MatchPercentController {

    @GetMapping("/matchPercent")
    public int getMatchPercent() {
        return MatchPercent.getMatchPercent();
    }

    @PostMapping("/matchPercent")
    public void setMatchPercent(@RequestBody int matchPercent) {
        MatchPercent.setMatchPercent(matchPercent);
    }
}