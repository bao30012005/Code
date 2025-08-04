using BusinessObjects;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace DataAccessLayer
{
    public class BookingDetailDAO
    {
        public static List<BookingDetail> GetDetailsByReservationId(int reservationId)
        {
            using var context = new FuminiHotelManagementContext();
            return context.BookingDetails
                          .Where(d => d.BookingReservationId == reservationId)
                          .Include(d => d.Room)
                          .ToList();
        }

        public static void AddBookingDetail(BookingDetail detail)
        {
            using var context = new FuminiHotelManagementContext();
            context.BookingDetails.Add(detail);
            context.SaveChanges();
        }

        public static void UpdateBookingDetail(BookingDetail detail)
        {
            using var context = new FuminiHotelManagementContext();
            context.BookingDetails.Update(detail);
            context.SaveChanges();
        }

        public static void DeleteBookingDetail(int reservationId, int roomId)
        {
            using var context = new FuminiHotelManagementContext();
            var detail = context.BookingDetails.FirstOrDefault(d =>
                d.BookingReservationId == reservationId && d.RoomId == roomId);

            if (detail != null)
            {
                context.BookingDetails.Remove(detail);
                context.SaveChanges();
            }
        }
    }
}