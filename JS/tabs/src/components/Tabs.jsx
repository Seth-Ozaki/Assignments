import React from 'react';

export const Tabs = (props) => {
    const { tab } = props;
    return (
        <div>
            <button onClick={() => props.displayTab(props.index)}>{tab.name}</button>
        </div>
    );
};
