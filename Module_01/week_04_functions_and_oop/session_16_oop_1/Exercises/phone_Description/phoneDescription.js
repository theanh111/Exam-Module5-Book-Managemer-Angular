function Mobile() {
    this.battery = 100;
    this.status = false;
    this.composeMemory = "";
    this.sentMemory = "";
    this.messMemory = "";

    this.decreaseBattery = function (battery) {
        document.getElementById(battery).innerHTML = this.battery;
        this.battery--;
    }

    this.turnOn = function (id) {
        if (this.status !== true) {
            alert("This device has turn on!");
            document.getElementById(id).innerHTML = "ON";
            this.status = true;
            this.checkStatus();
        }
    }

    this.turnOff = function (id) {
        if (this.status !== true) {
            alert("This device has turn off!");
            document.getElementById(id).innerHTML = "OFF";
            this.status = false;
            this.checkStatus();
        }
    }

    this.checkStatus = function () {
        if (this.status) {
            alert("Status: ON!");
        } else {
            alert("Status: OFF!");
        }
    }

    this.chargeMobile = function (id) {
        if (this.battery === 100) {
            alert("Full Battery!");
        } else {
            document.getElementById(id).innerHTML = "Charging";
            for (let i = 0; i < this.battery; i++) {
                this.battery++;
            }
        }
        // setInterval(this.chargeMobile(),2000);
    }

    this.composeMess = function (input, display) {
        this.composeMemory = document.getElementById(input).value;
        document.getElementById(display).innerHTML = this.composeMemory;
    }

    this.sentMess = function (input, send, device) {
        this.sent = document.getElementById(input).value;
        document.getElementById(device).innerHTML = this.sent;
        this.decreaseBattery();
    }
}