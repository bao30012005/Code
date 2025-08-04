using BusinessObjects;
using DataAccessLayer;
using System.Collections.Generic;

namespace Repositories
{
    public class BookingDetailRepository : IBookingDetailRepository
    {
        public void Add(BookingDetail detail) => BookingDetailDAO.AddBookingDetail(detail);
        public void Delete(int reservationId, int roomId) => BookingDetailDAO.DeleteBookingDetail(reservationId, roomId);
        public List<BookingDetail> GetByReservationId(int reservationId) => BookingDetailDAO.GetDetailsByReservationId(reservationId);
        public void Update(BookingDetail detail) => BookingDetailDAO.UpdateBookingDetail(detail);
    }
}