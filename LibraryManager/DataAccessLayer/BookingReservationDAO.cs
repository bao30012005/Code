using BusinessObjects;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace DataAccessLayer
{
    public class BookingReservationDAO
    {
        public static List<BookingReservation> GetAllReservations()
        {
            using var context = new FuminiHotelManagementContext();
            return context.BookingReservations
                          .Include(b => b.Customer)
                          .Include(b => b.BookingDetails)
                          .ThenInclude(d => d.Room)
                          .ToList();
        }

        public static BookingReservation GetReservationById(int id)
        {
            using var context = new FuminiHotelManagementContext();
            return context.BookingReservations
                          .Include(b => b.Customer)
                          .Include(b => b.BookingDetails)
                          .ThenInclude(d => d.Room)
                          .FirstOrDefault(b => b.BookingReservationId == id);
        }

        public static void AddReservation(BookingReservation reservation)
        {
            using var context = new FuminiHotelManagementContext();
            context.BookingReservations.Add(reservation);
            context.SaveChanges();
        }

        public static void UpdateReservation(BookingReservation reservation)
        {
            using var context = new FuminiHotelManagementContext();
            context.BookingReservations.Update(reservation);
            context.SaveChanges();
        }

        public static void DeleteReservation(int id)
        {
            using var context = new FuminiHotelManagementContext();
            var res = context.BookingReservations.FirstOrDefault(b => b.BookingReservationId == id);
            if (res != null)
            {
                context.BookingReservations.Remove(res);
                context.SaveChanges();
            }
        }

        public static List<BookingReservation> GetReservationsByCustomerId(int customerId)
        {
            using var context = new FuminiHotelManagementContext();
            return context.BookingReservations
                          .Where(r => r.CustomerId == customerId)
                          .Include(r => r.BookingDetails)
                          .ThenInclude(d => d.Room)
                          .ToList();
        }
    }
}