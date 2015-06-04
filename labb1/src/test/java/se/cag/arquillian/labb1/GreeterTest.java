package se.cag.arquillian.labb1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class GreeterTest {

    @Mock
    private PhraseBuilder phraseBuilder;

    private Greeter greeter;

    @Before
    public void setUp() {
        initMocks(this);
        when(phraseBuilder.buildPhrase(eq("hello"), anyString())).thenReturn("Hello, Earthling!");
        greeter = new Greeter(phraseBuilder);
    }

    @Test
    public void shouldCreateGreeting() {
        Assert.assertEquals("Hello, Earthling!", greeter.createGreeting("Earthling"));
    }
}