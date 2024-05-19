package ch.zhaw.deeplearningjava.playground;

// Imports für die Definition von HTTP-Endpoints
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// Import für die Verarbeitung von Datei-Uploads
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ClassificationController {

    // Instanzvariable für Durchführung der Bildklassifikation
    private Inference inference = new Inference();

    // Ping-Endpunkt
    @GetMapping("/ping")
    public String ping() {
        return "Classification app is up and running!";
    }

    // POST-Request für Bildklassifikation in JSON-Format
    @PostMapping(path = "/analyze")
    public String predict(@RequestParam("image") MultipartFile image) throws Exception {
        System.out.println(image);
        return inference.predict(image.getBytes()).toJson();
    }

}