using BusinessObjects;
using DataAccessLayer;
using System.Collections.Generic;

namespace Repositories
{
    public class RoomTypeRepository : IRoomTypeRepository
    {
        public void Add(RoomType type) => RoomTypeDAO.AddRoomType(type);
        public void Delete(int id) => RoomTypeDAO.DeleteRoomType(id);
        public List<RoomType> GetAll() => RoomTypeDAO.GetRoomTypes();
        public RoomType GetById(int id) => RoomTypeDAO.GetRoomTypeById(id);
        public void Update(RoomType type) => RoomTypeDAO.UpdateRoomType(type);
    }
}