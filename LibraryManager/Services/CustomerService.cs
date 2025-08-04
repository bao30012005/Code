using BusinessObjects;
using Repositories;
using System.Collections.Generic;

namespace Services
{
    public class CustomerService : ICustomerService
    {
        private readonly ICustomerRepository repo = new CustomerRepository();

        public void Add(Customer customer) => repo.Add(customer);
        public void Delete(int id) => repo.Delete(id);
        public List<Customer> GetAll() => repo.GetAll();
        public Customer GetByEmail(string email) => repo.GetByEmail(email);
        public Customer GetById(int id) => repo.GetById(id);
        public void Update(Customer customer) => repo.Update(customer);

        public bool EmailExists(string email, int? excludeCustomerId = null)
        {
            return GetAll().Any(c =>
                c.EmailAddress.Equals(email, StringComparison.OrdinalIgnoreCase)
                && (!excludeCustomerId.HasValue || c.CustomerId != excludeCustomerId.Value));
        }
    }
}