package box.practice;

import box.practice.Database.DBStatus;

public class CommandUnset implements Command<DBStatus>{
    private String key;
    private String oldValue;
    public CommandUnset(String key) {
        this.key = key;
    }
    
    @Override
    public DBStatus executor(Database db) {
        this.oldValue = db.dbGet(key);
        return db.dbUnset(key);
    }
    
    @Override
    public DBStatus undo(Database db) {
        if(!this.oldValue.equals("")) {
            return db.dbSet(key, oldValue);
        } else {
            return DBStatus.DB_GOOD;
        }
    }
    
}



