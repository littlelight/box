public interface Command<T> {
    public T executor();
    public T undo();
}