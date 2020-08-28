function Human (name, gender, weight) {
    this.name = name;
    this.gender = gender;
    this.weight = weight;
    this.isMale = function () {
        return this.gender;
    }
    this.setGender = function (gender) {
        this.gender = gender;
    }
    this.getName = function () {
        return this.name;
    }
    this.setName = function (name) {
        this.name = name;
    }
    this.getWeight = function () {
        return this.weight;
    }
    this.setWeight = function (weight) {
        this.weight = weight;
    }
    this.checkApple = function (apple) {
        if (apple.isEmpty()) {
            return false;
        }
        return true;
    }
    this.eatApple = function (apple) {
        if (this.checkApple(apple)) {
            this.weight++;
            apple.decrease();
        }
    }
    this.say = function () {
        document.write("Hello! Minh dung day tu chieu!");
    }
}
