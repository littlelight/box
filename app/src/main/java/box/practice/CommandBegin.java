package box.practice;

import box.practice.Database.DBStatus;


public class CommandBegin implements Command<DBStatus> {
    public DBStatus executor() {
        return DBStatus.DB_GOOD;
    }

    public DBStatus undo() {
        return DBStatus.DB_GOOD;
    }
}
