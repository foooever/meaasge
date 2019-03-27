package model;

public class Message {
    public String content;
    public String id;
    public String title;
    public String date;

    public Message() {
        this.content = null;
        this.id = null;
        this.title = null;
        this.date = null;
    }

    public Message(String content, String id, String title) {
        this.content = content;
        this.id = id;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
