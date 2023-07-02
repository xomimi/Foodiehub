// Get the sidebar and content elements
const sidebar = document.querySelector('.sidebar');
const content = document.querySelector('.content');

// Get the list items in the sidebar
const sidebarItems = sidebar.querySelectorAll('li');

// Add click event listeners to sidebar items
sidebarItems.forEach((item) => {
  item.addEventListener('click', (event) => {
    // Prevent default link behavior
    event.preventDefault();

    // Remove the 'active' class from all sidebar items
    sidebarItems.forEach((sidebarItem) => {
      sidebarItem.classList.remove('active');
    });

    // Add the 'active' class to the clicked sidebar item
    item.classList.add('active');

    // Get the href of the clicked sidebar item
    const href = item.querySelector('a').getAttribute('href');

    // Load the corresponding content page using AJAX or fetch API
    loadContentPage(href);
  });
});

// Function to load content page
function loadContentPage(url) {
  // Perform AJAX or fetch request to load the content page
  // Here's an example using fetch API
  fetch(url)
      .then((response) => response.text())
      .then((data) => {
        // Update the content section with the loaded page
        content.innerHTML = data;
      })
      .catch((error) => {
        console.log('Error loading page:', error);
      });
}
