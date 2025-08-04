using BusinessObjects;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace DataAccessLayer
{
    public class RoomDAO
    {
        public static List<RoomInformation> GetRooms()
        {
            using var context = new FuminiHotelManagementContext();
            return context.RoomInformations.Include(r => r.RoomType).ToList();
        }

        public static RoomInformation GetRoomById(int id)
        {
            using var context = new FuminiHotelManagementContext();
            return context.RoomInformations.Include(r => r.RoomType).FirstOrDefault(r => r.RoomId == id);
        }

        public static void AddRoom(RoomInformation room)
        {
            using var context = new FuminiHotelManagementContext();
            context.RoomInformations.Add(room);
            context.SaveChanges();
        }

        public static void UpdateRoom(RoomInformation room)
        {
            using var context = new FuminiHotelManagementContext();
            context.RoomInformations.Update(room);
            context.SaveChanges();
        }

        public static void DeleteRoom(int id)
        {
            using var context = new FuminiHotelManagementContext();
            var room = context.RoomInformations.FirstOrDefault(r => r.RoomId == id);
            if (room != null)
            {
                room.RoomStatus = 2;
                context.SaveChanges();
            }
        }
    }
}