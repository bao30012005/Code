using BusinessObjects;
using Services;
using System.Windows;
using System.Windows.Controls;

namespace BaoWPF
{
    public partial class BookingHistoryControl : UserControl
    {
        private readonly IBookingReservationService reservationService;
        private readonly IBookingDetailService detailService;
        private readonly Customer customer;

        public BookingHistoryControl(Customer customer)
        {
            InitializeComponent();
            this.customer = customer;
            reservationService = new BookingReservationService();
            detailService = new BookingDetailService();

            LoadHistory();
        }

        private void LoadHistory()
        {
            if (customer == null) return;
            dgHistory.ItemsSource = reservationService.GetByCustomerId(customer.CustomerId);
            dgDetail.ItemsSource = null;
        }

        private void dgHistory_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (dgHistory.SelectedItem is BookingReservation selected)
            {
                dgDetail.ItemsSource = detailService.GetByReservationId(selected.BookingReservationId);
            }
        }
    }
}