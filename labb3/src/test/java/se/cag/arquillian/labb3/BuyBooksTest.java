package se.cag.arquillian.labb3;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class BuyBooksTest {

    @Inject
    private Cart cart;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClass(Book.class)
                .addClass(Cart.class);
    }

    @Test
    public void buyBooks() {
        cart.addBook(new Book("A wonderful world", "James Newton", 100));
        Assert.assertEquals(100, cart.getTotalPrice());
    }
}
