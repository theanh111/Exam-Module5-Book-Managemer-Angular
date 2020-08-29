function Hero(image, top, left, size) {
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;

    this.getHeroElement = function () {
        return '<img width="' + this.size + '"' + 'height="' + this.size + '"' + 'src="' + this.image + '"' + 'style="top:' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
    }

    this.show = function (ctx) {
        let image = new Image();
        let xPosition = this.xPosition;
        let yPosition = this.yPosition;
        image.onload = function () {
            ctx.drawImage(image, xPosition, yPosition);
        };
        image.src = 'https://media.tenor.com/images/3249f25494e15f805e8f44e2549106b1/tenor.gif' + this.image;
    }

    this.moveRight = function () {
        this.left += 200;
        console.log('ok: ' + this.left);
    }

    this.moveLeft = function () {
        this.left -= 200;
    }

    this.moveUp = function () {
        this.top -= 50;
    }

    this.moveDown = function () {
        this.top += 50;
    }

}

let hero = new Hero('https://media.tenor.com/images/3249f25494e15f805e8f44e2549106b1/tenor.gif', 200, 200, 100);

function start() {
    if (hero.left <= window.innerWidth - 200 && hero.top <= 200) {
        hero.moveRight();
    } else if (hero.left >= window.innerWidth - 200 && hero.top <= window.innerHeight - 200) {
        hero.moveDown();
    } else if (hero.left >= 200 && hero.top >= window.innerHeight - 200) {
        hero.moveLeft();
    } else if (hero.left <= 200 && hero.top <= window.innerWidth - 200) {
        hero.moveUp();
    }

    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
}

start();
