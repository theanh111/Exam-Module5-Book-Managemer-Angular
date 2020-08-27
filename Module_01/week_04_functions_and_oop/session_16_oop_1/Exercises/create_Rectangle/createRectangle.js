let CreateRectangle = function (height, width) {
    this.height = height;
    this.width = width;
    this.getArea = function() {
        return height * width;
    }
    this.getPerimeter = function() {
        return (height + width) * 2;
    }
    this.displayRect = function() {
        let ctx = document.getElementById("myCanvas").getContext("2d");
        ctx.beginPath();
        ctx.lineWidth = "2";
        ctx.strokeStyle = "blue";
        ctx.rect(20, 20, width, height);
        ctx.stroke();
    }
}

function drawRect() {
    let displayArea = document.getElementById("area");
    let displayPerimeter = document.getElementById("perimeter");
    let height = +prompt("Enter CreateRectangle's height: ","");
    let width = +prompt("Enter CreateRectangle's width: ", "");
    while (height < 0 || width < 0) {
        height = +prompt("Please enter CreateRectangle's height bigger than 0: ","");
        width = +prompt("Please enter CreateRectangle's width than 0: ", "");
    }
    let rect = new CreateRectangle(height, width);
    let area = rect.getArea();
    let perimeter = rect.getPerimeter();
    displayArea.innerHTML = "- Area is: " + height + " x " + width + " = " + area;
    displayPerimeter.innerHTML = "- Perimeter is: "  + "(" + height + " + " + width + ")" + "/2" + " = " + perimeter;
    rect.displayRect();
}

function reset() {
    window.location.reload();
}