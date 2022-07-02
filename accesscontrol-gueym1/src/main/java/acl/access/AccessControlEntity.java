package acl.access;

import acl.user.User;

public class AccessControlEntity  {

    private User user;
    private AccessRight accessRight;

    public AccessControlEntity(User user, AccessRight accessRight){
        this.user = user;
        this.accessRight = accessRight;
    }

    public User getUser() {
        return this.user;
    }

    public AccessRight getAccessRight() {
        return this.accessRight;
    }
}