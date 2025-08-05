package senac.father.advice.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import senac.father.advice.domain.model.Advice;
import senac.father.advice.domain.repository.AdviceRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class AdviceRepositoryImpl implements AdviceRepository {

    private final List<Advice> advices;
    private final ObjectMapper mapper;

    public AdviceRepositoryImpl(final ObjectMapper objectMapper) {
        this.mapper = objectMapper;
        this.advices = new CopyOnWriteArrayList<>();
        loadAdvicesFromJson();
    }

    @Override
    public List<Advice> findAll() {
        return new ArrayList<>(advices);
    }

    private void loadAdvicesFromJson() {
        try {
            final ClassPathResource resource = new ClassPathResource("advices.json");
            try (InputStream inputStream = resource.getInputStream()) {
                final List<Advice> loadedAdvices = mapper.readValue(inputStream, new TypeReference<>() { });
                advices.addAll(loadedAdvices);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Erro ao carregar conselhos do arquivo JSON", exception);
        }
    }
}
