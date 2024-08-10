package Main;

abstract class people {
    protected String name;
    protected String gender;
    protected String address;
    protected String phone;
    protected String DOB;
    protected String identityNumber;


    abstract void setName(String name);
    abstract void setGender(String gender);

    abstract void setAddress(String address);

    abstract void setPhone(String phone);

    abstract void setDOB(String dob);

    abstract void setIdentityNumber(String identityNumber);
    abstract String getName();
    abstract String getGender() ;

    abstract String getAddress();

    abstract String getPhone();

    abstract String getDOB();

    abstract String getIdentityNumber();

}
