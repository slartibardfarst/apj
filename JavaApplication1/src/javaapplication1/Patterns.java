package javaapplication1;

import java.util.*;

public class Patterns {
    private List<Pattern> _pattern;

    public Patterns() {
        _pattern = new ArrayList<>();
    }
    
    public void addPattern(Pattern p)
    {
        _pattern.add(p);
    }

    public List<ParserResult> test(InputTokens inputTokens) {
        List<ParserResult> result = null;

        for (Pattern pattern : _pattern) {
            ParserResult patternResult = pattern.test(inputTokens);
            if (null != patternResult) {
                if(null == result)
                    result = new ArrayList<>();
                
                result.add(patternResult);
            }
        }

        return result;
    }
}
