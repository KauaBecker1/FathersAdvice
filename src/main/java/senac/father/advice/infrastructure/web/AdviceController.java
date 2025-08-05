package senac.father.advice.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senac.father.advice.application.service.AdviceService;
import senac.father.advice.domain.model.Advice;

import java.util.List;

@RestController
@RequestMapping("/advice")
public class AdviceController {

    private final AdviceService service;

    public AdviceController(final AdviceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Advice>> getAllAdvices() {
        final List<Advice> advices = service.findAllAdvices();
        return ResponseEntity.ok(advices);
    }

}
