using BusinessObjects;
using System.Collections.Generic;

namespace Services
{
    public interface IRoomService
    {
        List<RoomInformation> GetAll();
        RoomInformation GetById(int id);
        void Add(RoomInformation room);
        void Update(RoomInformation room);
        void Delete(int id);
        bool RoomNumberExists(string roomNumber, int? excludeRoomId = null);
    }
}