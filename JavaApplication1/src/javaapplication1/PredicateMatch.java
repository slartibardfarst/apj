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
public class PredicateMatch {
    public String Name;
    public String[] Tokens;
    
    public PredicateMatch(String name, InputTokens inputTokens, int index, int len)
    {
        Name = name;
        Tokens = Arrays.copyOfRange(inputTokens.Tokens, index, index+len);
    }
}
