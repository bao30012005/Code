using BusinessObjects;
using Repositories;
using System.Collections.Generic;

namespace Services
{
    public class RoomService : IRoomService
    {
        private readonly IRoomRepository repo = new RoomRepository();

        public void Add(RoomInformation room) => repo.Add(room);
        public void Delete(int id) => repo.Delete(id);
        public List<RoomInformation> GetAll() => repo.GetAll();
        public RoomInformation GetById(int id) => repo.GetById(id);
        public void Update(RoomInformation room) => repo.Update(room);

        public bool RoomNumberExists(string roomNumber, int? excludeRoomId = null)
        {
            return GetAll().Any(r =>
                r.RoomNumber.Equals(roomNumber, StringComparison.OrdinalIgnoreCase)
                && (!excludeRoomId.HasValue || r.RoomId != excludeRoomId.Value));
        }

    }


}