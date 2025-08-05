package senac.father.advice.application.service;

import org.springframework.stereotype.Service;
import senac.father.advice.domain.model.Advice;
import senac.father.advice.domain.repository.AdviceRepository;

import java.util.List;

@Service
public class AdviceService {

    private final AdviceRepository repository;

    public AdviceService(final AdviceRepository repository) {
        this.repository = repository;
    }

    public List<Advice> findAllAdvices() {
        return repository.findAll();
    }

}
