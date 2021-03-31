package lk.sadeep.mms.lolc.validator;

import lk.sadeep.mms.lolc.anotation.UniqueEmail;
import lk.sadeep.mms.lolc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>
{
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context)
    {
        return userRepository.findByEmail(email);
    }
}
