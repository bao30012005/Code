using BusinessObjects;
using Repositories;
using System.Collections.Generic;

namespace Services
{
    public class RoomTypeService : IRoomTypeService
    {
        private readonly IRoomTypeRepository repo = new RoomTypeRepository();

        public void Add(RoomType type) => repo.Add(type);
        public void Delete(int id) => repo.Delete(id);
        public List<RoomType> GetAll() => repo.GetAll();
        public RoomType GetById(int id) => repo.GetById(id);
        public void Update(RoomType type) => repo.Update(type);
    }
}