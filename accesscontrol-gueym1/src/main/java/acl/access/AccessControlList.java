/*
 Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package acl.access;

import acl.user.User;

import java.util.ArrayList;

public class AccessControlList{

    private ArrayList<AccessControlEntity> acl = new ArrayList<>();

    public void add(AccessControlEntity ace) {
            for (AccessControlEntity ac : acl) {
                    if (ac.getUser().equals(ace.getUser())) {
                            if (ac.getAccessRight().equals(AccessRight.DENIED)) {
                                    return;
                            } else {
                                    this.acl.set(acl.indexOf(ac), ace);
                                    return;
                            }
                    }
            }
            acl.add(ace);
    }


    public AccessRight getAccessRigthFor(User user){
            for(AccessControlEntity ac : this.acl){
                    if(user.equals(ac.getUser())){
                            return ac.getAccessRight();
                    }
            }
            return null;
    }
}
