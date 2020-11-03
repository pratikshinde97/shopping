package com.example.shopping.user;

import java.util.Set;

import com.example.shopping.util.StringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.dozer.DozerBeanMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Getter
@Setter
@Accessors(chain = true)
public class UserDTO {

    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private  String city;
    private  String area;
    private  String mobileNumber;
    private  String landmark;
    private  String pincode;


    public void setFirstName(String firstName) {
        this.firstName = StringUtil.isNotEmpty(firstName)?firstName.trim():null;
    }

    public void setLastName(String lastName) {
        this.lastName = StringUtil.isNotEmpty(lastName)?lastName.trim():null;
    }

    public void setEmail(String email) {
        this.email = StringUtil.isNotEmpty(email)?email.trim():null;
    }

    @JsonIgnore
    private DozerBeanMapper mapper = new DozerBeanMapper();

    @JsonIgnore
    public UserDTO getDTO(User entity) {
        mapper.map(entity, this);
        return this;
    }

    @JsonIgnore
    public User getEntity(User entity) {
        if(entity == null) {
            entity = mapper.map(this, User.class);
        }else {
            mapper.map(this, entity);
        }

        return entity;
    }

    @JsonIgnore
    public User getNewUserEntity(){
        User user = new User();
        user.setFirstName(this.getFirstName().trim());
        user.setLastName(this.getLastName().trim());
        user.setEmail(this.getEmail().trim());
        user.setLandmark(this.getLandmark().trim());
        user.setAddressLine1(this.getAddressLine1().trim());
        user.setAddressLine2(this.getAddressLine2().trim());
        user.setPincode(this.getPincode().trim());
        user.setCity(this.getCity().trim());
        user.setArea(this.getArea().trim());

        return user;
    }

    @JsonIgnore
    public UserDTO getUserDTOObject(User user){

        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setLandmark(user.getLandmark());
        this.setAddressLine1(user.getAddressLine1());
        this.setAddressLine2(user.getAddressLine2());
        this.setPincode(user.getPincode());
        this.setCity(user.getCity());
        this.setArea(user.getArea());


        return this;
    }

    @JsonIgnore
    public User getUpdateUserEntity(User user){

		/*if(StringUtil.isNotEmpty(this.getPassword())){
			user.setPassword(this.getPassword().trim());
		}*/
        if(StringUtil.isNotEmpty(this.getFirstName())){
            user.setFirstName(this.getFirstName().trim());
        }
        if(StringUtil.isNotEmpty(this.getLastName())){
            user.setLastName(this.getLastName().trim());
        }
        if(StringUtil.isNotEmpty(this.getEmail())){
            user.setEmail(this.getEmail().trim());
        }
        if(StringUtil.isNotEmpty(this.getAddressLine1())){
            user.setAddressLine1(this.getAddressLine1().trim());
        }
        if(StringUtil.isNotEmpty(this.getAddressLine2())){
            user.setAddressLine2(this.getAddressLine2().trim());
        }

        if(StringUtil.isNotEmpty(this.getMobileNumber())){
            user.setMobileNumber(this.getEmail().trim());
        }

        return user;
    }


    @SuppressWarnings("unused")
    private boolean validateEmptyList(Set<Object> list){
        return !list.isEmpty();
    }
}
