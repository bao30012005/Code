using BusinessObjects;
using Repositories;
using System.Collections.Generic;

namespace Services
{
    public class BookingReservationService : IBookingReservationService
    {
        private readonly IBookingReservationRepository repo = new BookingReservationRepository();

        public void Add(BookingReservation reservation) => repo.Add(reservation);
        public void Delete(int id) => repo.Delete(id);
        public List<BookingReservation> GetAll() => repo.GetAll();
        public BookingReservation GetById(int id) => repo.GetById(id);
        public List<BookingReservation> GetByCustomerId(int customerId) => repo.GetByCustomerId(customerId);
        public void Update(BookingReservation reservation) => repo.Update(reservation);
    }
}