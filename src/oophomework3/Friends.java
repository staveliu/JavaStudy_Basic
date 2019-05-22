package oophomework3;

public class Friends {

    private ContactPerson girl;
    private ContactPerson boy;

    public Friends(String girlName, String girlPhoneNumber, String girlEmail, String girlAddress, String boyName, String boyPhoneNumber, String boyEmail, String boyAddress) {
        girl = new ContactPerson(girlName,girlPhoneNumber,girlEmail,girlAddress);
        boy = new ContactPerson(boyName,boyPhoneNumber,boyEmail,boyAddress);
    }


    public String getGirlName() {
        return girl.getName();
    }

    public void setGirlName(String girlName) {
        girl.setName(girlName);
    }

    public String getGirlPhoneNumber() {
        return girl.getPhoneNumber();
    }

    public void setGirlPhoneNumber(String girlPhoneNumber) {
        girl.setPhoneNumber(girlPhoneNumber);
    }

    public String getGirlEmail() {
        return girl.getEmail();
    }

    public void setGirlEmail(String girlEmail) {
        girl.setEmail(girlEmail);
    }

    public String getGirlAddress() {
        return girl.getAddress();
    }

    public void setGirlAddress(String girlAddress) {
        girl.setAddress(girlAddress);
    }

    public String getBoyName() {
        return boy.getName();
    }

    public void setBoyName(String boyName) {
        boy.setName(boyName);
    }

    public String getBoyPhoneNumber() {
        return boy.getPhoneNumber();
    }

    public void setBoyPhoneNumber(String boyPhoneNumber) {
        boy.setPhoneNumber(boyPhoneNumber);
    }

    public String getBoyEmail() {
        return boy.getEmail();
    }

    public void setBoyEmail(String boyEmail) {
        boy.setEmail(boyEmail);
    }

    public String getBoyAddress() {
        return boy.getAddress();
    }

    public void setBoyAddress(String boyAddress) {
        boy.setAddress(boyAddress);
    }

    public void display(){
        System.out.println("My Girlfriend's name is : "+girl.getName());
        System.out.println("My Girlfriend's phone number is : "+girl.getPhoneNumber());
        System.out.println("My Girlfriend's E-mail is : "+girl.getEmail());
        System.out.println("My Girlfriend's address is : "+girl.getAddress());
        System.out.println("--------------------------------------------------");
        System.out.println("My Boyfriend's name is : "+boy.getName());
        System.out.println("My Boyfriend's phone number is : "+boy.getPhoneNumber());
        System.out.println("My Boyfriend's E-mail is : "+boy.getEmail());
        System.out.println("My Boyfriend's address is : "+boy.getAddress());
        System.out.println("--------------------------------------------------");
    }

}
