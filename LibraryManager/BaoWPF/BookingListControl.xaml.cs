using BusinessObjects;
using Services;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;

namespace BaoWPF
{
    public partial class BookingListControl : UserControl
    {
        private readonly IBookingReservationService reservationService;
        private readonly IBookingDetailService detailService;

        public BookingListControl()
        {
            InitializeComponent();
            reservationService = new BookingReservationService();
            detailService = new BookingDetailService();
            LoadBookings();
        }

        private void LoadBookings()
        {
            dgBookings.ItemsSource = reservationService.GetAll();
            dgDetails.ItemsSource = null;
        }

        private void dgBookings_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (dgBookings.SelectedItem is BookingReservation selected)
            {
                dgDetails.ItemsSource = detailService.GetByReservationId(selected.BookingReservationId);
            }
        }

        private void btnDelete_Click(object sender, RoutedEventArgs e)
        {
            if (dgBookings.SelectedItem is BookingReservation selected)
            {
                var confirm = MessageBox.Show("Delete this booking?", "Confirm", MessageBoxButton.YesNo);
                if (confirm == MessageBoxResult.Yes)
                {
                    reservationService.Delete(selected.BookingReservationId);
                    LoadBookings();
                }
            }
        }
    }
}