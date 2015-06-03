package se.cag.arquillian.labb2;

import javax.inject.Inject;
import java.io.PrintStream;

public class Greeter {

    private se.cag.arquillian.labb2.PhraseBuilder phraseBuilder;

    @Inject
    public Greeter(se.cag.arquillian.labb2.PhraseBuilder phraseBuilder) {
        this.phraseBuilder = phraseBuilder;
    }

    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return phraseBuilder.buildPhrase("hello", name);
    }
}
