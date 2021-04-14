package validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import model.Comment;
import model.User;

public class DoValidateCom {
	public static  List<String> validate(Comment com) {

        List<String> errors = new ArrayList<String>();
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Comment>> cvs = validator.validate(com);

        if (!cvs.isEmpty()) {

            for (ConstraintViolation<Comment> cv : cvs) {

                StringBuilder err = new StringBuilder();
                err.append(cv.getPropertyPath());
                err.append(" ");
                err.append(cv.getMessage());
                errors.add(err.toString());
            }
        }
        
        return errors;
    }

}
