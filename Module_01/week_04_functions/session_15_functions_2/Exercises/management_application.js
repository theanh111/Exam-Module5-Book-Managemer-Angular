let User = [];
let order = 0;
drawTable(User);

function drawTable(array) {
    let table;
    let row = array.length;
    let numbers = row;
    table = "<table>";
    table = table + "<tr>";
    table = table + "<th>" + "Order" + "</th>";
    table = table + "<th>" + "Drink(s) name" + "</th>";
    table = table + "<th>" + "</th>";
    table = table + "<th>" + numbers + " Drinks" + "</th>";
    table = table + "<th>" + "</th>";
    table = table + "</tr>";
    for (let i = 0; i < row; i++) {
        table = table + "<tr>";
        for (let j = 0; j < 4; j++) {
            table = table + "<td>" + array[i][j] + "</td>";
        }
        table = table + "</tr>";
    }
    document.getElementById("table").innerHTML = table;
}

function addProducts() {

}


function editProducts() {

}

function deleteProducts() {

}