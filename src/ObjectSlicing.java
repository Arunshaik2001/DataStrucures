

class A{
    int foo=10;

    protected void hello(){
        System.out.println("Hello");
    }
}

class B extends A{

    int bar=232;

}

public class ObjectSlicing {
    public static void main(String[] args) {
        A a = new B();
        a.hello();
    }
}



