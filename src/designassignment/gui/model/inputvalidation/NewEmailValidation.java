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
public class NewEmailValidation implements InputValidation
{
    private final int DEFAULT_MINIMUM_LENGTH = 5;
    private final String AT_SYMBOL = "@";
    private InputValidation mv;

    public NewEmailValidation()
    {
        mv = new MinimumValidation(DEFAULT_MINIMUM_LENGTH);
    }

    @Override
    public boolean validateInput(String input) throws ValidationException
    {
        mv.validateInput(input);

        if (!input.contains(AT_SYMBOL))
        {
            throw new ValidationException("An email should contain a " + AT_SYMBOL + "!");
        }
        else
        {
            int count = input.length() - input.replace(AT_SYMBOL, "").length();
            if (count > 1)
            {
                throw new ValidationException("An email should only contain one " + AT_SYMBOL + "!");
            }
        }

        String localpart = input.split(AT_SYMBOL)[0];
        if (localpart.length() == 0)
        {
            throw new ValidationException("An email should have a local-part!");
        }
        if (!localpart.matches("[a-zA-z0-9\\!\\#\\$\\%\\&\\'\\*\\+\\-\\/\\=\\?\\^\\_\\`\\{\\|\\}\\~\\.]"))
        {
            throw new ValidationException("The local-part can only exist of a-z, A-z, 0-9 and these symbols !#$%&'*+-/=?^_`{|}~.]!");
        }
        if (localpart.substring(0, 1).equals(".") || localpart.substring(localpart.length() - 1).equals("."))
        {
            throw new ValidationException("The local-part cannot start nor end with a . dot!");
        }

        String domain = input.split(AT_SYMBOL)[1];
        if (domain.length() == 0)
        {
            throw new ValidationException("An email should have a domain!");
        }
        if (!domain.matches("[a-zA-z0-9\\-]"))
        {
            throw new ValidationException("The domain can only exist of a-z, A-z, 0-9 and - hyphen!");
        }
        if (domain.substring(0, 1).equals("-") || domain.substring(localpart.length() - 1).equals("-"))
        {
            throw new ValidationException("The domain cannot start nor end with a - hyphen!");
        }

        return true;
    }
}
