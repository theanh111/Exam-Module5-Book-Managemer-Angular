class UserManage {
    constructor() {
        this.users = [];
    }

    addUser (user) {
        this.users.push(user);
    }
    saveData () {
        localStorage.setItem("user", JSON.stringify(this.users));
    }
    loadData () {
        this.users = JSON.parse(localStorage.getItem("user"));
    }
    checkLogin (username, password) {
        for (let i = 0; i < this.users.length; i++) {
            if (username === this.users[i].username && password === this.users[i].password) {
                return true;
            }
        }
        return false;
    }
}