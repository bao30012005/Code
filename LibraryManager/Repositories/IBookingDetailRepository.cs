using BusinessObjects;
using System.Collections.Generic;

namespace Repositories
{
    public interface IBookingDetailRepository
    {
        List<BookingDetail> GetByReservationId(int reservationId);
        void Add(BookingDetail detail);
        void Update(BookingDetail detail);
        void Delete(int reservationId, int roomId);
    }
}