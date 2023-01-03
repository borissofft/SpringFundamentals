package bg.softuni.mobilele.model.dto;

public class UserLoginDto {
    private String username;
    private String password;

    public UserLoginDto() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserLoginDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password != null ? "[PROVIDED]" : null).append('\''); // We don't have to provide the password in toString because can be seen in logs or by debuggers
        sb.append('}');
        return sb.toString();
    }

}
