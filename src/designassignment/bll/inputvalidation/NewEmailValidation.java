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
public class NewEmailValidation extends AbstractInputValidation
{
    private final int DEFAULT_MINIMUM_LENGTH = 5;
    private final String AT_SYMBOL = "@";
    private InputValidation mv;

    public NewEmailValidation()
    {
        mv = new MinimumValidation(DEFAULT_MINIMUM_LENGTH);
    }

    @Override
    public boolean validateInput(String input)
    {
        boolean min = mv.validateInput(input);

        if (!min)
        {
            validationMessage = mv.getValidationMessage();
            return false;
        }

        if (!input.contains(AT_SYMBOL))
        {
            validationMessage = "An email should contain a " + AT_SYMBOL + "!";
            return false;
        }
        else
        {
            int count = input.length() - input.replace(AT_SYMBOL, "").length();
            if (count > 1)
            {
                validationMessage = "An email should only contain one " + AT_SYMBOL + "!";
                return false;
            }
        }

        String localpart = input.split(AT_SYMBOL)[0];
        if (localpart.length() == 0)
        {
            validationMessage = "An email should have a local-part!";
            return false;
        }
        if (!localpart.matches(".*[a-zA-z0-9\\!\\#\\$\\%\\&\\'\\*\\+\\-\\/\\=\\?\\^\\_\\`\\{\\|\\}\\~\\.]"))
        {
            validationMessage = "The local-part can only exist of a-z, A-z, 0-9 and these symbols !#$%&'*+-/=?^_`{|}~.]!";
            return false;
        }
        if (localpart.substring(0, 1).equals(".") || localpart.substring(localpart.length() - 1).equals("."))
        {
            validationMessage = "The local-part cannot start nor end with a . dot!";
            return false;
        }

        String domain = input.split(AT_SYMBOL)[1];
        if (domain.length() == 0)
        {
            validationMessage = "An email should have a domain!";
            return false;
        }
        if (!domain.matches(".*[a-zA-z0-9\\-]"))
        {
            validationMessage = "The domain can only exist of a-z, A-z, 0-9 and - hyphen!";
            return false;
        }
        if (domain.substring(0, 1).equals("-") || domain.substring(localpart.length() - 1).equals("-"))
        {
            validationMessage = "The domain cannot start nor end with a - hyphen!";
            return false;
        }

        validationMessage = input + " validation succeeded!";
        return true;
    }
}
