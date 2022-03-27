package crud_board.vo;

import java.util.Date;

public class Comment {

    int no;
    String content;
    String writer;
    Date createdDate;

    public Comment setNo(int no) {
        this.no = no; return this;
    }

    public Comment setContent(String content) {
        this.content = content; return this;
    }

    public Comment setWriter(String writer) {
        this.writer = writer; return this;
    }

    public Comment setCreatedDate(Date createdDate) {
        this.createdDate = createdDate; return this;
    }

    public String getContent() {
        return content;
    }

    public int getNo() {
        return no;
    }

    public String getWriter() {
        return writer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
