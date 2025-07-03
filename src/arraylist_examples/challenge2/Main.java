package arraylist_examples.challenge2;

import java.util.ArrayList;
/*
* In MobilePhone, use findContact() in the other methods
* (except printContacts()) to check if it exists before
* proceeding.
*
* Two "Contact" objects are equal if they have the same name.
*
*
* */
public class Main
{
    MobilePhone mp = new MobilePhone("324234234234");

}

class MobilePhone
{
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber)
    {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact)
    {
        if (findContact(contact.getName()) >= 0)
        {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact contactOld, Contact contactNew)
    {
        /*if (myContacts.contains(contactOld))
        {
            myContacts.remove(contactOld);
            myContacts.add(contactNew);
            return true;
        }
        else
        {
            return false;
        }*/
        if (findContact(contactOld) >= 0)
        {
            myContacts.remove(contactOld);
            myContacts.add(contactNew);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean removeContact(Contact contact)
    {
        /*if (myContacts.contains(contact))
        {
            myContacts.remove(contact);
            return true;
        }
        else
        {
            return false;
        }*/
        if (findContact(contact) >= 0)
        {
            myContacts.remove(contact);
            return true;
        }
        else
        {
            return false;
        }
    }

    private int findContact(Contact contact)
    {
        if (myContacts.contains(contact))
        {
            return myContacts.indexOf(contact);
        }
        else
        {
            return -1;
        }
    }

    private int findContact(String contactName)
    {
        for (Contact contact : myContacts)
        {
            if (contact.getName().equals(contactName))
            {
                return myContacts.indexOf(contact);
            }
        }

        return -1;
    }

    public Contact queryContact(String contactName)
    {
        for (Contact contact : myContacts)
        {
            if (contact.getName().equals(contactName))
            {
                return contact;
            }
        }

        return null;
    }

    public void printContact()
    {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++)
        {
            System.out.println(i + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}

class Contact
{
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber)
    {
        return new Contact(name, phoneNumber);
    }
}
