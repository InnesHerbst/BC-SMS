package BusinessLayer;

/**
 *
 * @author Marline
 */
public class Department {

    private int deptID;
    private String deptName;
    private String deptDescription;

    public Department(int deptID, String deptName, String deptDescription) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.deptDescription = deptDescription;
    }

    public int getDeptID() {
        return deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

}
