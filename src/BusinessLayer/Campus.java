package BusinessLayer;

import java.io.Serializable;

/**
 *
 * @author Marline
 */
public class Campus implements Serializable{

    private int campusID;
    private String campusName;
    private String cAddress1;
    private String cAddress2;
    private String campusEmail;
    private int workNumber;

    public Campus(int campusID, String campusName, String cAddress1, String cAddress2, String campusEmail, int workNumber) {
        this.campusID = campusID;
        this.campusName = campusName;
        this.cAddress1 = cAddress1;
        this.cAddress2 = cAddress2;
        this.campusEmail = campusEmail;
        this.workNumber = workNumber;
    }

    public int getCampusID() {
        return campusID;
    }

    public String getCampusName() {
        return campusName;
    }

    public String getcAddress1() {
        return cAddress1;
    }

    public String getcAddress2() {
        return cAddress2;
    }

    public String getCampusEmail() {
        return campusEmail;
    }

    public int getWorkNumber() {
        return workNumber;
    }

    public void setCampusID(int campusID) {
        this.campusID = campusID;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public void setcAddress1(String cAddress1) {
        this.cAddress1 = cAddress1;
    }

    public void setcAddress2(String cAddress2) {
        this.cAddress2 = cAddress2;
    }

    public void setCampusEmail(String campusEmail) {
        this.campusEmail = campusEmail;
    }

    public void setWorkNumber(int workNumber) {
        this.workNumber = workNumber;
    }

    @Override
    public String toString() {
        return "Campus{" + "campusID=" + campusID + ", campusName=" + campusName + ", cAddress1=" + cAddress1 + ", cAddress2=" + cAddress2 + ", campusEmail=" + campusEmail + ", workNumber=" + workNumber + '}';
    }

}
