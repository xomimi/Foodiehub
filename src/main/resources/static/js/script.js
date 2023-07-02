document.getElementById('itemForm').addEventListener('submit', addItem);

function addItem(event) {
  event.preventDefault();

  // Get input values
  var itemName = document.getElementById('itemName').value;
  var itemDescription = document.getElementById('itemDescription').value;
  var itemImage = document.getElementById('itemImage').value;
  var price = document.getElementById('price').value;

  // Create a new item object
  var newItem = {
    name: itemName,
    description: itemDescription,
    image: itemImage
  };

  // Clear form fields
  document.getElementById('itemName').value = '';
  document.getElementById('itemDescription').value = '';
  document.getElementById('itemImage').value = '';

  // Send the new item to the server for processing (AJAX request)
  // You can add your server-side code here to handle the item addition
}
