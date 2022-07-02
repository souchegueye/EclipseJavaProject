package acl.resource;

import acl.access.AccessControlList;
import acl.access.AccessRight;
import acl.user.User;

public abstract class Resource {
    private String name;
    private AccessControlList acl;
    private Directory parent;

    public Resource(String name){
        this.name = name;
    }


    public void setACL(AccessControlList accessControlList){
        this.acl = accessControlList;

    }


    public String accessBy(User user){
        String  str = this.getContent();
        AccessRight accr = null;
        Resource resource = this;

        while (resource.parent != null){
            if(resource.acl !=null && resource.acl.getAccessRigthFor(user) != null){
                break;
            }
            resource = resource.parent;
        }

        if(resource.acl !=null){
            accr = resource.acl.getAccessRigthFor(user);
        }

        if(accr == AccessRight.GRANTED){
            return str;
        }else {
            return "Exception: Access denied";
        }

    }


    public String getName(){

        return this.name;
    }


    public void setParent(Directory parent){
        this.parent = parent;
    }


    public String getContent(){
        return this.name;
    }


}
