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
public class MinimumValidation implements InputValidation
{
    private final int MINIMUM_LENGTH;

    public MinimumValidation(int MINIMUM_LENGTH)
    {
        this.MINIMUM_LENGTH = MINIMUM_LENGTH;
    }

    @Override
    public boolean validateInput(String input) throws ValidationException
    {
        if (input == null)
        {
            throw new ValidationException("Input is null!");
        }
        if (input.length() == 0)
        {
            throw new ValidationException("Input is empty!");
        }
        if (input.length() < MINIMUM_LENGTH)
        {
            throw new ValidationException("Input should be at least " + MINIMUM_LENGTH + " characters long!");
        }

        return true;
    }
}
