/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.bll.inputvalidation;

/**
 *
 * @author Asbamz
 */
public class MinimumValidation extends AbstractInputValidation
{
    private final int MINIMUM_LENGTH;

    public MinimumValidation(int MINIMUM_LENGTH)
    {
        this.MINIMUM_LENGTH = MINIMUM_LENGTH;
    }

    @Override
    public boolean validateInput(String input)
    {
        if (input == null)
        {
            validationMessage = "Input is null!";
            return false;
        }
        if (input.length() == 0)
        {
            validationMessage = "Input is empty!";
            return false;
        }
        if (input.length() < MINIMUM_LENGTH)
        {
            validationMessage = "Input should be at least " + MINIMUM_LENGTH + " characters long!";
            return false;
        }

        validationMessage = input + " validation succeeded!";
        return true;
    }
}
