/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import static java.lang.System.console;
import java.util.*;

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello");

        //int i = takingMethod((String s) -> return 33);
        Runnable r = () -> System.out.println("hello lambda!");
        r.run();

        Predicate city_1 = new Predicate("city", (s) -> s.matches("\\w+"));
        Predicate city_2 = new Predicate("city", (s, t) -> s.matches("\\w+") && t.matches("\\w+"));
        Predicate zip = new Predicate("zip", s -> s.matches("\\d{5,5}"));

        InputTokens it = InputTokens.tokenize("foo bar, baz, 90210");

        PredicateMatch r1 = city_1.test(it);
        PredicateMatch r2 = city_2.test(it);
        PredicateMatch r3 = zip.test(it);

        Pattern pat1 = new Pattern();
        pat1.addPredicate(city_1);
        pat1.addPredicate(zip);

        Pattern pat2 = new Pattern();
        pat2.addPredicate(city_2);
        pat2.addPredicate(zip);

        InputTokens it2 = new InputTokens(new String[]{"Beverly", "Hills", "90210"});
        ParserResult result = pat2.test(it2);
        //System.out.println(f.apply("ggg"));
    }

    public static Patterns SetupTestPatterns() {
        Predicate unit_2 = new Predicate("unit", (s, t) -> s.matches("?i:unit") && t.matches("\\d+"));

        Predicate street_no_1 = new Predicate("street_no", s -> s.matches("\\d+"));

        Predicate street_name_1 = new Predicate("street_name", s -> s.matches("\\w+"));

        Predicate street_suffix_1 = new Predicate("street_suffix", s -> s.matches("?i:street|st|avenue|ave"));

        Predicate postDirectional_1 = new Predicate("postdirectional", s -> s.matches("?i:N|E|W|S"));

        Predicate city_1 = new Predicate("city", (s) -> s.matches("\\w+"));
        Predicate city_2 = new Predicate("city", (s, t) -> s.matches("\\w+") && t.matches("\\w+"));

        Predicate state_1 = new Predicate("state", (s) -> s.matches("\\w{2"));

        Predicate zip_1 = new Predicate("zip", s -> s.matches("\\d{5,5}"));

        Pattern p1 = new Pattern();
        p1.addPredicate(street_no_1);
        p1.addPredicate(street_name_1);
        p1.addPredicate(street_suffix_1);
        p1.addPredicate(city_1);
        p1.addPredicate(state_1);
        p1.addPredicate(zip_1);
        
        Patterns result = new Patterns();
        result.addPattern(p1);
        
        return result;
    }
}
