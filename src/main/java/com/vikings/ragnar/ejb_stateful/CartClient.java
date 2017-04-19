package com.vikings.ragnar.ejb_stateful;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by User on 13-Apr-17.
 */
public class CartClient {

    public static void main(String [] args) throws NamingException{

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "jdbc:mysql://localhost:3306/mydb");
        env.put(Context.SECURITY_PRINCIPAL, "root");
        env.put(Context.SECURITY_CREDENTIALS, "rootroot");

        Context context = new InitialContext(env);

        try {
            //final Context context = getInitialContext();
            Cart cart = (Cart)context.lookup("CartBean");

            System.out.println("Adding items to cart");

            cart.addItem("Pizza");
            cart.addItem("Pasta");
            cart.addItem("Noodles");
            cart.addItem("Bread");
            cart.addItem("Butter");


            System.out.println("Listing cart contents");
            Collection items = cart.getItems();
            for (Iterator i = items.iterator(); i.hasNext();) {
                String item = (String) i.next();
                System.out.println("  " + item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        return new InitialContext();
    }
}



