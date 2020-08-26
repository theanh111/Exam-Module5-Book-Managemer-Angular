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


function displayDrinks() {
    drawTable(drinksName);
}

function drawTable(array) {
    let table;
    table = "<table>";
    table += "<tr>" +
        "<th width='10px'>No.1</th>" +
        "<th>Drink(s)</th>" +
        "<th></th>" +
        "<th style='text-align: right'>" + "Total: " + array.length + "&nbsp;" + "Drink(s)" + "</th>" +
        "</tr>";
    for (let i = 0; i < array.length; i++) {
        table += "<tr>";
        table += "<th>" + [i + 1] + "</th>";
        table += "<td>" + array[i] + "</td>";
        table += "<td>" + "<button onclick='editDrinks(" + i + ");'>Edit" + "</button>" + "</td>";
        table += "<td>" + "<button onclick='deleteDrinks(" + i + ");'>Delete" + "</button>" + "</td>";
        table += "</tr>";
    }
    table += "</table>"
    display.innerHTML = table;
}

function addDrinks() {
    let inputDrink = document.getElementById("adddrinks").value;
    if (inputDrink === "" || inputDrink === " ") {
        alert("Please input name of your drink!");
    } else {
        drinksName[drinksName.length] = inputDrink;
    }
    drawTable(drinksName);
}

// function checkInputDrink(drink) {
//     let specialChar = "~!@#$%^&*()_+";
//     for (let i = 0; i < drink.length; i++) {
//         if (specialChar.indexOf(drink[i]) >= 0)
//             return false;
//     }
//     return true;
// }
//
// function addDrinks() {
//     let inputDrink = document.getElementById("adddrinks").value;
//     if (inputDrink === "" || inputDrink === "&nbsp;") {
//         alert("Please input name of your drink!");
//     } else {
//         saveDrink(inputDrink);
//     }
// }
//
// function saveDrink(drink) {
//     if (!checkInputDrink(drink)) {
//         alert("Error! Please type again!");
//     } else {
//         drinksName.push(drink);
//         drawTable(drinksName);
//     }
// }

function editDrinks(index) {
    let editName = prompt("Edit your drink: ", drinksName[index]);
    drinksName[index] = editName;
    drawTable(drinksName);
}

function deleteDrinks(index) {
    let deleteConfirm = confirm("Are you sure about that?!!");
    if (deleteConfirm) {
        drinksName.splice(index, 1);
        alert("You have deleted your drink!");
    }
    drawTable(drinksName);
}