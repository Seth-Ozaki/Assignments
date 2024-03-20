
function nameChange() {
    var name = document.querySelector('.name');
    if (name.innerText == 'Jane Doe') {
        name.innerText = 'John Smith';
    } else if (name.innerText == 'John Smith') {
        name.innerText = 'Jane Doe';
    }
}

function decline() {
    var bye = document.querySelector('.friend');
    bye.remove();

    var elem = document.querySelector('#amount');
    var num = elem.innerHTML;
    --num;
    document.querySelector('#amount').innerHTML = num;
}

function accept() {
    var bye = document.querySelector('.friend');
    bye.remove();

    var elem = document.querySelector('#amount');
    var num = elem.innerHTML;
    --num;
    document.querySelector('#amount').innerHTML = num;

    var elem1 = document.querySelector('#amount1');
    var num1 = elem1.innerHTML;
    ++num1;
    document.querySelector('#amount1').innerHTML = num1;
}