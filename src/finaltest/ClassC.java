package finaltest;

public class ClassC implements InterfaceA, InterfaceB {
	   public void methodA() {   System.out.println("ClassC, methodA");  }
	   public void methodB() {   System.out.println("ClassC, methodB");   }
	   
	   public void methodX() {
		   InterfaceB.super.methodX();
	   }
}
