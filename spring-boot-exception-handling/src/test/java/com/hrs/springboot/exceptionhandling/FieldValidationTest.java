package com.hrs.springboot.exceptionhandling;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.hrs.springboot.exceptionhandling.model.CompanyDetailsRequest;

@SpringBootTest
public class FieldValidationTest {

    private LocalValidatorFactoryBean localValidatorFactory;

    @BeforeEach
    public void setUp() {
        localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();

    }

    /**
     * Test with null id
     * Expected: {id.not-null}
     */
    @Test
    public void idIsNull() {
        final CompanyDetailsRequest payload = new CompanyDetailsRequest(null, "Test", "9999999999", "India");
        assertThat("{id.not-null}" + TestUtils.getFieldErrorMessageKey(payload, localValidatorFactory));
    }

    /**
     * Test with empty id
     * Expected: {id.not-null}
     */
    @Test
    public void idIsEmpty() {
        CompanyDetailsRequest payload = new CompanyDetailsRequest("", "Test", "9999999999", "India");
        assertThat("{id.not-null}" +  TestUtils.getFieldErrorMessageKey(payload, localValidatorFactory));
    }

    /**
     * Test with 14 digit id
     * Expected: {id.size}
     */
    @Test
    public void idIsFourteenDigit() {
        CompanyDetailsRequest payload = new CompanyDetailsRequest("C0000000000123", "Test", "9999999999",  "India");
        assertThat("{id.size}"+ TestUtils.getFieldErrorMessageKey(payload, localValidatorFactory));
    }

    /**
     * Test with null mobile
     * Expected: {mobile.not-null}
     */
    @Test
    public void mobileIsNull() {
        CompanyDetailsRequest payload = new CompanyDetailsRequest("C12345", "Test", null,  "India");
        assertThat("{mobile.not-null}"+ TestUtils.getFieldErrorMessageKey(payload, localValidatorFactory));
    }

    /**
     * Test with 4 digit mobile
     * Expected: {mobile.size}
     */
    @Test
    public void mobileIsFourDigit() {
        CompanyDetailsRequest payload = new CompanyDetailsRequest("C12345", "Test", "9999",  "India");
        assertThat("{mobile.size}"+ TestUtils.getFieldErrorMessageKey(payload, localValidatorFactory));
    }

    /**
     * Test with 14 digit mobile
     * Expected: {mobile.size}
     */
    @Test
    public void mobileIsFourteenDigit() {
        CompanyDetailsRequest payload = new CompanyDetailsRequest("C12345", "Test", "99999999999999",  "India");
        assertThat("{mobile.size}"+ TestUtils.getFieldErrorMessageKey(payload, localValidatorFactory));
    }

    /**
     * Test with character mobile
     * Expected: {mobile.pattern}
     */
    @Test
    public void mobileIsNotPositiveDigits() {
        CompanyDetailsRequest payload = new CompanyDetailsRequest("C12345", "Test", "ABCD9999999",  "India");
        assertThat("{mobile.pattern}"+ TestUtils.getFieldErrorMessageKey(payload, localValidatorFactory));
    }

    /**
     * Test with proper id
     * Expected: status 200
     */
    @Test
    public void successPayload() {
        CompanyDetailsRequest payload = new CompanyDetailsRequest("9999999999", "Test", "9999999999", "India");
        assertThat(TestUtils.getFieldErrorMessageKey(payload, localValidatorFactory));
    }
}