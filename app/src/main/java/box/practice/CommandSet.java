package box.practice;

import box.practice.Database.DBStatus;

public class CommandSet implements Command<DBStatus> {
    private String key;
    private String value;
    private String oldValue;
    private Database db;
    public CommandSet(Database db, String key, String value, String oldValue) {
        this.db = db;
        this.key = key;
        this.value = value;
        this.oldValue = oldValue == null ? "" : oldValue;
    }
    
    @Override
    public DBStatus executor() {
        this.oldValue = db.dbGet(key);
        return db.dbSet(key, value);
    }
    
    @Override
    public DBStatus undo() {
        if((this.oldValue.equals("")) {
            return db.dbUnset(key);
        } else {
            return db.dbSet(key, oldValue);
        }
    }
}