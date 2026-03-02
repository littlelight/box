package box.practice;

import box.practice.Database.DBStatus;

public class CommandNumEqualTo implements Command<String> {
    private String key;
    private Database db;

    public CommandNumEqualTo(Database db, String key) {
        this.db = db;
        this.key = key;
    }
    public String executor() {
        String count = "";
        try {
            count = String.valueOf(db.dbNumEqualTo(key));
            return count;
        } catch (RuntimeException e) {
            return DBStatus.DB_NOT_FOUND.toString();
        }
    }

    public String undo() {
        return DBStatus.DB_GOOD.toString();
    }
    
}
