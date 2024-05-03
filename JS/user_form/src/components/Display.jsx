
export const Display = (props) => {
    return (
        <div>
            <h3>Users:</h3>
            <div>
                {
                    props.users.map((user, idx) => {
                        return (
                            <div key={idx}>
                                <p>Name: {user.firstName} {user.lastName} ({user.email})</p>
                            </div>
                        );
                    })
                }
            </div>
        </div>
    );
};
