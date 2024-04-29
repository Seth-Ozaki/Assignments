// This assignment will ask you to recall what you have learned abou the new syntax,
//  rules, and techniques associated with modern JS topics like destructuring, scope, and the spread operator.
// You will be asked to predict the output of each code block and answer questions in the checklist below about some of the problems.

// Each code block, along with predictions and question answers should be included in your .js file.

// Problem 1

// const cars = ['Tesla', 'Mercedes', 'Honda'];
// const [randomCar] = cars;
// const [, otherRandomCar] = cars;
// //Predict the output
// console.log(randomCar); // should log tesla
// console.log(otherRandomCar); // should log mercedes

//Problem 2

// const employee = {
//     employeeName: 'Elon',
//     age: 47,
//     company: 'Tesla'
// };
// const { employeeName: otherName } = employee;
// //Predict the output
// console.log(otherName); // should print 'Elon"
// console.log(employeeName); // should error out (employeeName is not whithin this codes scope)

//Problem 3

// const person = {
//     name: 'Phil Smith',
//     age: 47,
//     height: '6 feet'
// };
// const password = '12345';
// const { password: hashedPassword } = person;
// //Predict the output
// console.log(password); // should print '12345'
// console.log(hashedPassword); //should show undefined because the key password didnt have a value to assign hashedPassword

//Problem 4

// const numbers = [8, 2, 3, 5, 6, 1, 67, 12, 2];
// const [, first] = numbers; // first = 2
// const [, , , second] = numbers; // second = 5
// const [, , , , , , , , third] = numbers; // third = 2
// //Predict the output
// console.log(first === second); // false
// console.log(first === third); //true

//Problem 5

// const lastTest = {
//     key: 'value',
//     secondKey: [1, 5, 1, 8, 3, 3]
// };
// const { key } = lastTest;
// const { secondKey } = lastTest;
// const [, willThisWork] = secondKey;
// //Predict the output
// console.log(key); // displays the whole object lastTest (value)
// console.log(secondKey); // displays the whole lastTest object as well (secondkey array)
// console.log(secondKey[0]); // should display 'value' (1)
// console.log(willThisWork); // should show secondKey array(5)

//Problem 6

// var beatles = ['Paul', 'George', 'John', 'Ringo'];
// function printNames(names) {
//     function actuallyPrintingNames() {
//         for (var index = 0; index < names.length; index++) {
//             var name = names[index];
//             console.log(name + ' was found at index ' + index); // show each name at their index value
//         }
//         console.log('name and index after loop is ' + name + ':' + index); // ringo and 3 should print from this (4 not 3)
//     }
//     actuallyPrintingNames();
// }
// printNames(beatles);

//Problem 7

// function actuallyPrintingNames() {
//     for (let index = 0; index < names.length; index++) {
//         let name = names[index];
//         console.log(name + ' was found at index ' + index); // this will error since nothing is being passed into the funciton
//     }
//     console.log('name and index after loop is ' + name + ':' + index);// will error cause names is not defined
// }
// //this will print nothing because the function was not invoked


//Problem 8

// const beatles = ['Paul', 'George', 'John', 'Ringo'];
// function printNames(names) {
//     function actuallyPrintingNames() {
//         for (let index = 0; index < names.length; index++) {
//             const name = names[index]; // wont error since it is being re-declared each itteration of the loop
//             console.log(name + ' was found at index ' + index); // will print the names and their indexes
//         }
//     }
//     actuallyPrintingNames();
// }
// printNames(beatles);


//Problem 9

// const planet = {
//     name: "Jupiter",
//     milesFromSun: 49849,
//     mass: 393983,
//     composition: ["gas", "liquid", "oxygen"]
// };
// const planetCopy = { ...planet };
// console.log(planet.composition[0] === planetCopy.composition[0]); // true
// console.log(planet === planetCopy); //true because nothing has been altered yet? (false, no way to compare two objects having the same data this way, objects have different pointers in memory which would make comparing these two false) 