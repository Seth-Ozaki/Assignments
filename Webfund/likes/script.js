function like1() {
    var element = document.querySelector('.num1');
    console.log(element);
    var number1 = element.innerHTML;
    ++number1;
    console.log(number1);
    document.querySelector('.num1').innerHTML = number1;
}

function like2() {
    var element = document.querySelector('.num2');
    console.log(element);
    var number2 = element.innerHTML;
    ++number2;
    console.log(number2);
    document.querySelector('.num2').innerHTML = number2;
}

function like3() {
    var element = document.querySelector('.num3');
    console.log(element);
    var number3 = element.innerHTML;
    ++number3;
    console.log(number3);
    document.querySelector('.num3').innerHTML = number3;
}
