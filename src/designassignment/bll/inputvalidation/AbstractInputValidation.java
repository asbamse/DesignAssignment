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
public abstract class AbstractInputValidation implements InputValidation
{
    protected String validationMessage;

    public AbstractInputValidation()
    {
        validationMessage = "";
    }

    @Override
    public String getValidationMessage()
    {
        return validationMessage;
    }
}
