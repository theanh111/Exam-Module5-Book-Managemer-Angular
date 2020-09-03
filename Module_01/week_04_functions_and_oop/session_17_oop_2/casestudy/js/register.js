let user = new Register();

class Register {
    constructor(username, password) {
        this.username = username;
        this.password = password;
    }
}

function register() {
    let email = document.getElementById("useremail").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if (email === "" || username === "" || password === "") {
        alert("Please Type Your Info!");
    } else {
        alert("Sign Up Sucessfully!");
        location.replace("login.html");
    }
}

// function register () {
//     let username = document.getElementById("username").value;
//     let password = document.getElementById("password").value;
//     let user = new User (username, password);
//     userManage.addUser(user);
//     userManage.saveData();
//     console.log(userManage.users);
// }
// let user = new User();