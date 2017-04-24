package src;

//import some necessary classes from the package of JUnit4
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
//import some necessary classes from the package of JMock2.2
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Expectations;
@RunWith(JMock.class)
public class TestJMockCaseUsingJMock{
      //create the context for the mock object
      Mockery context = new JUnit4Mockery();

      @Test
       public void testSayHello()
      {
           //Mock the GreetingTime class using the technology of reflection
           //you have to define it as a final variable
           //since it is going to be used in a inner class
           final GreetingTime gt = context.mock(GreetingTime.class);
           Greeting g = new Greeting();
            g.setGreetingTime(gt);

           //set the expection for the mock object
           context.checking(new Expectations(){{
                 //the mock object will call the getGreeting method once
                //and we assume that is returns “Good afternoon”
                one(gt).getGreeting(); will(returnValue("Good afternoon"));
            }});

           String out = g.sayHello("wu cao");
           //compare the result and expected value
           assertEquals("Good afternoon,wu cao",out);
       }
}