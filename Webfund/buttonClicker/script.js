function login(element) {
    if (element.innerText === 'Login') {
        element.innerText = 'Logout';
    } else if (element.innerText === 'Logout') {
        element.innerText = 'Login';
    }


}

function liked(element) {
    window.alert('Ninja was liked');
    element.value++;
    element.innerText = element.value + " Likes";
}


function bye(element) {
    element.remove();
}