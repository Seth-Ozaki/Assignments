import express from "express";
import { faker } from "@faker-js/faker";

const app = express();
const port = 8000;

app.use(express.json());

const createUser = () => {
    const newUser = {
        password: faker.internet.password(),
        email: faker.internet.email(),
        phoneNumber: faker.phone.number(),
        lastName: faker.person.lastName(),
        firstName: faker.person.firstName(),
        _id: faker.string.numeric(2, { bannedDigits: [0] })
    };
    return newUser;
};

const createCompany = () => {
    const newCompany = {
        _id: faker.string.numeric(2, { bannedDigits: [0] }),
        name: faker.company.name(),
        address: {
            street: faker.location.street(),
            city: faker.location.city(),
            state: faker.location.state(),
            zipCode: faker.location.zipCode(),
            country: faker.location.country()
        }
    };
    return newCompany;
};

app.get("/api/users/new", (req, res) => {
    res.json(createUser());
});
app.get("/api/company/new", (req, res) => {
    res.json(createCompany());
});
app.get("/api/company/user", (req, res) => {
    let both = [createCompany(), createUser()];
    res.json(both);
});

app.listen(port, () => { console.log(`Server is running on ${port}`); });