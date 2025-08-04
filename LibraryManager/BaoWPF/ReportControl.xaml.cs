using BusinessObjects;
using Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Controls;

namespace BaoWPF
{
    public partial class ReportControl : UserControl
    {
        private readonly IBookingReservationService reservationService;

        public ReportControl()
        {
            InitializeComponent();
            reservationService = new BookingReservationService();
        }

        private void btnReport_Click(object sender, RoutedEventArgs e)
        {
            if (dpFrom.SelectedDate == null || dpTo.SelectedDate == null)
            {
                MessageBox.Show("Please select both dates.");
                return;
            }

            DateOnly from = DateOnly.FromDateTime(dpFrom.SelectedDate.Value);
            DateOnly to = DateOnly.FromDateTime(dpTo.SelectedDate.Value);

            if (from > to)
            {
                MessageBox.Show("Start date must be before end date.");
                return;
            }

            var data = reservationService.GetAll()
                .Where(r => r.BookingDate >= from && r.BookingDate <= to)
                .ToList();

            dgReport.ItemsSource = data;
        }
    }
}