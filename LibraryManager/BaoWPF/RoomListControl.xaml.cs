using BusinessObjects;
using Services;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;

namespace BaoWPF
{
    public partial class RoomListControl : UserControl
    {
        private readonly IRoomService roomService;
        private readonly IRoomTypeService roomTypeService;

        public RoomListControl()
        {
            InitializeComponent();
            roomService = new RoomService();
            roomTypeService = new RoomTypeService();
            LoadRooms();
        }

        private void LoadRooms()
        {
            dgRooms.ItemsSource = roomService.GetAll();
        }

        private void btnAdd_Click(object sender, RoutedEventArgs e)
        {
            var window = new AddEditRoomWindow(); // sẽ tạo file này sau
            if (window.ShowDialog() == true)
            {
                LoadRooms();
            }
        }

        private void btnEdit_Click(object sender, RoutedEventArgs e)
        {
            if (dgRooms.SelectedItem is RoomInformation selected)
            {
                var window = new AddEditRoomWindow(selected); // truyền phòng cần sửa
                if (window.ShowDialog() == true)
                {
                    LoadRooms();
                }
            }
        }

        private void btnDelete_Click(object sender, RoutedEventArgs e)
        {
            if (dgRooms.SelectedItem is RoomInformation selected)
            {
                var result = MessageBox.Show("Are you sure to delete this room?", "Confirm", MessageBoxButton.YesNo);
                if (result == MessageBoxResult.Yes)
                {
                    roomService.Delete(selected.RoomId);
                    LoadRooms();
                }
            }
        }
    }
}