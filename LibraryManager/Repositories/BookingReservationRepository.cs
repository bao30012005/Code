using BusinessObjects;
using DataAccessLayer;
using System.Collections.Generic;

namespace Repositories
{
    public class BookingReservationRepository : IBookingReservationRepository
    {
        public void Add(BookingReservation reservation) => BookingReservationDAO.AddReservation(reservation);
        public void Delete(int id) => BookingReservationDAO.DeleteReservation(id);
        public List<BookingReservation> GetAll() => BookingReservationDAO.GetAllReservations();
        public BookingReservation GetById(int id) => BookingReservationDAO.GetReservationById(id);
        public List<BookingReservation> GetByCustomerId(int customerId) => BookingReservationDAO.GetReservationsByCustomerId(customerId);
        public void Update(BookingReservation reservation) => BookingReservationDAO.UpdateReservation(reservation);
    }
}