package am.basic.jdbcStart.repository;

import am.basic.jdbcStart.model.Note;
import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteRepasitory {
    private DataSource dataSource;

    public NoteRepasitory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(Note note) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into note VALUES(0,?,?,?)");
        preparedStatement.setString(1, note.getHeading());
        preparedStatement.setString(2, note.getText());
        preparedStatement.setInt(3, note.getUser_id());
        int result = preparedStatement.executeUpdate();
    }

    public void update(Note note) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  note SET  heading = ?, text = ? WHERE id  = ?");
        preparedStatement.setString(1, note.getHeading());
        preparedStatement.setString(2, note.getText());
        preparedStatement.setInt(3, note.getId());
        preparedStatement.execute();
        preparedStatement.close();
    }
    public List<Note> getAll() throws SQLException {
        List<Note> notes = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("Select * FROM note ");
        while (resultSet.next()) {
            Note note = fromResultSet(resultSet);
            notes.add(note);
        }
        resultSet.close();
        return notes;
    }

    public List<Note> findByHeading(String heading) throws SQLException {
        List<Note> notes = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("Select * FROM note where heading LIKE(CONCAT('%',?,'%'))");
        statement.setString(1, heading);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Note note = fromResultSet(resultSet);
            notes.add(note);
        }
        resultSet.close();
        statement.close();
        return notes;
    }
    public void delete(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM note WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
    }




    private Note fromResultSet(ResultSet resultSet) throws SQLException {
        Note note = new Note();
        note.setId(resultSet.getInt("id"));
        note.setHeading(resultSet.getString("heading"));
        note.setText(resultSet.getString("text"));
        note.setUser_id(resultSet.getInt("user_id"));

        return note;
    }
}
