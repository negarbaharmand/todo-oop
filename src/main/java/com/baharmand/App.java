package com.baharmand;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AppUser user1 = new AppUser("user1", "dd3", AppRole.ROLE_APP_USER);
        System.out.println(user1.toString());
        System.out.println(user1.equals(user1));
        System.out.println(user1.hashCode());
    }
}
