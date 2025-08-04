using BaoWPF;
using BusinessObjects;
using Microsoft.Extensions.Configuration;
using Services;
using System;
using System.IO;
using System.Windows;

namespace BaoWPF
{
    public partial class LoginWindow : Window
    {
        private readonly ICustomerService customerService;

        private readonly string adminEmail;
        private readonly string adminPassword;

        public LoginWindow()
        {
            InitializeComponent();
            customerService = new CustomerService();

            // Load từ appsettings.json
            var config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json", optional: true, reloadOnChange: true)
                .Build();

            adminEmail = config["AdminAccount:Email"];
            adminPassword = config["AdminAccount:Password"];
        }

        private void btnLogin_Click(object sender, RoutedEventArgs e)
        {
            var email = txtEmail.Text.Trim();
            var password = txtPassword.Password.Trim();

            // Admin
            if (email == adminEmail && password == adminPassword)
            {
                var mainWindow = new MainWindow("Admin", null);
                mainWindow.Show();
                this.Close();
                return;
            }

            // Customer
            var customer = customerService.GetByEmail(email);
            if (customer != null && customer.Password == password && customer.CustomerStatus == 1)
            {
                var mainWindow = new MainWindow("Customer", customer);
                mainWindow.Show();
                this.Close();
                return;
            }

            MessageBox.Show("Invalid credentials or inactive account.", "Login Failed", MessageBoxButton.OK, MessageBoxImage.Error);
        }

        private void btnExit_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }
    }
}