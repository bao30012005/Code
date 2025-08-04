using BusinessObjects;
using System.Collections.Generic;

namespace Repositories
{
    public interface IRoomTypeRepository
    {
        List<RoomType> GetAll();
        RoomType GetById(int id);
        void Add(RoomType type);
        void Update(RoomType type);
        void Delete(int id);
    }
}