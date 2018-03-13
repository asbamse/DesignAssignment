/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model.inputvalidation;

/**
 *
 * @author Asbamz
 */
public class UsernameValidation implements InputValidation
{
    private final int DEFAULT_MINIMUM_LENGTH = 3;
    private InputValidation mv;

    public UsernameValidation()
    {
        mv = new MinimumValidation(DEFAULT_MINIMUM_LENGTH);
    }

    @Override
    public boolean validateInput(String input) throws ValidationException
    {
        mv.validateInput(input);

        /*
        if(does not exist in database)
        {
            throw new ValidationException("Username does not exists!");
        }
         */
        return true;
    }
}
