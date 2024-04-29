// This assignment will ask you to recall what you have learned about the
// new syntax, rules, and techniques associated with ES6 topics like arrow functions and the ternary operator.
// You will be given directions to write code that tests your knowledge of these skills.

//Ninja Challenge!
// To increase the difficulty, try to write each of your solutions as implicit returns with the least amount of characters possible.
// Look back to the rules of arrow functions and how we can simplify them further.


//Problem 1
// Write an arrow function that checks to see if a user is older than 18.
// If they are older than 18, the output should be:
// "You are good to go!"
// If they are not older than 18, the output should be
// "Sorry! You must be 18 or older!"
// The conditional logic should be written with a ternary operator.

// const ofAge = (age) => {
//     return age >= 18 ?
//         "You are good to go!"
//         : "Sorry! You must be 18 or older!";
// };

//Ninja challenge
// const ofAge = (age) => age >= 18 ? "You are good to go!" : "Sorry! You must be 18 or older!";

// console.log(ofAge(18));
// console.log(ofAge(17));

//Problem 2
// Write an arrow function that checks to see if it is currently raining.
// If it is raining, the output should be:
// "Get your rain jacket!"
// If it is not raining, the output should be:
// "No rain on today's forecast!"
// The conditional logic should be written with a ternary operator.

// const raining = (answer) => {
//     return answer === true ?
//         "Get your rain jacket!"
//         : "No rain on today's forecast!";
// };

//Ninja challenge
// const raining = (answer) => answer === true ? "Get your rain jacket!" : "No rain on today's forecast!";

// console.log(raining(true));
// console.log(raining(false));

//Problem 3
// Write an arrow function that checks to see if a number is even.
// If it is even, the output should be:
// "That's an even number!"
// If it is not even, the output should be:
// "That's an odd number!"
// The conditional logic should be written with a ternary operator.

// const even = (num) => {
//     return num % 2 === 0 ?
//         "That's an even number!"
//         : "That's an odd number!";
// };

//Ninja challenge
// const even = (num) => num % 2 === 0 ? "That's an even number!" : "That's an odd number!";

// console.log(even(1));
// console.log(even(2));


//Problem 4
// Write an arrow function that takes in two parameters and checks whether one number is greater than another.
// If the number is greater, the output should be:
// "<<NUMBER HERE>> is more than <<SECOND NUMBER HERE>>!"
// If the number is less than the other number, the output should be:
// "<<NUMBER HERE>> is less than <<SECOND NUMBER HERE>>!"
// The conditional logic should be written with a ternary operator.

// const compare = (val1, val2) => {
//     return val1 > val2 ?
//         `${val1} is more than ${val2}!`
//         : `${val2} is more than ${val1}!`;
// };

//Ninja challenge
// const compare = (val1, val2) => val1 > val2 ? `${val1} is more than ${val2}!` : `${val2} is more than ${val1}!`;

// console.log(compare(1, 2));
// console.log(compare(3, 1));
