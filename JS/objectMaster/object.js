//Object Master

// Some data we encounter will be immutable, meaning we can not modify it in place. 
// Using .map(), .filter(), and .forEach(), create new arrays with the below requirements met.

const pokemon = Object.freeze([
    { "id": 1, "name": "Bulbasaur", "types": ["poison", "grass"] },
    { "id": 5, "name": "Charmeleon", "types": ["fire"] },
    { "id": 9, "name": "Blastoise", "types": ["water"] },
    { "id": 12, "name": "Butterfree", "types": ["bug", "flying"] },
    { "id": 16, "name": "Pidgey", "types": ["normal", "flying"] },
    { "id": 23, "name": "Ekans", "types": ["poison"] },
    { "id": 24, "name": "Arbok", "types": ["poison"] },
    { "id": 25, "name": "Pikachu", "types": ["electric"] },
    { "id": 35, "name": "Clefairy", "types": ["normal"] },
    { "id": 37, "name": "Vulpix", "types": ["fire"] },
    { "id": 52, "name": "Meowth", "types": ["normal"] },
    { "id": 63, "name": "Abra", "types": ["psychic"] },
    { "id": 67, "name": "Machamp", "types": ["fighting"] },
    { "id": 72, "name": "Tentacool", "types": ["water", "poison"] },
    { "id": 74, "name": "Geodude", "types": ["rock", "ground"] },
    { "id": 87, "name": "Dewgong", "types": ["water", "ice"] },
    { "id": 98, "name": "Krabby", "types": ["water"] },
    { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
    { "id": 122, "name": "Mr. Mime", "types": ["psychic"] },
    { "id": 133, "name": "Eevee", "types": ["normal"] },
    { "id": 144, "name": "Articuno", "types": ["ice", "flying"] },
    { "id": 145, "name": "Zapdos", "types": ["electric", "flying"] },
    { "id": 146, "name": "Moltres", "types": ["fire", "flying"] },
    { "id": 148, "name": "Dragonair", "types": ["dragon"] }
]);

//Problem 1
// an array of pokémon objects where the id is evenly divisible by 3

// const divide = pokemon.filter((p) => {
//     return p.id % 3 === 0;
// });
// console.log(divide);

//Problem 2
// an array of pokémon objects that are "fire" type

// const fire = pokemon.filter((p) => {
//     return p.types[0] === "fire" || p.types[1] === "fire";
// });
// console.log(fire);

//Problem 3
//an array of pokémon objects that have more than one type

// const twoType = pokemon.filter((p) => {
//     return p.types.length > 1;
// });
// console.log(twoType);

//Problem 4
// an array with just the names of the pokémon

// const names = pokemon.map((p) => {
//     return p.name;
// });
// console.log(names);

//Problem 5
// an array with just the names of pokémon with an id greater than 99

// const idGreater = pokemon.filter((p) => {
//     return p.id > 99;
// }).map((p) => {
//     return p.name;
// });
// console.log(idGreater);

//Problem 6
// an array with just the names of the pokémon whose only type is poison

// const poison = pokemon.filter((p) => {
//     return p.types.length < 2 && p.types[0] === "poison";
// }).map((p) => {
//     return p.name;
// });
// console.log(poison);

//Problem 7
// an array containing just the first type of all the pokémon whose second type is "flying"

// const flying = pokemon.filter((p) => {
//     return p.types.length > 1 && p.types[1] === "flying";
// }).map((p) => {
//     return p.types[0];
// });

// console.log(flying);

//Problem 8
// a count of the number of pokémon that are "normal" type

// const normalCount = pokemon.filter((p) => {
//     return p.types[0] === "normal" || p.types[1] === "normal";
// });
// console.log(normalCount.length);

//Problem 9
//an array with all pokemon except the pokemon with the id of 148

// const exclude = pokemon.filter((p) => {
//     return p.id != 148;
// });

// console.log(exclude);

//Problem 10
// an array with all pokemon and for pokemon id: 35 replacing "normal" with "fairy"

// const changeOne = pokemon.map((p) => {
//     if (p.id === 35) {
//         return { ...p, types: ["fairy"] };
//     }
//     return p;
// });

// console.log(changeOne);
// console.log(pokemon);