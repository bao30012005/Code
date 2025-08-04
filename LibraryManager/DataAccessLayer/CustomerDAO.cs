using BusinessObjects;
using System.Collections.Generic;
using System.Linq;

namespace DataAccessLayer
{
    public class CustomerDAO
    {
        public static List<Customer> GetCustomers()
        {
            using var context = new FuminiHotelManagementContext();
            return context.Customers.ToList();
        }

        public static Customer GetCustomerById(int id)
        {
            using var context = new FuminiHotelManagementContext();
            return context.Customers.FirstOrDefault(c => c.CustomerId == id);
        }

        public static Customer GetCustomerByEmail(string email)
        {
            using var context = new FuminiHotelManagementContext();
            return context.Customers.FirstOrDefault(c => c.EmailAddress == email);
        }

        public static void AddCustomer(Customer customer)
        {
            using var context = new FuminiHotelManagementContext();
            context.Customers.Add(customer);
            context.SaveChanges();
        }

        public static void UpdateCustomer(Customer customer)
        {
            using var context = new FuminiHotelManagementContext();
            context.Customers.Update(customer);
            context.SaveChanges();
        }

        public static void DeleteCustomer(int id)
        {
            using var context = new FuminiHotelManagementContext();
            var customer = context.Customers.FirstOrDefault(c => c.CustomerId == id);
            if (customer != null)
            {
                customer.CustomerStatus = 2;
                context.SaveChanges();
            }
        }
    }
}