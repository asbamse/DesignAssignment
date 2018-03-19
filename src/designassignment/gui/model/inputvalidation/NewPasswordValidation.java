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
public class NewPasswordValidation extends AbstractInputValidation
{
    private final int DEFAULT_MINIMUM_LENGTH = 8;
    private InputValidation mv;

    public NewPasswordValidation()
    {
        mv = new MinimumValidation(DEFAULT_MINIMUM_LENGTH);
    }

    @Override
    public boolean validateInput(String input)
    {
        mv.validateInput(input);

        validationMessage = input + " validation succeeded!";
        return true;
    }
}
