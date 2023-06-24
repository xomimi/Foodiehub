// script.js
document
    .getElementById("review-form")
    .addEventListener("submit", function (event) {
        event.preventDefault();

        var name = document.getElementById("name").value;
        var rating = document.getElementById("rating").value;
        var comments = document.getElementById("comments").value;

        var review = {
            name: name,
            rating: rating,
            comments: comments,
        };

        // Code to store the review or send it to a server for processing

        displayReview(review);
        calculateAverageRating();

        // Reset form fields
        document.getElementById("name").value = "";
        document.getElementById("rating").value = "";
        document.getElementById("comments").value = "";
    });

document.querySelectorAll(".star").forEach(function (star) {
    star.addEventListener("click", function () {
        var rating = this.getAttribute("data-rating");
        document.getElementById("rating").value = rating;
        highlightStars(rating);
    });
});

function displayReview(review) {
    var reviewElement = document.createElement("div");
    reviewElement.classList.add("review");

    var html = "<h3>" + review.name + "</h3>";
    html += "<p>Rating: " + review.rating + " stars</p>";
    html += "<p>" + review.comments + "</p>";

    reviewElement.innerHTML = html;

    document.getElementById("reviews-container").appendChild(reviewElement);
}

function calculateAverageRating() {
    var reviews = document.querySelectorAll(".review");
    var totalRating = 0;

    for (var i = 0; i < reviews.length; i++) {
        var rating = parseInt(
            reviews[i].querySelector("p:nth-child(2)").textContent.split(":")[1]
        );
        totalRating += rating;
    }

    var averageRating = totalRating / reviews.length;

    document.getElementById("average-rating").textContent =
        "Average Rating: " + averageRating.toFixed(1) + " stars";
}

function highlightStars(rating) {
    var stars = document.querySelectorAll(".star");

    for (var i = 0; i < stars.length; i++) {
        if (i < rating) {
            stars[i].classList.add("highlight");
        } else {
            stars[i].classList.remove("highlight");
        }
    }
}

// script.js
document
    .getElementById("review-form")
    .addEventListener("submit", function (event) {
        event.preventDefault();

        // Rest of the code to capture and store the review

        // Redirect to the home page
        window.location.href =
            "C:UsersAcerDesktopFood WebsiteFood Websiteindex.html";
    });
