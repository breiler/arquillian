package se.cag.arquillian.labb3;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class BuyBooksSteps {

    @Inject
    private Cart cart;

    private Map<String, Book> bookMap = new HashMap<String, Book>();

    @Before
    public void reset() {
        bookMap.clear();
    }

    @Given("a book with title \"(.*?)\", author \"(.*?)\" and price (\\d+)")
    public void givenGreetingCreated(String title, String author, int price) {
        Book book = new Book(title, author,  price);
        bookMap.put(title, book);
    }

    @When("customer adds book with title '(.*)' to cart")
    public void whenCustomerAddsBookToCart(String title) {
        if( bookMap.containsKey(title) ) {
            cart.addBook(bookMap.get(title));
        } else {
            throw new EntityNotFoundException("Couldn't find book with title " + title);
        }
    }

    @Then("the total cost for all items in cart is (\\d+)")
    public void thenCartTotalIs(int total) {
        Assert.assertEquals(total, cart.getTotalPrice());
    }

    @Given("^an empty cart$")
    public void givenAnEmptyCart() throws Throwable {
        cart.clear();
    }
}
