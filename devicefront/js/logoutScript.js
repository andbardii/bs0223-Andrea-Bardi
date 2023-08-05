document.addEventListener("DOMContentLoaded", () => {
    const loginBtn = document.querySelector("#logout");
    loginBtn.addEventListener("click", logout);
})

const logout = () => {
    localStorage.clear();
    window.location.href = "login.html";
}