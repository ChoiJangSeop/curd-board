package crud_board.vo;

public class User {

    public int no;
    public String name;
    public String id;
    public String password;

    public User setNo(int no) {
        this.no = no; return this;
    }

    public int getNo() { return no; }

    public User setName(String name) {
        this.name = name; return this;
    }

    public String getName() { return name; }

    public User setId(String id) {
        this.id = id; return this;
    }

    public String getId() { return id; }

    public User setPassword(String password) {
        this.password = password; return this;
    }

    public String getPassword() { return password; }
}
