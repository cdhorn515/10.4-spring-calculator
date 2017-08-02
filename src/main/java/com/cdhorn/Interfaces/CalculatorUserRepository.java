package com.cdhorn.Interfaces;

import com.cdhorn.Models.CalculatorUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorUserRepository extends CrudRepository<CalculatorUser, Long> {
}
