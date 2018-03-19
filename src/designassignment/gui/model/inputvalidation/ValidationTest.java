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
public class ValidationTest
{
    public static void main(String[] args)
    {
        InputValidation minv = new MinimumValidation(8);
        System.out.println("minv12 true = " + minv.validateInput("sderersgfxar"));
        System.out.println(minv.getValidationMessage());
        System.out.println("minv8 true = " + minv.validateInput("iiiiiiii"));
        System.out.println(minv.getValidationMessage());
        System.out.println("minv1 false = " + minv.validateInput("2"));
        System.out.println(minv.getValidationMessage());
        System.out.println("");

        InputValidation nev = new NewEmailValidation();
        System.out.println("nev true = " + nev.validateInput("hej@msn.com"));
        System.out.println(nev.getValidationMessage());
        System.out.println("nev false = " + nev.validateInput(".hej@msn.com"));
        System.out.println(nev.getValidationMessage());
        System.out.println("nev false = " + nev.validateInput("hej@-msn.com"));
        System.out.println(nev.getValidationMessage());

        InputValidation npv = new NewPasswordValidation();
        System.out.println("npv12 true = " + npv.validateInput("sderersgfxar"));
        System.out.println(npv.getValidationMessage());
        System.out.println("npv1 false = " + npv.validateInput("2"));
        System.out.println(npv.getValidationMessage());
        System.out.println("");

        InputValidation nuv = new NewUsernameValidation();
        System.out.println("nuv12 true = " + nuv.validateInput("sderersgfxar"));
        System.out.println(nuv.getValidationMessage());
        System.out.println("nuv1 true = " + nuv.validateInput("2"));
        System.out.println(nuv.getValidationMessage());
        System.out.println("");

        InputValidation pv = new PasswordValidation();
        System.out.println("pv12 true = " + pv.validateInput("sderersgfxar"));
        System.out.println(pv.getValidationMessage());
        System.out.println("pv1 false = " + pv.validateInput("2"));
        System.out.println(pv.getValidationMessage());
        System.out.println("");

        InputValidation uv = new UsernameValidation();
        System.out.println("uv12 true = " + uv.validateInput("sderersgfxar"));
        System.out.println(uv.getValidationMessage());
        System.out.println("uv1 true = " + uv.validateInput("2"));
        System.out.println(uv.getValidationMessage());
        System.out.println("");

        InputValidation mv = new MergeValidations(minv, uv);
        System.out.println("mv true = " + mv.validateInput("sderersgfxar"));
        System.out.println(mv.getValidationMessage());
        mv = new MergeValidations(minv, nev);
        System.out.println("mv false = " + mv.validateInput("sderersgfxar"));
        System.out.println(mv.getValidationMessage());
        mv = new MergeValidations(nev, minv);
        System.out.println("mv false = " + mv.validateInput("sderersgfxar"));
        System.out.println(mv.getValidationMessage());
        mv = new MergeValidations(nev, nev);
        System.out.println("mv false = " + mv.validateInput("sderersgfxar"));
        System.out.println(mv.getValidationMessage());
        System.out.println("");
    }
}
