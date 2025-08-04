using BusinessObjects;
using System.Collections.Generic;

namespace Repositories
{
    public interface IBookingReservationRepository
    {
        List<BookingReservation> GetAll();
        BookingReservation GetById(int id);
        List<BookingReservation> GetByCustomerId(int customerId);
        void Add(BookingReservation reservation);
        void Update(BookingReservation reservation);
        void Delete(int id);
    }
}