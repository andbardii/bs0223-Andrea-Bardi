const url = 'http://localhost:8080/api/device';

document.addEventListener("DOMContentLoaded", () => {
    getDevices();
})

const getDevices = () => {
    const cont = document.getElementById('cont');
    let user =  JSON.parse(localStorage.getItem('user'));
    let devices = [];

    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${user.accessToken}`,
            'Content-type': 'application/json; charset=UTF-8'}
    }).then(response => response.json()).then(data => {
        devices = data;
        devices.forEach(device => {
            const card = document.createElement('div');
            card.classList.add('col-4', 'p-5');
            const cardContent = `
            <div class="card shadow">
            <div class="card-body">
             <h4 class="card-title">Device N° <span class="h4">${device.id}</span></h4>
                <p class="card-text">Type: <span>${device.devType}</span></p>
                <p class="card-text">Status: <span>${device.status}</span></p>
            </div>
            </div>
            `;
            card.innerHTML = cardContent;
        
            cont.appendChild(card); // Aggiungi la card al contenitore
        });
    }).catch(error => {
        console.error(error);
    });

}