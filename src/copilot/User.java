package copilot;

/**
 *
 *
 * */
public class User {

    private String name;

    private String email;

    private String password;

    private String address;


    public User() {
        super();
    }

    public void setName(String name) {
        if(name == null || name.length() == 0) {
            throw new IllegalArgumentException("name is null or empty");
        }

        this.name = name;
    }





}
