let Temperature = function (celcius) {
    this.convertF = function () {
        return celcius * 1.8 + 32;
    }
    this.convertKelvin = function () {
        return celcius + 273.15;
    }
}

function convertTemp() {
    let input = +document.getElementById("inputCelcius").value;
    if (input < -273) {
        alert("Please input again!");
    } else {
        let temp = new Temperature(input);
        document.getElementById("result1").innerHTML = temp.convertF();
        document.getElementById("result2").innerHTML = temp.convertKelvin();
    }

}