using BusinessObjects;
using System.Collections.Generic;

namespace Services
{
    public interface ICustomerService
    {
        List<Customer> GetAll();
        Customer GetById(int id);
        Customer GetByEmail(string email);
        void Add(Customer customer);
        void Update(Customer customer);
        void Delete(int id);

        bool EmailExists(string email, int? excludeCustomerId = null);
    }
}