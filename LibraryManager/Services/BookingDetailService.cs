using BusinessObjects;
using Repositories;
using System.Collections.Generic;

namespace Services
{
    public class BookingDetailService : IBookingDetailService
    {
        private readonly IBookingDetailRepository repo = new BookingDetailRepository();

        public void Add(BookingDetail detail) => repo.Add(detail);
        public void Delete(int reservationId, int roomId) => repo.Delete(reservationId, roomId);
        public List<BookingDetail> GetByReservationId(int reservationId) => repo.GetByReservationId(reservationId);
        public void Update(BookingDetail detail) => repo.Update(detail);
    }
}