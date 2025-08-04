using BusinessObjects;
using System.Collections.Generic;

namespace Repositories
{
    public interface IRoomRepository
    {
        List<RoomInformation> GetAll();
        RoomInformation GetById(int id);
        void Add(RoomInformation room);
        void Update(RoomInformation room);
        void Delete(int id);
    }
}