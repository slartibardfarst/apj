/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;

/**
 *
 * @author awatkins
 */
public class Pattern {

    private int _numTokens;
    private List<Predicate> _predicates;

    public Pattern() {
        _predicates = new ArrayList<>();
        _numTokens = 0;
    }

    public Pattern(List<Predicate> predicates) {
        _predicates = new ArrayList<>(predicates);
        _predicates.stream().forEach((p) -> {
            _numTokens += p.getNumTokens();
        });
    }
    
    public int getNumTokens()
    {
        return _numTokens;
    }
    
    public void addPredicate(Predicate p)
    {
        _predicates.add(p);
        _numTokens += p.getNumTokens();
    }

    public ParserResult test(InputTokens input) {
        if (input.getNumTokens() != _numTokens) {
            return null;
        }

        ParserResult result = new ParserResult();
        for (Predicate p : _predicates) {
            PredicateMatch predicateMatch = p.test(input);
            if (null != predicateMatch) {
                result.PatternMatches.add(predicateMatch);
            } else {
                return null;
            }
        }

        return result;
    }
}
