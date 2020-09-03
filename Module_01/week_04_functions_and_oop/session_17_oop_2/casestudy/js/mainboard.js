let display1 = document.getElementById("tableIncome");
let display2 = document.getElementById("tableExpenses");
let income = new Income();
let expenses = new Expenses();
let balance = new Balance();

income.drawIncomeTable(income.incomeTitleArr, income.incomeMoneyArr);
expenses.drawExpensesTable(expenses.expensesTitleArr, expenses.expensesMoneyArr);

function Income() {
    this.addIncomeTitle = document.getElementById("addIncomeTitle");
    this.addIncomeMoney = document.getElementById("addIncomeMoney");
    this.sumIncome = 0;
    this.incomeTitleArr = [];
    this.incomeMoneyArr = [];
    this.drawIncomeTable = function (titleArray, moneyArray) {
        let table;
        table = "<table cellpadding='6'>";
        table += "<tr>" +
            "<th style='font-size: xx-large; color: #32CD32' colspan='6'>Income</th>" +
            "</tr>";
        for (let i = 0; i < titleArray.length; i++) {
            table += "<tr>";
            table += "<th class='order'>" + [i + 1] + ") " + "</th>";
            table += "<td class='incomeTitle' id='incomeTitle'>" + titleArray[i] + "</td>";
            table += "<td class='incomeMoney' id='incomeMoney'>" + '+ ' + moneyArray[i] + "</td>";
            table += "<td width='30%'>" + "</td>";
            table += "<td>" + "<button onclick='editIncome(" + i + ");'>Edit" + "</button>" + "</td>";
            table += "<td>" + "<button onclick='deleteIncome(" + i + ");'>Delete" + "</button>" + "</td>";
            table += "</tr>";
        }
        table += "</table>";
        display1.innerHTML = table;
    }
}

function Expenses() {
    this.addExpensesTitle = document.getElementById("addExpensesTitle");
    this.addExpensesMoney = document.getElementById("addExpensesMoney");
    this.sumExpenses = 0;
    this.expensesTitleArr = [];
    this.expensesMoneyArr = [];
    this.drawExpensesTable = function (titleArray, moneyArray) {
        let table;
        table = "<table cellpadding='6'>";
        table += "<tr>" +
            "<th style='font-size: xx-large; color: #d61b06' colspan='6'>Expenses</th>" +
            "</tr>";
        for (let i = 0; i < titleArray.length; i++) {
            table += "<tr>";
            table += "<th class='order'>" + [i + 1] + ") " + "</th>";
            table += "<td class='expensesTitle' id='expensesTitle'>" + titleArray[i] + "</td>";
            table += "<td class='expensesMoney' id='expensesMoney'>" + "- " + moneyArray[i] + "</td>";
            table += "<td width='30%'>" + "</td>";
            table += "<td>" + "<button onclick='editExpenses(" + i + ");'>Edit" + "</button>" + "</td>";
            table += "<td>" + "<button onclick='deleteExpenses(" + i + ");'>Delete" + "</button>" + "</td>";
            table += "</tr>";
        }
        table += "</table>"
        display2.innerHTML = table;
    }
}

function Balance() {
    this.calculateBalance = (income.sumIncome) - (expenses.sumExpenses);
    this.calculateDisplay = function () {
        if (isNaN(this.calculateBalance)) {
            document.getElementById("balanceMoney").innerHTML = "+ " + income.sumIncome + "$";
        } else {
            document.getElementById("balanceMoney").innerHTML = this.calculateBalance + "$";
        }
    }
}

function addIncome() {
    income.sumIncome = 0;
    if (income.addIncomeTitle.value === "" || income.addIncomeTitle.value === " " || income.addIncomeMoney.value === "") {
        alert("Please Input Your Income!");
    } else {
        income.incomeTitleArr.push(income.addIncomeTitle.value);
        income.incomeMoneyArr.push(parseInt(income.addIncomeMoney.value));
        income.drawIncomeTable(income.incomeTitleArr, income.incomeMoneyArr);
        income.addIncomeTitle.value = "";
        income.addIncomeMoney.value = "";
    }
    for (let i = 0; i < income.incomeMoneyArr.length; i++) {
        income.sumIncome += parseInt(income.incomeMoneyArr[i]);
    }
    balance.calculateDisplay();
}

function addExpenses() {
    expenses.sumExpenses = 0;
    if (expenses.addExpensesTitle.value === "" || expenses.addExpensesTitle.value === " " || expenses.addExpensesMoney.value === "") {
        alert("Please Input Your Income!");
    } else {
        expenses.expensesTitleArr.push(expenses.addExpensesTitle.value);
        expenses.expensesMoneyArr.push(parseInt(expenses.addExpensesMoney.value));
        expenses.drawExpensesTable(expenses.expensesTitleArr, expenses.expensesMoneyArr);
        expenses.addExpensesTitle.value = "";
        expenses.addExpensesMoney.value = "";
    }
    for (let i = 0; i < expenses.addExpensesMoney.length; i++) {
        expenses.sumExpenses += parseInt(expenses.expensesMoneyArr[i]);
    }
    balance.calculateDisplay();
}

function editIncome(index) {
    let editTitle = prompt("Edit your income title: ", incomeTitleArr[index]);
    let editMoney = prompt("Edit your income money");
    incomeTitleArr[index] = editTitle;
    incomeMoneyArr[index] = editMoney;
    drawIncomeTable(incomeTitleArr, incomeMoneyArr);
}

function deleteIncome(incomeTitleArr, incomeMoneyArr, index) {
    let deleteConfirm = confirm("Are you sure about that?!!");
    if (deleteConfirm) {
        incomeTitleArr.splice(index, 1);
        incomeMoneyArr.splice(index, 1);
        alert("You have deleted your income title!");
    }
    drawIncomeTable(incomeTitleArr, incomeMoneyArr);
}

function editExpenses(index) {
    let editTitle = prompt("Edit Your Income: ", incomeArr[index]);
    incomeArr[index] = editTitle;
    drawIncomeTable(incomeArr);
}

function deleteExpenses(index) {
    let deleteConfirm = confirm("Are you sure about that?!!");
    if (deleteConfirm) {
        incomeArr.splice(index, 1);
        alert("You have deleted your income title!");
    }
    drawIncomeTable(incomeArr);
}
