package box.practice;

import box.practice.Database.DBStatus;

public class CommandGet implements Command<DBStatus> {
    private String key;
    private String res;

    public CommandGet(String key) {
        this.key = key;
        this.res = "";
    }
    public DBStatus executor(Database db) {
        try {
            res = db.dbGet(key);
            System.out.println("> " + (res.equals("") ? "NULL" : res));
            return DBStatus.DB_GOOD;
        } catch (RuntimeException e) {
            System.out.println("> NULL");
            return DBStatus.DB_NOT_FOUND;
        }
    }

    public DBStatus undo(Database db) {
        return DBStatus.DB_GOOD;
    }

    public String getResult() {
        return this.res;
    }
    public String getName() {
        return "GET";
    }   
}
