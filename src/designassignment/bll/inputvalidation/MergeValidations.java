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
public class MergeValidations extends AbstractInputValidation
{
    private final InputValidation FIRST;
    private final InputValidation SECOND;

    public MergeValidations(InputValidation first, InputValidation second)
    {
        this.FIRST = first;
        this.SECOND = second;
    }

    @Override
    public boolean validateInput(String input)
    {
        boolean first = FIRST.validateInput(input);
        boolean second = SECOND.validateInput(input);
        if (first && second)
        {
            validationMessage = input + " validation succeeded!";
            return true;
        }
        else if (first)
        {
            validationMessage = SECOND.getValidationMessage();
            return false;
        }
        else if (second)
        {
            validationMessage = FIRST.getValidationMessage();
            return false;
        }
        else
        {
            validationMessage = FIRST.getValidationMessage() + " and " + SECOND.getValidationMessage();
            return false;
        }
    }
}
