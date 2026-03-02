package box.practice;

import box.practice.Database.DBStatus;

import java.util.Stack;

public class Transaction {
    private Database db;
    private Stack<Command<DBStatus>> cmdStack;
    public Transaction(Database db) {
        this.db = db;
        cmdStack = new Stack<>();
    }

    public void record(Command<DBStatus> cmd) {
        cmdStack.push(cmd);
    }

    public void rollback() {
        while(!cmdStack.isEmpty()) {
            Command<DBStatus> cmd = cmdStack.pop();
            cmd.undo(db);
        }
    }
}