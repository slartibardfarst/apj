/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.*;


public class InputTokens {

    public String[] Tokens;
    public int CurrPos;

    public InputTokens(String[] src) {
        Tokens = src;
        CurrPos = 0;
    }

    public int getNumTokens() {
        return Tokens.length;
    }
    
    public static InputTokens tokenize(String inputString)
    {
        String[] tokens = inputString.split("\\s+|,\\s*");
        
        InputTokens result = new InputTokens(tokens);
        return result;
    }
}
