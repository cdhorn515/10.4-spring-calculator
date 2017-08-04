package com.cdhorn.Interfaces;


import com.cdhorn.Models.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

    Iterable<Operation> findAllByCalculatoruser(String calculatoruser);
}
