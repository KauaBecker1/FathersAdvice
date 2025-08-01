package senac.father.advice.domain.repository;

import senac.father.advice.domain.model.Advice;

import java.util.List;

public interface AdviceRepository {

    List<Advice> findAll();

}
