package pl.kazmierczak.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class AuthorTest {

    private Author author;

    @Before
    public void setUp() throws Exception {
        author = new Author(1345, "kamil", "kazmierczak");
//        author = new Author(new Long(1), "kamil", "kazmierczak");
    }

    @Test
    public void getId() throws Exception {
        Assert.assertEquals((Integer)1345, author.getId());
    }

    @Test
    public void setId() throws Exception {
        author.setId(5431);
        Assert.assertEquals((Integer)5431, author.getId());
    }

    @Test
    public void getName() throws Exception {
        Assert.assertEquals("kamil", author.getName());
    }

    @Test
    public void setName() throws Exception {
        author.setName("John");
        Assert.assertEquals("John", author.getName());
    }

    @Test
    public void getSurname() throws Exception {
        Assert.assertEquals("kazmierczak", author.getSurname());
    }

    @Test
    public void setSurname() throws Exception {
        author.setSurname("bogdan");
        Assert.assertEquals("bogdan", author.getSurname());
    }

}