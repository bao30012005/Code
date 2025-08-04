using BusinessObjects;
using System.Collections.Generic;

namespace Services
{
    public interface IRoomTypeService
    {
        List<RoomType> GetAll();
        RoomType GetById(int id);
        void Add(RoomType type);
        void Update(RoomType type);
        void Delete(int id);
    }
}