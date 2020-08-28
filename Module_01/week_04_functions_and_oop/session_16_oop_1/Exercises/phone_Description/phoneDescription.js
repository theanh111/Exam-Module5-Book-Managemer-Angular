function Mobile (id) {
    this.id = document.getElementById(id);
    this.battery = 100;
    this.status = false;
    this.composeMemory = "";
    this.sentMemory = "";
    this.messMemory = "";

    this.decreaseBattery = function () {
        this.battery--;
    }

    this.turnOn = function () {
        if (this.status !== true) {
            alert("The deivce has turn on!");
            this.id.innerHTML = "ON";
            this.status = true;
            this.checkStatus();
        }
    }

    this.turnOff = function () {
        if (this.status !== true) {
            alert("The deivce has turn off!");
            this.id.innerHTML = "OFF";
            this.status = false;
            this.checkStatus();
        }
    }

    this.checkStatus = function () {
        if (this.status) {
            alert("ON!");
        } else {
            alert("OFF!");
        }
    }

    this.chargeMobile = function () {

            if (this.battery === 100) {
                alert("Full Battery!");
            } else {
                this.id.innerHTML = "Charging";
                for (let i = 0; i < this.battery; i++) {
                    this.battery++;
                }
            }
            // setInterval(this.chargeMobile(),2000);
    }
}