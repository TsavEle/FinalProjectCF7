package finalProject.model;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;


public class Lawyer {

    public Lawyer() {
    }

    public Lawyer(Integer id, String firstname, String lastname, String phoneNumber,
                  String zipcode, String streetName, String streetNumber,
                  String email, String vat, Integer cityId, String uuid,
                  LocalDateTime createdAt, LocalDateTime updatedAt, Map<Integer, Skill> skills) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.zipcode = zipcode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.email = email;
        this.vat = vat;
        this.cityId = cityId;
        this.uuid = (uuid != null) ? uuid : UUID.randomUUID().toString();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.skills = skills;
    }

    private Integer id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String zipcode;
    private String streetName;
    private String streetNumber;
    private String email;
    private String vat;
    private Integer cityId;
    private String uuid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Map<Integer, Skill> skills;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<Integer, Skill> getSkills() {
        return skills;
    }

    public void setSkills(Map<Integer, Skill> skills) {
        this.skills = skills;
    }
}
