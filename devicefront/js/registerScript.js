const url = 'http://localhost:8080/api/auth';

document.addEventListener("DOMContentLoaded", () => {
    const registerBtn = document.querySelector("#registerForm button");
    registerBtn.addEventListener("click", register);
})

const register = () => {
    const form = document.querySelectorAll("#registerForm");
    let name = form[0][0].value;
    let email = form[0][1].value;
    let username = form[0][2].value;
    let password = form[0][3].value;
    

    let obj = {
        name: name, 
        email: email,  
        username: username,  
        password: password
    }

    console.log(obj); 
   
    fetch(url+'/register', {
        method: 'POST',
        headers: {'Content-type': 'application/json; charset=UTF-8'},
        body: JSON.stringify(obj)
    }).then(response => console.log(response))

}