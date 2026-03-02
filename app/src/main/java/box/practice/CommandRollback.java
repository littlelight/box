package box.practice;

import box.practice.Database.DBStatus;


public class CommandRollback implements Command<DBStatus> {
    public DBStatus executor(Database db) {
        return DBStatus.DB_GOOD;
    }

    public DBStatus undo(Database db) {
        return DBStatus.DB_GOOD;
    }
    public String getName() {
        return "Rollback";
    }
}
