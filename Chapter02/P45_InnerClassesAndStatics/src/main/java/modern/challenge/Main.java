package modern.challenge;

public class Main {

    public static void main(String[] args) {
        A a = new A();
        A.B b1 = a.new B();
        A.B b2 = a.new B();
        A.B b3 = a.new B();
        
        System.out.println();
        
        OldConnection oldConn1 = OldConnection.get();
        OldConnection oldConn2 = OldConnection.get();
        OldConnection oldConn3 = OldConnection.get();
        
        System.out.println();
        
        NewConnection newConn1 = NewConnection.get();
        NewConnection newConn2 = NewConnection.get();
        NewConnection newConn3 = NewConnection.get();
    }
}
