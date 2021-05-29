package org.closure.gcp.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.closure.gcp.models.Gender;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthday;

    
    private String address; 

    @ManyToOne(optional = true)
    private CollegeEntity college;

    @Column(nullable = true)
    private Gender gender;


    public UserEntity() {
    }

    public UserEntity(Integer id, String username, String email, String password, Date birthday, String address, CollegeEntity college, Gender gender) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.address = address;
        this.college = college;
        this.gender = gender;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CollegeEntity getCollege() {
        return this.college;
    }

    public void setCollege(CollegeEntity college) {
        this.college = college;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UserEntity id(Integer id) {
        setId(id);
        return this;
    }

    public UserEntity username(String username) {
        setUsername(username);
        return this;
    }

    public UserEntity email(String email) {
        setEmail(email);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
        return this;
    }

    public UserEntity birthday(Date birthday) {
        setBirthday(birthday);
        return this;
    }

    public UserEntity address(String address) {
        setAddress(address);
        return this;
    }

    public UserEntity college(CollegeEntity college) {
        setCollege(college);
        return this;
    }

    public UserEntity gender(Gender gender) {
        setGender(gender);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) && Objects.equals(username, userEntity.username) && Objects.equals(email, userEntity.email) && Objects.equals(password, userEntity.password) && Objects.equals(birthday, userEntity.birthday) && Objects.equals(address, userEntity.address) && Objects.equals(college, userEntity.college) && Objects.equals(gender, userEntity.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, birthday, address, college, gender);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", address='" + getAddress() + "'" +
            ", college='" + getCollege() + "'" +
            ", gender='" + getGender() + "'" +
            "}";
    }

}
