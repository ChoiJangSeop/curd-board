package crud_board.vo;

import java.util.Date;

public class Feed {

    public int no;
    public String title;
    public String content;
    public Date createdDate;
    public String writer;
    public int likes=0;
    public int views=0;

    public Feed setNo(int no) {
        this.no = no; return this;
    }

    public int getNo() { return no; }

    public Feed setTitle(String title) {
        this.title = title; return this;
    }

    public String getTitle() { return title; }

    public Feed setContent(String content) {
        this.content = content; return this;
    }

    public String getContent() { return content; }

    public Feed setCreatedDate(Date createdDate) {
        this.createdDate = createdDate; return this;
    }

    public Date getCreatedDate() { return createdDate;}

    public Feed setWriter(String writer) {
        this.writer = writer; return this;
    }

    public String getWriter() { return writer; }

    public int getLikes() { return likes; }
    public int getViews() { return views; }
}
