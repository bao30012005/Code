using BusinessObjects;
using DataAccessLayer;
using System.Collections.Generic;

namespace Repositories
{
    public class RoomRepository : IRoomRepository
    {
        public void Add(RoomInformation room) => RoomDAO.AddRoom(room);
        public void Delete(int id) => RoomDAO.DeleteRoom(id);
        public List<RoomInformation> GetAll() => RoomDAO.GetRooms();
        public RoomInformation GetById(int id) => RoomDAO.GetRoomById(id);
        public void Update(RoomInformation room) => RoomDAO.UpdateRoom(room);
    }
}