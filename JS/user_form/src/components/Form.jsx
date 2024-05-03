import { useState } from "react";
import { Display } from "./Display";


export const Form = () => {
    const [users, setUsers] = useState([]);
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [submitted, setSubmited] = useState(false);

    const createUser = (e) => {
        e.preventDefault();
        if ((firstNameError || !firstName) || (lastNameError || !lastName) || (emailError || !email) || (passwordError || !password) || (confirmPasswordError || !confirmPassword)
        ) {
            return;
        }
        const user = { firstName, lastName, email, password };
        setUsers([...users, user]);
        setFirstName("");
        setLastName("");
        setEmail("");
        setPassword("");
        setConfirmPassword("");
        setSubmited(true);
    };
    const isSubmited = () => {
        return submitted ?
            "Thank you for submiting a user!"
            : "Welcome, Create a User!";
    };
    const firstNameError = firstName.length < 2 && firstName.length > 0 ? "You need a first name longer than 2 characters" : "";
    const lastNameError = lastName.length < 2 && lastName.length > 0 ? "You need a last name longer than 2 characters" : "";
    const emailError = email.length < 8 && email.length > 0 ? "Email needs 8 characters" : "";
    const passwordError = password.length < 8 && password.length > 0 ? "Password needs 8 characters" : "";
    const confirmPasswordError = confirmPassword.length > 0 && confirmPassword != password ? "Passwords do not match" : "";


    return (
        <>
            <form onSubmit={createUser}>
                <h3>{isSubmited()}</h3>
                <div>
                    <label>First Name: </label>
                    <input type="text" value={firstName} onChange={(e) => setFirstName(e.target.value)} /> <br />
                    {firstNameError}
                </div>
                <div>
                    <label>Last Name: </label>
                    <input type="text" value={lastName} onChange={(e) => setLastName(e.target.value)} /><br />
                    {lastNameError}
                </div>
                <div>
                    <label>Email: </label>
                    <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} /><br />
                    {emailError}
                </div>
                <div>
                    <label>Password: </label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} /> <br />
                    {passwordError}

                </div>
                <div>
                    <label>Confirm Password: </label>
                    <input type="password" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} /><br />
                    {confirmPasswordError}
                </div>

                <input type="submit" />
            </form>

            <Display users={users} />
        </>
    );
};