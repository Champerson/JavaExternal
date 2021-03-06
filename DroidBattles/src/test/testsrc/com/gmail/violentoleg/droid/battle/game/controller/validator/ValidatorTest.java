package com.gmail.violentoleg.droid.battle.game.controller.validator;

import org.junit.Assert;
import org.junit.Test;

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