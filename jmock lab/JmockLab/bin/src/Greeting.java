package src;

public class Greeting {
	  //we have to define GreetingTime as an interface
    //I am goint to explain it in the later
    private GreetingTime gt;
     public void setGreetingTime(GreetingTime gt){
           this.gt = gt;
    }

    public String sayHello(String name){
           String greeting = gt.getGreeting();
           return greeting+","+name;  
    }
}
