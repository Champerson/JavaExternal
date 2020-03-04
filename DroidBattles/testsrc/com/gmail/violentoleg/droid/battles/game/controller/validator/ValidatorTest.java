package com.gmail.violentoleg.droid.battles.game.controller.validator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void validateCredentialsCorrectValues() {
        boolean correctInput = Validator.validateCredentials("login_789OLEG_16", "pass_CONTROL_12");
        Assert.assertTrue(correctInput);
    }

    @Test
    public void validateCredentialsEmptyValues() {
        boolean emptyValues = Validator.validateCredentials("", "");
        Assert.assertFalse(emptyValues);
    }

    @Test
    public void validateCredentialsNullValues() {
        boolean nullValues = Validator.validateCredentials(null, null);
        Assert.assertFalse(nullValues);
    }
    
    @Test
    public void validateCredentialsIncorrect() {
        boolean regexTest = Validator.validateCredentials("LOGIN@PASS_@!#", "PASSS@!(#HRNF 32");
        Assert.assertFalse(regexTest);
    }

    @Test
    public void validateCredentialsNullEmptyValues() {
        boolean nullEmpty = Validator.validateCredentials("", null);
        Assert.assertFalse(nullEmpty);
    }
}