package com.hrs.springboot.exceptionhandling.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CompanyDetailsRequest {

    @NotBlank(message = "{id.not-null}")
    @Size(min=2, max = 10, message = "{id.size}")
    private String id;

    @NotBlank(message = "{name.not-null}")
    private String name;

    @NotNull(message = "{mobile.not-null}")
    @Size(min=10, max=13, message = "{mobile.size}")
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="{mobile.pattern}")
    private String mobile;

    private String location;

    
	public CompanyDetailsRequest() {
		super();
	}

	public CompanyDetailsRequest(
			@NotBlank(message = "{id.not-null}") @Size(min = 2, max = 10, message = "{id.size}") String id,
			@NotBlank(message = "{name.not-null}") String name,
			@NotNull(message = "{mobile.not-null}") @Size(min = 10, max = 13, message = "{mobile.size}") @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message = "{mobile.pattern}") String mobile,
			String location) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
}