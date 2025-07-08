package linkedlist.challenge3;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        /*Customer canberk = new Customer("Canberk", 1000.0);

        System.out.println(canberk.getTransactions());
        canberk.addTransaction(500.0);
        canberk.addTransaction(-400.0);
        System.out.println(canberk.getTransactions());*/

        Bank bank = new Bank("İş Bankası");

        bank.addBranch("İzmir");
        boolean bankBool = bank.addBranch("İzmir");
        System.out.println(bankBool);

        bank.addCustomer("İzmir", "Canberk", 1000.0);
        bank.addCustomerTransaction("İzmir", "Canberk", -54.60);
        bank.addCustomerTransaction("İzmir", "Canberk", 344.60);

        bank.addCustomer("İzmir", "Özüm", 122.0);

        bank.listCustomers("İzmir", true);
    }
}

class Bank
{
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name)
    {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String name)
    {
        Branch branch = findBranch(name);
        if (branch == null)
        {
            Branch newBranch = new Branch(name);
            branches.add(newBranch);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction)
    {
        Branch branch = findBranch(branchName);

        if (branch != null)
        {
            return branch.newCustomer(customerName, initialTransaction);
        }
        else
        {
            return false;
        }
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction)
    {
        Branch branch = findBranch(branchName);

        if (branch != null)
        {
            branch.addCustomerTransaction(customerName, transaction);
            return true;
        }
        else
        {
            return false;
        }
    }

    public Branch findBranch(String branchName)
    {
        for (Branch branch : branches)
        {
            if (branch.getName().equals(branchName))
            {
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions)
    {
        /*Branch branch = findBranch(branchName);
        boolean printFlag = true;
        int index = 0;
        if (branch != null)
        {
            System.out.println("Customer details for branch: " + branch.getName());
            for (int i = 0; i < branch.getCustomers().size(); i++)
            {
                System.out.printf("Customer: %s [%d]", branch.getCustomers().get(i).getName(), i+1);
                System.out.println();
                System.out.println("Transactions");
                while (printFlag)
                {
                    System.out.printf("[%d] Amount ", i+1);
                    System.out.println(branch.getCustomers().get(i).getTransactions().get(index));
                    index++;
                    if (index == branch.getCustomers().get(i).getTransactions().size())
                    {
                        printFlag = false;
                    }
                }

            }
            return true;
        }
        else
        {
            return false;
        }*/

        // IMPROVED CODE

        Branch branch = findBranch(branchName);
        if (branch != null)
        {
            for (int i = 0; i < branch.getCustomers().size(); i++)
            {
                Customer customer = branch.getCustomers().get(i);
                System.out.printf("Customer: %s [%d]%n", customer.getName(), i+1);

                if (printTransactions)
                {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++)
                    {
                        System.out.printf("[%d] Amount %.2f%n", j+1, transactions.get(j));
                    }
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}

class Branch
{
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name)
    {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Customer> getCustomers()
    {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction)
    {
        Customer customer = findCustomer(name);
        System.out.println("newCustomer - Found customer: " + customer);

        if (customer == null)
        {
            System.out.println("Customer is null, adding new customer");
            customers.add(new Customer(name, initialTransaction));
            return true;
        }
        else
        {
            System.out.println("Customer already exists, not adding");
            return false;
        }
        /*Customer customer = findCustomer(name);
        System.out.println("Findcustomer result: " + customer);
        if (customer == null)
        {
            customers.add(new Customer(name, initialTransaction));
            return true;
        }
        else
        {
            return false;
        }*/
    }

    public boolean addCustomerTransaction(String name, double transaction)
    {
        Customer customer = findCustomer(name);

        if (customer != null)
        {
            customer.addTransaction(transaction);
            return true;
        }
        else
        {
            return false;
        }
    }

    private Customer findCustomer(String name)
    {
        for (Customer customer : customers)
        {
            if (customer.getName().equals(name))
            {
                return customer;
            }
        }

        return null;

        /*for (Customer customer : customers)
        {
            System.out.println("Customer name: " + customer.getName());
            System.out.println("Search name: " + name);
            boolean isEqual = customer.getName().equals(name);
            System.out.println("Is equal? " + isEqual);
            if (isEqual)
            {
                System.out.println("ENTERING IF BLOCK!");
                return customer;
            }
        }
        System.out.println("RETURNING NULL");
        return null;*/

        /*for (int i = 0; i < customers.size(); i++)
        {
            Customer customer = customers.get(i);

            if (customer.getName().equals(name))
            {
                return customer;
            }
        }

        return null;*/
    }
}

class Customer
{
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction)
    {
        this.name = name;
        this.transactions = new ArrayList<>();
        transactions.add(initialTransaction);
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Double> getTransactions()
    {
        return transactions;
    }

    public void addTransaction(double transaction)
    {
        transactions.add(transaction);
    }
}
