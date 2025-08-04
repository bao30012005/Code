using BusinessObjects;
using System.Collections.Generic;
using System.Linq;

namespace DataAccessLayer
{
    public class RoomTypeDAO
    {
        public static List<RoomType> GetRoomTypes()
        {
            using var context = new FuminiHotelManagementContext();
            return context.RoomTypes.ToList();
        }

        public static RoomType GetRoomTypeById(int id)
        {
            using var context = new FuminiHotelManagementContext();
            return context.RoomTypes.FirstOrDefault(t => t.RoomTypeId == id);
        }

        public static void AddRoomType(RoomType type)
        {
            using var context = new FuminiHotelManagementContext();
            context.RoomTypes.Add(type);
            context.SaveChanges();
        }

        public static void UpdateRoomType(RoomType type)
        {
            using var context = new FuminiHotelManagementContext();
            context.RoomTypes.Update(type);
            context.SaveChanges();
        }

        public static void DeleteRoomType(int id)
        {
            using var context = new FuminiHotelManagementContext();
            var type = context.RoomTypes.FirstOrDefault(t => t.RoomTypeId == id);
            if (type != null)
            {
                context.RoomTypes.Remove(type);
                context.SaveChanges();
            }
        }
    }
}