// const buttons = document.querySelectorAll(".bull");
// const content = document.querySelectorAll(".dashboard-content");
//
// buttons.forEach((btn, i) => {
//     btn.addEventListener("click", (e) => {
//         e.preventDefault();
//         console.log(buttons[i].textContent);
//         content.forEach((box, j) => {
//             if (j == i) {
//                 content[j].classList.remove("hidden");
//             } else {
//                 box.classList.add("hidden");
//             }
//         });
//     });
// });


const navbar = document.querySelector(".navbar");
const hamburger = document.querySelector(".hamburger");

hamburger.addEventListener("click", () => {
    navbar.classList.toggle("show");
});

const header = document.querySelector('.header');
const scrollLink = document.querySelectorAll('.navbar a:not(:last-child)');

Array.from(scrollLink).map((link) => {
    link.addEventListener('click', (e) => {
        // Prevent Default
        // e.preventDefault();
        console.log(e.target);

        const id = e.currentTarget.getAttribute('href').slice(1);
        const element = document.getElementById(id);
        let position = element.offsetTop - 90;

        window.scrollTo({
            left: 0,
            top: position,
            behavior: 'smooth',
        });
        navbar.classList.remove('show');
    });
});

const scrollTop = document.querySelector(".scroll-top");

scrollTop.addEventListener("click", () => {
    window.scrollTo({
        left: 0,
        top: 0,
        behavior: "smooth",
    });
});

window.addEventListener("scroll", (e) => {
    const scrollHeight = window.pageYOffset;

    if (scrollHeight > 300) {
        scrollTop.classList.add("show");
    } else {
        scrollTop.classList.remove("show");
    }
});

function fun(){
    alert("Successfully order item");
}
