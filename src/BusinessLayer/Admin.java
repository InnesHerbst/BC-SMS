
package BusinessLayer;

import java.util.Date;

import java.util.Date;

/**
 *
 * @author Adria
 */
public class Admin {
    private String Admin_ID;
    private int Campus_ID;

    public String getAdmin_ID() {
        return Admin_ID;
    }

    public void setAdmin_ID(String Admin_ID) {
        this.Admin_ID = Admin_ID;
    }

    public int getCampus_ID() {
        return Campus_ID;
    }

    public void setCampus_ID(int Campus_ID) {
        this.Campus_ID = Campus_ID;
    }

    public Admin(String Admin_ID, int Campus_ID) {
        this.Admin_ID = Admin_ID;
        this.Campus_ID = Campus_ID;
    }

    
    
    public void Register_admin(Admin adm)
    {
        
    }
}
