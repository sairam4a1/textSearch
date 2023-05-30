import React from 'react';


const HighlightMatchedContent = ({content, searchString}) => {

    if (!searchString) {
        return content;
    }
    const regex = new RegExp(`(${searchString})`, 'ig');
    const parts = content.split(regex);
    return parts.map((part, index) => {
        if (part.match(regex)) {
            return <span key={index} style={{ backgroundColor: "yellow" }}>{part}</span>;
        }
        return part;
    });

};

export default HighlightMatchedContent;