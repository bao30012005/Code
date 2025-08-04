using BusinessObjects;
using DataAccessLayer;
using System.Collections.Generic;

namespace Repositories
{
    public class CustomerRepository : ICustomerRepository
    {
        public void Add(Customer customer) => CustomerDAO.AddCustomer(customer);
        public void Delete(int id) => CustomerDAO.DeleteCustomer(id);
        public List<Customer> GetAll() => CustomerDAO.GetCustomers();
        public Customer GetByEmail(string email) => CustomerDAO.GetCustomerByEmail(email);
        public Customer GetById(int id) => CustomerDAO.GetCustomerById(id);
        public void Update(Customer customer) => CustomerDAO.UpdateCustomer(customer);
    }
}