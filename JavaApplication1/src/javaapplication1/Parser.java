/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;


public class Parser {

    private Patterns _parsePatterns;

    public Parser(Patterns patterns) {
        _parsePatterns = patterns;
    }

    public List<ParserResult> parse(String inputString) {
        InputTokens inputStringTokens = InputTokens.tokenize(inputString);
        List<ParserResult> result = _parsePatterns.test(inputStringTokens);
        return result;
    }
}
