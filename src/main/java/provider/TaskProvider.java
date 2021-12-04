package provider;

import db.MySQL;
import entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskProvider {
    public ArrayList<Task> getAll() throws ClassNotFoundException, SQLException {
        MySQL db = new MySQL();
        db.connect();
        ArrayList<Task> tasks = new ArrayList<>();
        ResultSet resultSet = db.getDataBySQL("SELECT * FROM A00365049tasks");
        while(resultSet.next()){
            tasks.add(new Task(
                    resultSet.getInt(1),
                    resultSet.getString(5),
                    resultSet.getString(3),
                    resultSet.getString(2),
                    resultSet.getInt(4)
            ));
        }
        db.close();
        return tasks;
    }

    public void create(Task task) throws ClassNotFoundException, SQLException {
        MySQL db = new MySQL();
        db.connect();
        String sql = "INSERT INTO A00365049tasks(title, description, statusId, taskDate) VALUES ('%NAME', '%DESCRIPTION', %STATUS, '%DATE')";
        sql = sql.replace("%NAME", task.getTitle());
        sql = sql.replace("%DESCRIPTION",task.getDescription());
        sql = sql.replace("%STATUS",""+1);


        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
        String newDate = df.format(date);
        sql = sql.replace("%DATE",newDate);
        db.commandSQL(sql);
        db.close();
    }

    public void update(Task task) throws SQLException, ClassNotFoundException {
        MySQL db = new MySQL();
        db.connect();
        String sql = "UPDATE A00365049tasks SET statusId = $ID WHERE taskid= $id";

        sql = sql.replace("$id",task.getId()+"");
        sql = sql.replace("$ID",task.getStatusId()+"");

        db.commandSQL(sql);
        db.close();

    }

    public void delete(Task task) throws SQLException, ClassNotFoundException {
        MySQL db = new MySQL();
        db.connect();
        String sql = "DELETE from A00365049tasks WHERE taskid=$id";
        sql = sql.replace("$id", task.getId()+"");
        db.commandSQL(sql);
        db.close();

    }
}
