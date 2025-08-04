using BusinessObjects;
using Services;
using System;
using System.Windows;

namespace BaoWPF
{
    public partial class AddEditRoomWindow : Window
    {
        private readonly IRoomService roomService;
        private readonly IRoomTypeService roomTypeService;

        private readonly RoomInformation editingRoom;

        public AddEditRoomWindow(RoomInformation room = null)
        {
            InitializeComponent();
            roomService = new RoomService();
            roomTypeService = new RoomTypeService();

            LoadRoomTypes();

            editingRoom = room;
            if (editingRoom != null)
            {
                txtNumber.Text = editingRoom.RoomNumber;
                txtDesc.Text = editingRoom.RoomDescription;
                txtCapacity.Text = editingRoom.RoomMaxCapacity.ToString();
                txtPrice.Text = editingRoom.RoomPricePerDate.ToString();
                txtStatus.Text = editingRoom.RoomStatus.ToString();
                cbType.SelectedValue = editingRoom.RoomTypeId;
            }
            else
            {
                txtStatus.Text = "1"; // default Active
            }
        }

        private void LoadRoomTypes()
        {
            cbType.ItemsSource = roomTypeService.GetAll();
        }

        private void btnSave_Click(object sender, RoutedEventArgs e)
        {
            if (!int.TryParse(txtCapacity.Text, out int capacity) || capacity <= 0 ||
                !decimal.TryParse(txtPrice.Text, out decimal price) ||
                !int.TryParse(txtStatus.Text, out int status) ||
                cbType.SelectedValue == null)
            {
                MessageBox.Show("Please fill all field.");
                return;
            }

            if (roomService.RoomNumberExists(txtNumber.Text.Trim(), editingRoom?.RoomId))
            {
                MessageBox.Show("Room number already exists. Please use another one.");
                return;
            }

            if (editingRoom == null)
            {
                var room = new RoomInformation
                {
                    RoomNumber = txtNumber.Text,
                    RoomDescription = txtDesc.Text,
                    RoomMaxCapacity = capacity,
                    RoomPricePerDate = price,
                    RoomStatus = status,
                    RoomTypeId = (int)cbType.SelectedValue
                };
                roomService.Add(room);
            }
            else
            {
                editingRoom.RoomNumber = txtNumber.Text;
                editingRoom.RoomDescription = txtDesc.Text;
                editingRoom.RoomMaxCapacity = capacity;
                editingRoom.RoomPricePerDate = price;
                editingRoom.RoomStatus = status;
                editingRoom.RoomTypeId = (int)cbType.SelectedValue;

                roomService.Update(editingRoom);
            }

            DialogResult = true;
        }

        private void btnCancel_Click(object sender, RoutedEventArgs e)
        {
            DialogResult = false;
        }
    }
}