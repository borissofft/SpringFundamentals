package bg.softuni.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @CrossOrigin()
    @GetMapping("/greeting")
    public ResponseEntity<Greeting> greeting() {
        return ResponseEntity.ok(new Greeting().setMessage("Здрасти, банда!"));
    }

}
