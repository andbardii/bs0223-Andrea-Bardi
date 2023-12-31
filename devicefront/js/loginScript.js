const url = 'http://localhost:8080/api/auth/login';

document.addEventListener("DOMContentLoaded", () => {
    const loginBtn = document.querySelector("#loginForm button");
    loginBtn.addEventListener("click", login);
})

const login = () => {
    const form = document.querySelectorAll("#loginForm");
    let username = form[0][0].value;
    let password = form[0][1].value;
    

    let obj = {
        username: username,  
        password: password
    }

    console.log(obj); 
   
    fetch(url, {
        method: 'POST',
        headers: {'Content-type': 'application/json; charset=UTF-8'},
        body: JSON.stringify(obj)
    }).then(response => response.json()).then(data => {
        localStorage.setItem('user', JSON.stringify(data));
        window.location.href = "home.html";
    }).catch(error => {
        console.error(error);
    });


}