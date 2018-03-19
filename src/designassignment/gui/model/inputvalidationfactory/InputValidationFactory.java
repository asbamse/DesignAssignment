/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designassignment.gui.model.inputvalidationfactory;

import designassignment.bll.BLLException;
import designassignment.gui.model.inputvalidation.InputValidation;
import designassignment.gui.model.inputvalidation.MergeValidations;
import designassignment.gui.model.inputvalidation.MinimumValidation;
import designassignment.gui.model.inputvalidation.NewEmailValidation;
import designassignment.gui.model.inputvalidation.NewPasswordValidation;
import designassignment.gui.model.inputvalidation.NewUsernameValidation;
import designassignment.gui.model.inputvalidation.PasswordValidation;
import designassignment.gui.model.inputvalidation.UsernameValidation;

/**
 *
 * @author Asbamz
 */
public class InputValidationFactory
{
    private static final int MINIMUM_LENGTH = 8;

    public static InputValidation CreateInputValidation(InputValidationType type) throws BLLException
    {
        switch (type)
        {
            case MINIMUM:
                return new MinimumValidation(MINIMUM_LENGTH);
            case NEW_EMAIL:
                return new NewEmailValidation();
            case NEW_USERNAME:
                return new NewUsernameValidation();
            case NEW_PASSWORD:
                return new NewPasswordValidation();
            case USERNAME:
                return new UsernameValidation();
            case PASSWORD:
                return new PasswordValidation();
            default:
                throw new BLLException("InputValidationType not found!");
        }
    }

    public static InputValidation CreateAndInputValidation(InputValidationType... types) throws BLLException
    {
        InputValidation mutant = null;

        if (types.length > 0)
        {
            switch (types[0])
            {
                case MINIMUM:
                    mutant = new MinimumValidation(MINIMUM_LENGTH);
                    break;
                case NEW_EMAIL:
                    mutant = new NewEmailValidation();
                    break;
                case NEW_USERNAME:
                    mutant = new NewUsernameValidation();
                    break;
                case NEW_PASSWORD:
                    mutant = new NewPasswordValidation();
                    break;
                case USERNAME:
                    mutant = new UsernameValidation();
                    break;
                case PASSWORD:
                    mutant = new PasswordValidation();
                    break;
                default:
                    throw new BLLException("InputValidationType not found!");
            }

            for (int i = 1; i < types.length; i++)
            {
                switch (types[i])
                {
                    case MINIMUM:
                        mutant = new MergeValidations(mutant, new MinimumValidation(MINIMUM_LENGTH));
                        break;
                    case NEW_EMAIL:
                        mutant = new MergeValidations(mutant, new NewEmailValidation());
                        break;
                    case NEW_USERNAME:
                        mutant = new MergeValidations(mutant, new NewUsernameValidation());
                        break;
                    case NEW_PASSWORD:
                        mutant = new MergeValidations(mutant, new NewPasswordValidation());
                        break;
                    case USERNAME:
                        mutant = new MergeValidations(mutant, new UsernameValidation());
                        break;
                    case PASSWORD:
                        mutant = new MergeValidations(mutant, new PasswordValidation());
                        break;
                    default:
                        throw new BLLException("InputValidationType not found!");
                }
            }
        }

        if (mutant == null)
        {
            throw new BLLException("No types!");
        }
        return mutant;
    }
}
