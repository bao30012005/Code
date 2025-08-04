using BusinessObjects;
using Services;
using System;
using System.Windows;
using System.Windows.Controls;

namespace BaoWPF
{
    public partial class ProfileControl : UserControl
    {
        private readonly ICustomerService customerService;
        private readonly IBookingReservationService reservationService;
        private Customer currentCustomer;

        public ProfileControl(Customer customer)
        {
            InitializeComponent();
            customerService = new CustomerService();
            reservationService = new BookingReservationService();

            currentCustomer = customer;
            LoadData();
        }

        private void LoadData()
        {
            txtName.Text = currentCustomer.CustomerFullName;
            txtPhone.Text = currentCustomer.Telephone;
            dpBirthday.SelectedDate = currentCustomer.CustomerBirthday?.ToDateTime(TimeOnly.MinValue);
            txtPassword.Password = currentCustomer.Password;
        }

        private void btnUpdate_Click(object sender, RoutedEventArgs e)
        {
            currentCustomer.CustomerFullName = txtName.Text;
            currentCustomer.Telephone = txtPhone.Text;
            currentCustomer.CustomerBirthday = dpBirthday.SelectedDate.HasValue
                ? DateOnly.FromDateTime(dpBirthday.SelectedDate.Value)
                : null;
            currentCustomer.Password = txtPassword.Password;

            customerService.Update(currentCustomer);
            MessageBox.Show("Information updated.");
        }

        private void btnDelete_Click(object sender, RoutedEventArgs e)
        {
            var hasBooking = reservationService
                .GetByCustomerId(currentCustomer.CustomerId)
                .Any();

            if (hasBooking)
            {
                MessageBox.Show("You cannot delete your account because you have booking history.");
                return;
            }

            var confirmPwd = Microsoft.VisualBasic.Interaction.InputBox(
                "Enter your password to confirm deletion:", "Confirm Delete", "");

            if (confirmPwd != currentCustomer.Password)
            {
                MessageBox.Show("Incorrect password.");
                return;
            }

            var confirm = MessageBox.Show("Are you sure you want to delete your account?", "Final Confirmation", MessageBoxButton.YesNo);
            if (confirm == MessageBoxResult.Yes)
            {
                customerService.Delete(currentCustomer.CustomerId);
                MessageBox.Show("Your account has been deleted.");
                Application.Current.Shutdown(); // hoặc quay lại LoginWindow
            }
        }
    }
}