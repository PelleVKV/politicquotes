package com.politic.qoutes.controller;

import com.politic.qoutes.model.Quote;
import com.politic.qoutes.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }

    // GET all quotes
    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    // GET a quote by ID
    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long id) {
        Quote quote = quoteService.getQuoteById(id);
        if (quote == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    // POST to add a new quote
    @PostMapping
    public Quote addQuote(@RequestBody Quote quote) {
        return quoteService.addQuote(quote);
    }

    // DELETE a quote
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
