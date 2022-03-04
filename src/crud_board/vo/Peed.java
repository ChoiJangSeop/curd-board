package crud_board.vo;

import java.util.Date;

public class Peed {

    public int no;
    public String title;
    public String content;
    public Date createdDate;
    public String writer;
    public int likes=0;
    public int views=0;

    public Peed setNo(int no) {
        this.no = no; return this;
    }

    public int getNo() { return no; }

    public Peed setTitle(String title) {
        this.title = title; return this;
    }

    public String getTitle() { return title; }

    public Peed setContent(String content) {
        this.content = content; return this;
    }

    public String getContent() { return content; }

    public Peed setCreatedDate(Date createdDate) {
        this.createdDate = createdDate; return this;
    }

    public Date getCreatedDate() { return createdDate;}

    public Peed setWriter(String writer) {
        this.writer = writer; return this;
    }

    public String getWriter() { return writer; }

    public int getLikes() { return likes; }
    public int getViews() { return views; }
}
