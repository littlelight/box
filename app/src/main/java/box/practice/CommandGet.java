package box.practice;

import box.practice.Database.DBStatus;

public class CommandGet implements Command<String> {
    private String key;
    private Database db;

    public CommandGet(Database db, String key) {
        this.db = db;
        this.key = key;
    }
    public String executor() {
        String value = "";
        try {
            value = db.dbGet(key);
            return value;
        } catch (RuntimeException e) {
            return DBStatus.DB_NOT_FOUND.toString();
        }
    }

    public String undo() {
        return DBStatus.DB_GOOD.toString();
    }
    
}
