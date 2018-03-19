/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model.inputvalidationfactory;

import designassignment.bll.BLLException;
import designassignment.gui.model.inputvalidation.InputValidation;
import designassignment.gui.model.inputvalidation.MergeValidations;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asbamz
 */
public class ValidationFactoryTest
{
    public static void main(String[] args)
    {

        InputValidation mv;
        try
        {
            mv = InputValidationFactory.CreateAndInputValidation(InputValidationType.MINIMUM, InputValidationType.USERNAME);
            System.out.println("mv true = " + mv.validateInput("sderersgfxar"));
            System.out.println(mv.getValidationMessage());
            System.out.println("");
            mv = InputValidationFactory.CreateAndInputValidation(InputValidationType.MINIMUM, InputValidationType.NEW_EMAIL);
            System.out.println("mv false = " + mv.validateInput("sderersgfxar"));
            System.out.println(mv.getValidationMessage());
            System.out.println("");
            mv = InputValidationFactory.CreateAndInputValidation(InputValidationType.MINIMUM);
            System.out.println("mv true = " + mv.validateInput("sderersgfxar"));
            System.out.println(mv.getValidationMessage());
            System.out.println("");
        }
        catch (BLLException ex)
        {
            Logger.getLogger(ValidationFactoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
