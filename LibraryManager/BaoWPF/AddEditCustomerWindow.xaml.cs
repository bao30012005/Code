using BusinessObjects;
using Services;
using System;
using System.Windows;
using System.Xml.Linq;

namespace BaoWPF
{
    public partial class AddEditCustomerWindow : Window
    {
        private readonly ICustomerService customerService;
        private readonly Customer customer;

        public AddEditCustomerWindow(Customer customer)
        {
            InitializeComponent();
            this.customer = customer;
            customerService = new CustomerService();

            txtName.Text = customer.CustomerFullName;
            txtPhone.Text = customer.Telephone;
            dpBirthday.SelectedDate = customer.CustomerBirthday.HasValue
                ? customer.CustomerBirthday.Value.ToDateTime(TimeOnly.MinValue)
                : null; txtStatus.Text = customer.CustomerStatus.ToString();
        }

        private void btnSave_Click(object sender, RoutedEventArgs e)
        {
            if (!int.TryParse(txtStatus.Text, out int status))
            {
                MessageBox.Show("Invalid status.");
                return;
            }

            if (customerService.EmailExists(txtEmail.Text.Trim(), customer?.CustomerId))
            {
                MessageBox.Show("Email address already exists.");
                return;
            }

            customer.CustomerFullName = txtName.Text;
            customer.Telephone = txtPhone.Text;
            customer.CustomerBirthday = dpBirthday.SelectedDate.HasValue
                ? DateOnly.FromDateTime(dpBirthday.SelectedDate.Value)
                : null; customer.CustomerStatus = status;
            customerService.Update(customer);
            DialogResult = true;
        }

        private void btnCancel_Click(object sender, RoutedEventArgs e)
        {
            DialogResult = false;
        }
    }
}