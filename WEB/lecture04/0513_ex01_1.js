function getName() {
    while (true) {
        let text = prompt("이름을 입력해주세요");
        if (text == "") {
            text = "이름을 입력해주세요";
            alert(text);
        } else if (text == null) { //if user choose cancel -> break
            break;
        } else {
            text = text + "님 환영합니다";
            alert(text);
            break;
        }
    }

}

function getNum() {
    while(true) {
        var num = prompt("숫자를 입력해주세요");
        if (isNaN(num)) { //if value is not number type
            alert("숫자를 입력해주세요");
            console.log(num);
        } else if (typeof num == "object") { //if user choose cancel -> break
            break;
        } else if (num > 100 || num < 1) {
            console.log(typeof num);
            alert("1이상 100이하를 넣어주세요");
        } else {//if  1 <= number <= 100 : print log from 1 to 100 and alert
            console.log(typeof num);
            for (var i = 1; i <= 100; i++) {
                console.log(i);
            }
            alert("완료되었습니다");
            break;
        }
    }
}