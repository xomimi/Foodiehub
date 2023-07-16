document.getElementById('bookingForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission

    // Get form values
    var name = document.getElementById('name').value;
    var date = document.getElementById('date').value;
    var time = document.getElementById('time').value;

    // Create request body
    var requestBody = {
        name: name,
        date: date,
        time: time
    };

    // Send POST request to backend
    fetch('/booking', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    })
        .then(function(response) {
            if (response.ok) {
                return response.json(); // Parse the response JSON
            } else {
                throw new Error('Failed to book table. Please try again.');
            }
        })
        .then(function(data) {
            // Display the booking details
            document.getElementById('bookingName').textContent = data.name;
            document.getElementById('bookingDate').textContent = data.date;
            document.getElementById('bookingTime').textContent = data.time;

            // Show the booking details section
            document.getElementById('bookingDetails').style.display = 'block';

            // Clear the form
            document.getElementById('bookingForm').reset();
        })
        .catch(function(error) {
            alert('An error occurred. Please try again later.');
            console.error('Error:', error);
        });
});
