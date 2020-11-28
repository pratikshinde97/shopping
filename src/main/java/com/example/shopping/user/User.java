package com.example.shopping.user;

import javax.persistence.*;

import com.example.shopping.cart.Cart;
import com.example.shopping.common.BaseEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Access(AccessType.PROPERTY)
public class User extends BaseEntity {
	@NotNull
	@Column(name = "EMAIL", nullable = true, length = 256 ,unique = true)
	private String email;

	@NotNull
	@Column(name = "PASSWORD", nullable = false, length = 256)
	private String password;

	@Column(name = "FIRST_NAME", length = 30)
	private String firstName;

	@Column(name = "LAST_NAME", length = 30)
	private String lastName;

	@Column(name="ADDRESS_Line1")
	private  String addressLine1;

	@Column(name="ADDRESS_Line2")
	private  String addressLine2;

	@Column(name="LANDMARK")
	private  String landmark;

	@Column(name="AREA")
	private  String area;

	@Column(name="CITY")
	private  String city;

	@Column(name="PINCODE")
	private  String pincode;

	@Column(name="MOBILE NUMBER")
	private  String mobileNumber;


}
