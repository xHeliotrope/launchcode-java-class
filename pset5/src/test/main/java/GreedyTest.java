
import com.rmoore8869.greedy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import static org.junit.Assert.assertEquals;

/**
 * rmoore8869
 * 7/12/2014
 */

public class GreedyTest {
    private CoinCalculator coinCalculator;
    private double originalAmount;

    protected void setUpAmerican() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        coinCalculator = (CoinCalculator) context.getBean("AmericanConverter");

    }

    protected void setUpEuropean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        coinCalculator = (CoinCalculator) context.getBean("EuropeanConverter");
    }


    @Test
    public void testZeroChange() throws Exception {
        setUpAmerican();
        originalAmount = 0;
        assertEquals("You receive: no change.", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneQuarter() throws Exception {
        setUpAmerican();
        originalAmount = .25;
        assertEquals("You receive: \n1 : Quarter", coinCalculator.createMessage(originalAmount));

    }

    @Test
    public void testOneHalfDollar() throws Exception {
        setUpAmerican();
        originalAmount = .50;
        assertEquals("You receive: \n1 : Half-Dollar", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneDollar() throws Exception {
        setUpAmerican();
        originalAmount = 1;
        assertEquals("You receive: \n1 : Dollar", coinCalculator.createMessage(originalAmount));
    }
    @Test
    public void testOneDollarNinetyNineCents() throws Exception {
        setUpAmerican();
        originalAmount = 1.99;
        assertEquals("You receive: \n4 : Penny\n2 : Dime\n1 : Quarter\n1 : Half-Dollar" +
                "\n1 : Dollar", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneEuroCent() throws Exception {
        setUpEuropean();
        originalAmount = .01;
        assertEquals("You receive: \n1 : EURO Cent", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneTwoEuroCent() throws Exception {
        setUpEuropean();
        originalAmount = .02;
        assertEquals("You receive: \n1 : EURO 2 Cent", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneFiveEuroCent() throws Exception {
        setUpEuropean();
        originalAmount = .05;
        assertEquals("You receive: \n1 : EURO 5 Cent", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneTenEuroCent() throws Exception {
        setUpEuropean();
        originalAmount = .10;
        assertEquals("You receive: \n1 : EURO 10 Cent", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneTwentyEuroCent() throws Exception {
        setUpEuropean();
        originalAmount = .20;
        assertEquals("You receive: \n1 : EURO 20 Cent", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneFiftyEuroCent() throws Exception {
        setUpEuropean();
        originalAmount = .50;
        assertEquals("You receive: \n1 : EURO 50 Cent", coinCalculator.createMessage(originalAmount));
    }

    @Test
    public void testOneEuro() throws Exception {
        setUpEuropean();
        originalAmount = 1.00;
        assertEquals("You receive: \n1 : EURO", coinCalculator.createMessage(originalAmount));
    }
    @Test
    public void testOneTwoEuro() throws Exception {
        setUpEuropean();
        originalAmount = 2.00;
        assertEquals("You receive: \n1 : 2 EURO", coinCalculator.createMessage(originalAmount));
    }
    @Test
    public void testThreeNinetyNineEuros() throws Exception {
        setUpEuropean();
        originalAmount = 3.99;
        assertEquals("You receive: \n2 : EURO 2 Cent\n1 : EURO 5 Cent\n2 : EURO 20 Cent\n1 : EURO 50 Cent\n1 : EURO" +
                "\n1 : 2 EURO", coinCalculator.createMessage(originalAmount));
    }


}