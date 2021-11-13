document.querySelector('#btn').onclick = () => {
    const username = document.querySelector('#username').value;
    const password = document.querySelector('#password').value;
    const errorSpan = document.querySelector('#error');

    const isValid = password.length >= 6 && password.length <= 10;

    let adminGivesPromise = new Promise ((resolve, reject) => {
        if (isValid){
            resolve("uspeh.html");
        } else {
            reject("Password mora imati od 6 do 10 karaktera");
        }
    });

    adminGivesPromise.then((message) => {
        window.location.href = message;
    }).catch((error) => {
        errorSpan.innerHTML = `Password mora imati od 6 do 10 karaktera!`;
    });


}


