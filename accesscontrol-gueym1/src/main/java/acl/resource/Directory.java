package acl.resource;


import java.util.ArrayList;

public class Directory extends Resource {
    private ArrayList<Resource> children;

    public Directory(String name){
        super(name);
        children = new ArrayList<>();

    }


    public void add(Resource resource){
        resource.setParent(this);
        this.children.add(resource);

    }


    @Override
    public String getContent(){
        if(this.children.equals(null))
                return super.getName();
        String str = "";
        for(Resource res: children){
            str += res.getName() + "\n";
        }
        return str;
    }


}
