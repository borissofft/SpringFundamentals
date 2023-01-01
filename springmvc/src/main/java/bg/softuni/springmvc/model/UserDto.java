package bg.softuni.springmvc.model;

public class UserDto {
    private String fname;
    private String lname;

    public UserDto() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("fname='").append(fname).append('\'');
        sb.append(", lname='").append(lname).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
