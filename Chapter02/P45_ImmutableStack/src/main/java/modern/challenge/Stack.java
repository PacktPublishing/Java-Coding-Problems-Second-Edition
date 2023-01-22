package modern.challenge;

public interface Stack<T> extends Iterable<T> {

    boolean isEmpty();
    
    Stack<T> push(T value);

    Stack<T> pop();
    
    T peek();    
}
