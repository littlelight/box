package box.practice;

import box.practice.Database.DBStatus;

public class CommandUnset implements Command<DBStatus>{
    private String key;
    private String oldValue;
    private Database db;
    public CommandUnset(Database db, String key) {
        this.db = db;
        this.key = key;
    }
    
    @Override
    public DBStatus executor() {
        this.oldValue = db.dbGet(key);
        return db.dbUnset(key);
    }
    
    @Override
    public DBStatus undo() {
        if(!this.oldValue.equals("")) {
            return db.dbSet(key, oldValue);
        } else {
            return DBStatus.DB_GOOD;
        }
    }
    
}



