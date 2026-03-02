package box.practice;

import box.practice.Database.DBStatus;

public class CommandSet implements Command<DBStatus> {
    private String key;
    private String value;
    private String oldValue;
    public CommandSet(String key, String value) {
        this.key = key;
        this.value = value;
        this.oldValue = "";
    }
    
    @Override
    public DBStatus executor(Database db) {
        this.oldValue = db.dbGet(key);
        return db.dbSet(key, value);
    }
    
    @Override
    public DBStatus undo(Database db) {
        if(this.oldValue.equals("")) {
            return db.dbUnset(key);
        } else {
            return db.dbSet(key, oldValue);
        }
    }

    public String getName() {
        return "SET";
    }
}