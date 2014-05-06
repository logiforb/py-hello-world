
package com.codetutr.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FidoStringConstraintValidator implements ConstraintValidator<FidoString, String> {

    @Override
    public void initialize(FidoString string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (phoneField == null) {
            return false;
        }
        
        return phoneField.equals("Fido");
    }
    
}
