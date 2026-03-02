package box.practice;
public interface Command<T> {
    public T executor(Database db);
    public T undo(Database db);
    public String getName();
}