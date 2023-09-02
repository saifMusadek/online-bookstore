package bookstore.domain;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {
    //validation.............................
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is required")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Username is required")
    @Column(name = "username")
    private String username;
    @NotEmpty(message = "Password is required")
    @Column(name = "password")
    private String password;
    @NotEmpty(message = "Email is required")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Phone is required")
    @Column(name = "phone")
    private String phone;
    @NotEmpty(message = "Gender is required")
    @Column(name = "gender")
    private String gender;
    @NotEmpty(message = "Date is required")
    @Column(name = "dob")
    private String dob;
    @NotEmpty(message = "Address is required")
    @Column(name = "address")
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private UserRole role;

    public UserRole getRole() {
        return role;
    }


    public void setRole(int userId) {
        role=new UserRole();
        role.setId(userId);
    }

// Constructors, getters, and setters

    public User() {
        super();
    }


    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}