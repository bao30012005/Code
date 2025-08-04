using BaoWPF;
using BusinessObjects;
using System.Windows;

namespace BaoWPF
{
    public partial class MainWindow : Window
    {
        private readonly string role;
        private readonly Customer currentCustomer;

        public MainWindow(string role, Customer customer)
        {
            InitializeComponent();
            this.role = role;
            this.currentCustomer = customer;

            SetupUIByRole();
        }

        private void SetupUIByRole()
        {
            if (role == "Customer")
            {
                btnRooms.Visibility = Visibility.Collapsed;
                btnCustomers.Visibility = Visibility.Collapsed;
                btnReport.Visibility = Visibility.Collapsed;
                btnBookings.Visibility = Visibility.Visible;
                btnProfile.Visibility = Visibility.Visible;
            }
            else if (role == "Admin")
            {
                btnProfile.Visibility = Visibility.Collapsed;
            }
        }

        private void btnRooms_Click(object sender, RoutedEventArgs e)
        {
            MainContent.Content = new RoomListControl();
        }

        private void btnCustomers_Click(object sender, RoutedEventArgs e)
        {
            MainContent.Content = new CustomerListControl();
        }

        private void btnProfile_Click(object sender, RoutedEventArgs e)
        {
            MainContent.Content = new ProfileControl(currentCustomer);
        }

        private void btnReport_Click(object sender, RoutedEventArgs e)
        {
            MainContent.Content = new ReportControl();
        }

        private void btnBookings_Click(object sender, RoutedEventArgs e)
        {
            if (role == "Admin")
            {
                MainContent.Content = new BookingListControl();
            }
            else
            {
                MainContent.Content = new BookingHistoryControl(currentCustomer);
            }
        }

        private void btnLogout_Click(object sender, RoutedEventArgs e)
        {
            var loginWindow = new LoginWindow();
            loginWindow.Show();
            this.Close();
        }
    }
}