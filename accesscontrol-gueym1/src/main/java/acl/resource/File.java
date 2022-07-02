package acl.resource;

public class File extends Resource {
    String content;
    String name;


    public File(String name, String content){
        super(name);
        this.content = content;

    }

    public String getContent() {
        return this.content;
    }
}
