package am.basic.jdbcStart.model;

import java.util.Objects;

public class Note {
    private int id;

    private String heading;

    private String Text;

    private int user_id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id &&
                user_id == note.user_id &&
                Objects.equals(heading, note.heading) &&
                Objects.equals(Text, note.Text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, heading, Text, user_id);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", Text='" + Text + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
