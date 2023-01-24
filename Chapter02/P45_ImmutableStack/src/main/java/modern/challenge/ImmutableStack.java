package modern.challenge;

import java.util.Iterator;

public class ImmutableStack<E> implements Stack<E> {

    private final E head;
    private final Stack<E> tail;

    private ImmutableStack(final E head, final Stack<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    public static <U> Stack<U> empty(final Class<U> type) {
        return new EmptyStack<>();
    }

    @Override
    public Stack<E> push(E e) {
        return new ImmutableStack<>(e, this);
    }

    @Override
    public Stack<E> pop() {
        return this.tail;
    }    

    @Override
    public E peek() {
        return this.head;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator<>(this);
    }

    private static class StackIterator<U> implements Iterator<U> {

        private Stack<U> stack;

        public StackIterator(final Stack<U> stack) {
            this.stack = stack;
        }

        @Override
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        @Override
        public U next() {

            U e = this.stack.peek();
            this.stack = this.stack.pop();

            return e;
        }

        @Override
        public void remove() {
        }
    }

    private static class EmptyStack<U> implements Stack<U> {

        @Override
        public Stack<U> push(U u) {
            return new ImmutableStack<>(u, this);
        }

        @Override
        public Stack<U> pop() {
            throw new UnsupportedOperationException("Unsupported operation on an empty stack");
        }       

        @Override
        public U peek() {
            throw new UnsupportedOperationException ("Unsupported operation on an empty stack");
        }
        
        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public Iterator<U> iterator() {
            return new StackIterator<>(this);
        }
    }
}
