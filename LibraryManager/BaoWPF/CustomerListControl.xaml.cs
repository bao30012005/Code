using BusinessObjects;
using Services;
using System.Windows;
using System.Windows.Controls;

namespace BaoWPF
{
    public partial class CustomerListControl : UserControl
    {
        private readonly ICustomerService customerService;

        public CustomerListControl()
        {
            InitializeComponent();
            customerService = new CustomerService();
            LoadCustomers();
        }

        private void LoadCustomers()
        {
            dgCustomers.ItemsSource = customerService.GetAll();
        }

        private void btnEdit_Click(object sender, RoutedEventArgs e)
        {
            if (dgCustomers.SelectedItem is Customer selected)
            {
                var window = new AddEditCustomerWindow(selected); // tạo sau
                if (window.ShowDialog() == true)
                {
                    LoadCustomers();
                }
            }
        }

        private void btnDelete_Click(object sender, RoutedEventArgs e)
        {
            if (dgCustomers.SelectedItem is Customer selected)
            {
                var result = MessageBox.Show("Soft delete this customer?", "Confirm", MessageBoxButton.YesNo);
                if (result == MessageBoxResult.Yes)
                {
                    customerService.Delete(selected.CustomerId);
                    LoadCustomers();
                }
            }
        }
    }
}