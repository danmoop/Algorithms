package library;

public class Address {
    private String state;
    private String county;
    private String city;
    private String street;

    public Address(String state, String county, String city, String street) {
        this.state = state;
        this.county = county;
        this.city = city;
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}