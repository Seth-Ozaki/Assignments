import React from 'react';

export const Info = (props) => {
    const { tab } = props;
    return (
        <div>{tab.information}</div>
    );
};
