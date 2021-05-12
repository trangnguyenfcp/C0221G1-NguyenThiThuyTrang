package Directory.models;

public class Contact {
    private String phoneNumber;
    private String contactGroup;
    private String fullName;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;
    public Contact(){

    }
    public Contact(String phoneNumber, String contactGroup, String fullName, String gender, String address, String dateOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.contactGroup = contactGroup;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", contactGroup='" + contactGroup + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
