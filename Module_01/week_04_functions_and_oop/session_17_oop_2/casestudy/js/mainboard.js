let displayIncomeTable = document.getElementById("tableIncome");
let displayExpensesTable = document.getElementById("tableExpenses");
let income = new Income();
let expenses = new Expenses();

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
        table = "<table cellpadding='5'>";
        table += "<tr>" +
            "<th style='font-size: xx-large; color: #32CD32' colspan='6'>Income</th>" +
            "</tr>";
        for (let i = 0; i < titleArray.length; i++) {
            table += "<tr>";
            table += "<th class='order'>" + [i + 1] + ") " + "</th>";
            table += "<td class='incomeTitle' id='incomeTitle'>" + titleArray[i] + "</td>";
            table += "<td class='incomeMoney' id='incomeMoney'>" + '+ ' + moneyArray[i] + "</td>";
            table += "<td>" + "<button onclick='editIncome(" + i + ");'>Edit" + "</button>" + "</td>";
            table += "<td>" + "<button onclick='deleteIncome(" + i + ");'>Delete" + "</button>" + "</td>";
            table += "</tr>";
        }
        table += "</table>";
        displayIncomeTable.innerHTML = table;
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
        table = "<table cellpadding='5'>";
        table += "<tr>" +
            "<th style='font-size: xx-large; color: #d61b06' colspan='6'>Expenses</th>" +
            "</tr>";
        for (let i = 0; i < titleArray.length; i++) {
            table += "<tr>";
            table += "<th class='order'>" + [i + 1] + ") " + "</th>";
            table += "<td class='expensesTitle' id='expensesTitle'>" + titleArray[i] + "</td>";
            table += "<td class='expensesMoney' id='expensesMoney'>" + "- " + moneyArray[i] + "</td>";
            table += "<td>" + "<button onclick='editExpenses(" + i + ");'>Edit" + "</button>" + "</td>";
            table += "<td>" + "<button onclick='deleteExpenses(" + i + ");'>Delete" + "</button>" + "</td>";
            table += "</tr>";
        }
        table += "</table>"
        displayExpensesTable.innerHTML = table;
    }
}

function balance(id1, id2) {
    let balanceMoney = id1 - id2;
    document.getElementById("balanceMoney").innerHTML = balanceMoney + "$";
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
        income.sumIncome += (+income.incomeMoneyArr[i]);
    }
    balance(income.sumIncome, expenses.sumExpenses);
}

function addExpenses() {
    expenses.sumExpenses = 0;
    if (expenses.addExpensesTitle.value === "" || expenses.addExpensesTitle.value === " " || expenses.addExpensesMoney.value === "") {
        alert("Please Input Your Expense!");
    } else {
        expenses.expensesTitleArr.push(expenses.addExpensesTitle.value);
        expenses.expensesMoneyArr.push(parseInt(expenses.addExpensesMoney.value));
        expenses.drawExpensesTable(expenses.expensesTitleArr, expenses.expensesMoneyArr);
        expenses.addExpensesTitle.value = "";
        expenses.addExpensesMoney.value = "";
    }
    for (let i = 0; i < expenses.addExpensesMoney.length; i++) {
        expenses.sumExpenses += (+expenses.expensesMoneyArr[i]);
    }
    balance(income.sumIncome, expenses.sumExpenses);
}

function editIncome(index) {
    let editTitle = prompt("Edit Your Income Title: ", income.incomeTitleArr[index]);
    let editMoney = prompt("Edit Your Income Money: ", income.incomeMoneyArr[index]);
    income.incomeTitleArr[index] = editTitle;
    income.incomeMoneyArr[index] = editMoney;
    income.drawIncomeTable(income.incomeTitleArr, income.incomeMoneyArr);
}

function deleteIncome(index) {
    let deleteConfirm = confirm("Are you sure about that?!!");
    if (deleteConfirm) {
        income.incomeTitleArr.splice(index, 1);
        income.incomeMoneyArr.splice(index, 1);
        alert("You have deleted your income!");
    }
    income.drawIncomeTable(income.incomeTitleArr, income.incomeMoneyArr);
}

function editExpenses(index) {
    let editTitle = prompt("Edit Your Expense Title: ", expenses.expensesTitleArr[index]);
    let editMoney = prompt("Edit Your Expense Money: ", expenses.expensesMoneyArr[index]);
    expenses.expensesTitleArr[index] = editTitle;
    expenses.expensesMoneyArr[index] = editMoney;
    expenses.drawExpensesTable(expenses.expensesTitleArr, expenses.expensesMoneyArr);
}

function deleteExpenses(index) {
    let deleteConfirm = confirm("Are you sure about that?!!");
    if (deleteConfirm) {
        expenses.expensesTitleArr.splice(index, 1);
        expenses.expensesMoneyArr.splice(index, 1);
        alert("You have deleted your income!");
    }
    expenses.drawExpensesTable(expenses.expensesTitleArr, expenses.expensesMoneyArr);
}
