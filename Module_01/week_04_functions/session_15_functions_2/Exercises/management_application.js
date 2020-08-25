let display = document.getElementById("table");
let drinksName = ["Cafe Sữa Đá",
    "Cafe Kem Cheese",
    "Cafe Đen",
    "Bạc Sỉu",
    "Cafe Kem Đá Xay",
    "Capucchino",
    "Matcha Latte",
    "Chocolate Latte",
    "Cacao"];
drawTable(drinksName);

function drawTable(array) {
    let table;
    table = "<table>";
    table = table + "<tr>" +
                             "<th width='10px'>No.1</th>" +
                             "<th>Drink(s)</th>" +
                             "<th></th>" +
                             "<th style='text-align: right'>" + "Total: " + array.length + "&nbsp;" + "Drink(s)" + "</th>" +
                    "</tr>";
    for (let i = 0; i < array.length; i++) {
        table = table + "<tr>";
        table = table + "<th>" + [i + 1] + "</th>";
        table = table + "<td>" + array[i] + "</td>";
        table = table + "<td>" +  "<button onclick='editDrinks("+ i +");'>Edit" + "</button>" + "</td>";
        table = table + "<td>" +  "<button onclick='deleteDrinks("+ i +");'>Delete" + "</button>" + "</td>";
        table = table + "</tr>";
    }
    table = table + "</table>"
    display.innerHTML = table;
}

function addDrinks() {
    let inputDrink = document.getElementById("adddrinks").value;
    drinksName[drinksName.length] = inputDrink;
    if (inputDrink === "" || inputDrink === " ") {
        alert("Please input name of your drink!");
    } else {
        drawTable(drinksName);
    }

}


function editDrinks(currentIndex) {
    let editName = prompt("Changing your drink's name here: ","");
    drinksName[currentIndex] = editName;
    if (editName === "" || editName === " ") {
        alert("Please type something!");
    }
    drawTable(drinksName);
}

function deleteDrinks(index) {
    let deleteConfirm = confirm("Are you sure about that?!!");
    if (deleteConfirm) {
        drinksName.splice(index, 1);
        alert("You have deleted your drink!");
    } else {
        alert("You haven't deleted your drink!");
    }
    drawTable(drinksName);
}