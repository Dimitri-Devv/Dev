import { useState } from "react";

function HookUseState() {
    const [count, setCount]= useState(0);

    const increment = () => {
        setCount((prevValue) => prevValue + 1)
    };

    const decrement = () => {
        setCount((prevValue) => prevValue - 1)
    }

    const reset = () => {
        setCount(0)
    }


    return (
        <>
    <h1>UseState : exemple compteur</h1>
    
    count avec UseState : {count}


    <button onClick={increment}>+</button>
    <button onClick={decrement}>-</button>
    <button onClick={reset}>Reset</button>
    
    </>
);
}

export default HookUseState;