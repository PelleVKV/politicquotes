package com.politic.qoutes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.politic.qoutes.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
