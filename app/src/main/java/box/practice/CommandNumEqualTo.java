package box.practice;

import box.practice.Database.DBStatus;

public class CommandNumEqualTo implements Command<DBStatus> {
    private String key;
    private int res;

    public CommandNumEqualTo(String key) {
        this.key = key;
        this.res = 0;
    }
    public DBStatus executor(Database db) {
        try {
            res = db.dbNumEqualTo(key);
            return DBStatus.DB_GOOD;
        } catch (RuntimeException e) {
            return DBStatus.DB_NOT_FOUND;
        }
    }

    public DBStatus undo(Database db) {
        return DBStatus.DB_GOOD;
    }

    public int getResult() {
        return res;
    }
    
}
