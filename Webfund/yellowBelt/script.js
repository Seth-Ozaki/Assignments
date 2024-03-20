function shopping() {
    window.alert('your cart is empty!');
}

function hover(element) {
    element.src = './images/plant.jpg';
}

function hoverOut(element) {
    element.src = './images/succulents-1.jpg';
}

function accepted() {
    var popup = document.querySelector('.popup');
    popup.remove();
}